package tech.szymanskazdrzalik.fuzzy.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.szymanskazdrzalik.fuzzy.model.Accident;
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

    private static List<Accident> accidents;

    @Override
    public List<Accident> getAll(File file) throws IOException {
        if (Objects.isNull(accidents)) {
            accidents = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    try {
                        AccidentDTO accidentDTO = mapper.readValue(currentLine, AccidentDTO.class);
                        Accident accident = AccidentDTOToAccidentMapper.mapToStory(accidentDTO);
                        accidents.add(accident);
                    } catch (Exception e) {

                    }
                }
            }
        }
        // TODO: 06.05.2021  
        return accidents;
    }

    @Override
    public List<Accident> getAll(String path) throws IOException {
        return getAll(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)));
    }

    @Override
    public List<Accident> getAll(URL path) throws IOException {
        return getAll(new File(path.getPath()));
    }
}
