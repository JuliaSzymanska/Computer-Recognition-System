package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.apache.commons.lang3.tuple.MutableTriple;
import tech.szymanskazdrzalik.ksr.ksr1.dao.ResourcesArticleDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

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
        final int[] all = {0};
        double acc = 0;
        double prec = 0;
        double rec = 0;
        double f1_all = 0;

        map.forEach((s, integerIntegerIntegerMutableTriple) -> {
            all[0] += integerIntegerIntegerMutableTriple.left;
        });
        for (var x : ResourcesArticleDAO.getPlacesNames()) {
            // left - wszystkie elementy, middle - elementy dobrze zaklasyfikowane, right - elementy innych klas zaklasyfikowane do tej klasy
            var y = map.get(x);
            stringBuilder.append(x).append(":\n");
            // accuracy
            double accuracy = ((double)y.middle)/ y.left;
//            stringBuilder.append("Accuracy").append(": ").append(accuracy).append("\n");
            acc += accuracy * (((double)(y.left))/ all[0]);
            // Precision
            var precision = ((double)y.middle)/ (y.middle + y.right);
            prec += precision * (((double)(y.left))/ all[0]);
            stringBuilder.append("Precision").append(": ").append(precision).append("\n");
            // Recall
            var recall = ((double)y.middle)/ (y.left);
            rec += recall * (((double)(y.left))/ all[0]);
            stringBuilder.append("Recall").append(": ").append(recall).append("\n");
            // F1
            var f1 = (2.0 / ((1/precision) + (1/recall)));
            f1_all += f1 * (((double)(y.left))/ all[0]);
            stringBuilder.append("F1").append(": ").append(f1).append("\n");
            stringBuilder.append("----------------------------------\n");
        }
        stringBuilder.append("wszystkie").append(":\n");
        // accuracy
        stringBuilder.append("Accuracy").append(": ").append(acc).append("\n");
        stringBuilder.append("Precision").append(": ").append(prec).append("\n");
        stringBuilder.append("Recall").append(": ").append(rec).append("\n");
        stringBuilder.append("F1").append(": ").append(f1_all).append("\n");
        stringBuilder.append("----------------------------------\n");
        return stringBuilder.toString();
    }
}
