package tech.szymanskazdrzalik.fuzzy.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.utils.AccidentDTOToAccidentMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResourcesAccidentDao implements AccidentDAO {

    private static List<Wypadek> wypadeks;

    @Override
    public List<Wypadek> getAll(File file) throws IOException {
        if (Objects.isNull(wypadeks)) {
            wypadeks = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    try {
                        AccidentDTO accidentDTO = mapper.readValue(currentLine, AccidentDTO.class);
                        Wypadek wypadek = AccidentDTOToAccidentMapper.mapToStory(accidentDTO);
                        wypadeks.add(wypadek);
                    } catch (Exception e) {

                    }
                }
            }
        }
        // TODO: 06.05.2021  
        return wypadeks;
    }

    @Override
    public List<Wypadek> getAll(String path) throws IOException {
        return getAll(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)));
    }

    @Override
    public List<Wypadek> getAll(URL path) throws IOException {
        return getAll(new File(path.getPath()));
    }
}
