package tech.szymanskazdrzalik.ksr.ksr1.knn;

public class NGramMetric {
    private static final int nn = 2;

    public NGramMetric() {
    }

    public static double nGramMetric(String text1, String text2) {
//        int n = nn;
//        text1 = "lalu";
//        text2 = "lula";
//        text1 = text1.toLowerCase();
//        text2 = text2.toLowerCase();
//        String shorterText;
//        String longerText;
//        if (text1.length() > text2.length()) {
//            longerText = text1;
//            shorterText = text2;
//        } else {
//            longerText = text2;
//            shorterText = text1;
//        }
//
//        if (longerText.length() < nn) {
//            n = shorterText.length();
//        }
//        int gramCount = longerText.length() - n + 1;
//        int similarity = 0;
//
//        for (int i = 0; i < gramCount; i++) {
//            if (i + n <= shorterText.length()) {
//                for (int j = 0; j < longerText.length() - n; j++) {
//                    if (shorterText.substring(i, i + n).equals(longerText.substring(j, j + n))) {
//                        similarity += 1;
//                        break;
//                    }
//                }
//            } else {
//                break;
//            }
//        }
//
//
//
//        double v = (double) similarity / (double) gramCount;
        double x = Sorensen_Dice_Coefficient.diceCoefficientOptimized(text1, text2);
        return x;

    }

}
