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
        stringBuilder.append("----------------------------------\n");
        for (var x : ResourcesArticleDAO.getPlacesNames()) {
            // left - wszystkie elementy, middle - elementy dobrze zaklasyfikowane, right - elementy innych klas zaklasyfikowane do tej klasy
            var y = map.get(x);
            stringBuilder.append(x).append(":\n");
            // accuracy
            stringBuilder.append("Accuracy").append(": ").append(((double)y.middle)/ y.left).append("\n");
            // Precision
            var precision = ((double)y.middle)/ (y.middle + y.right);
            stringBuilder.append("Precision").append(": ").append(precision).append("\n");
            // Recall
            var recall = ((double)y.middle)/ (y.left);
            stringBuilder.append("Precision").append(": ").append(recall).append("\n");
            // F1
            var f1 = (2.0 / ((1/precision) + (1/recall)));
            stringBuilder.append("F1").append(": ").append(f1).append("\n");
            stringBuilder.append("----------------------------------\n");
        }
        return stringBuilder.toString();
    }
}
