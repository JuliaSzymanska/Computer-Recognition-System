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

    private static List<Wypadek> wypadek_severity_1;
    private static List<Wypadek> wypadek_severity_2;
    private static List<Wypadek> wypadek_severity_3;
    private static List<Wypadek> wypadek_severity_4;

    public static List<Wypadek> getWypadek_severity_1() {
        return wypadek_severity_1;
    }

    public static List<Wypadek> getWypadek_severity_2() {
        return wypadek_severity_2;
    }

    public static List<Wypadek> getWypadek_severity_3() {
        return wypadek_severity_3;
    }

    public static List<Wypadek> getWypadek_severity_4() {
        return wypadek_severity_4;
    }

    public static List<Wypadek> getWypadek_severity(int numer){
        switch (numer) {
            case 1:
                 return getWypadek_severity_1();
            case 2:
                return getWypadek_severity_2();
            case 3:
                return getWypadek_severity_3();
            case 4:
                return getWypadek_severity_4();
            default:
                throw new IllegalArgumentException("nu nu");
        }
    }

    @Override
    public List<Wypadek> getAll(File file) throws IOException {
        if (Objects.isNull(wypadeks)) {
            wypadeks = new ArrayList<>();
            wypadek_severity_1 = new ArrayList<>();
            wypadek_severity_2 = new ArrayList<>();
            wypadek_severity_3 = new ArrayList<>();
            wypadek_severity_4 = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    try {
                        AccidentDTO accidentDTO = mapper.readValue(currentLine, AccidentDTO.class);
                        Wypadek wypadek = AccidentDTOToAccidentMapper.mapToStory(accidentDTO);
                        wypadeks.add(wypadek);
                        switch (wypadek.getDotkliwosc()) {
                            case 1:
                                wypadek_severity_1.add(wypadek);
                                break;
                            case 2:
                                wypadek_severity_2.add(wypadek);
                                break;
                            case 3:
                                wypadek_severity_3.add(wypadek);
                                break;
                            case 4:
                                wypadek_severity_4.add(wypadek);
                                break;
                            default:
                                break;
                        }
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
