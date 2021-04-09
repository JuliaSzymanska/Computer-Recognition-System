package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.apache.commons.lang3.tuple.MutableTriple;
import tech.szymanskazdrzalik.ksr.ksr1.dao.ResourcesArticleDAO;

import java.util.HashMap;
import java.util.Map;

public class Results {
    private static final Map<String, MutableTriple<Integer, Integer, Integer>> map = new HashMap<>();
    private final static Results INSTANCE = new Results();

    private Results() {
        for (var x : ResourcesArticleDAO.getPlacesNames()) {
            // Triple : liczba wystapień, liczba tej klasy sklasyfikowanych jako ta kalasa, liczba innych klas sklasyfikowantych jako ta klasa
            map.put(x, MutableTriple.of(0, 0, 0));
        }
    }

    public static Map<String, MutableTriple<Integer, Integer, Integer>> getMap() {
        return map;
    }

    public static String generateResultString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var x : ResourcesArticleDAO.getPlacesNames()) {
            var y = map.get(x);

        }
        return stringBuilder.toString();
    }
}
