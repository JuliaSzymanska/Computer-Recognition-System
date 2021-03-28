package tech.szymanskazdrzalik.ksr.ksr1.knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CosMetric {

    private CosMetric() {

    }

    public static double cosMetric(String[] text1Array, String[] text2Array) {
        List<String> text1List = new ArrayList<>(Arrays.asList(text1Array));
        List<String> text2List = new ArrayList<>(Arrays.asList(text2Array));
        List<String> listOfWords = new ArrayList<>();
        for (String i : text1List) {
            if (!listOfWords.contains(i)) {
                listOfWords.add(i);
            }
        }
        for (String i : text2List) {
            if (!listOfWords.contains(i)) {
                listOfWords.add(i);
            }
        }
        int[] text1WordsCount = new int[listOfWords.size()];
        int[] text2WordsCount = new int[listOfWords.size()];
        for (int i = 0; i < listOfWords.size(); i++) {
            if (text1List.contains(listOfWords.get(i))) {
                text1WordsCount[i] += 1;
            }
            if (text2List.contains(listOfWords.get(i))) {
                text2WordsCount[i] += 1;
            }
        }
        return calculateCos(text1WordsCount, text2WordsCount);
    }

    public static double cosMetric(String text1, String text2) {
        return cosMetric(text1.split(" "), text2.split(" "));
    }

    private static double calculateCos(int[] text1WordsCount, int[] text2WordsCount) {
        int sum = 0;
        int sumOfSquaresText1 = 0;
        int sumOfSquaresText2 = 0;
        for (int i = 0; i < text1WordsCount.length; i++) {
            sum += text1WordsCount[i] * text2WordsCount[i];
            sumOfSquaresText1 += text1WordsCount[i] * text1WordsCount[i];
            sumOfSquaresText2 += text2WordsCount[i] * text2WordsCount[i];
        }
        return Math.abs(sum) / Math.sqrt(sumOfSquaresText1 * sumOfSquaresText2);
    }

}
