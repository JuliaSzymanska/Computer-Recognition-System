package tech.szymanskazdrzalik.fuzzy.utils;

import opennlp.tools.stemmer.PorterStemmer;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDTO;
import tech.szymanskazdrzalik.fuzzy.model.Accident;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AccidentDTOToAccidentMapper {
    private AccidentDTOToAccidentMapper() {
    }

    public static Accident mapToStory(AccidentDTO accidentDTO) {
        return new Accident(accidentDTO);
    }

    private static String[] tokenize(String toTokenize) {
        return Arrays.asList(toTokenize.trim().replaceAll("[\\p{Punct}&&[^_-]]+", "").split(" +")).toArray(String[]::new);
    }

    private static String[] stem(String[] toStem, PorterStemmer porterStemmer) {
        List<String> tmp = Arrays.asList(toStem);
        List<String> afterStem = new ArrayList<>();
        tmp.forEach(s -> afterStem.add(porterStemmer.stem(s)));
        return afterStem.toArray(String[]::new);
    }

}
