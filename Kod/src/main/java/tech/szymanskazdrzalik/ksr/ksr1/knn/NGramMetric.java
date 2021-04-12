package tech.szymanskazdrzalik.ksr.ksr1.knn;

import java.util.ArrayList;
import java.util.List;

public class NGramMetric {
    private static final int n = 2;

    public NGramMetric() {
    }

    public static double nGramMetric(String text1, String text2) {
        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();
        String shorterText;
        String longerText;
        if (text1.length() > text2.length()) {
            longerText = text1;
            shorterText = text2;
        } else {
            longerText = text2;
            shorterText = text1;
        }
        int gramCount = longerText.length() - n + 1;
        int similarity = 0;

        for (int i = 0; i < gramCount; i++) {
            if(i + n <= shorterText.length()){
                if(shorterText.substring(i, i + n).equals(longerText.substring(i, i + n))){
                    String a = shorterText.substring(i, i + n);
                    String b = longerText.substring(i, i + n);
                    similarity += 1;
                }
            } else{
                break;
            }
        }
        return (double)similarity/(double)gramCount;
    }

}
