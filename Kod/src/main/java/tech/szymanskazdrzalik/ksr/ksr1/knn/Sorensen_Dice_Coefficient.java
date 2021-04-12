package tech.szymanskazdrzalik.ksr.ksr1.knn;

import java.util.ArrayList;
import java.util.Collections;

public class Sorensen_Dice_Coefficient {

    private final static int n = 2;

    public static double compareStrings(String str1, String str2) {
        ArrayList<String> pairs1 = wordLetterPairs(str1.toUpperCase());
        ArrayList<String> pairs2 = wordLetterPairs(str2.toUpperCase());
        int intersection = 0;
        int union = pairs1.size() + pairs2.size();
        for (var pair1 : pairs1) {
            for (int j = 0; j < pairs2.size(); j++) {
                var pair2 = pairs2.get(j);
                if (pair1.equals(pair2)) {
                    intersection++;
                    pairs2.remove(j);
                    break;
                }
            }
        }
        return (2.0 * intersection) / union;
    }

    private static ArrayList<String> wordLetterPairs(String str) {
        ArrayList<String> allPairs = new ArrayList<>();
        // Tokenize the string and put the tokens/words into an array
        String[] words = str.split("\\s");
        // For each word
        for (String word : words) {
            // Find the pairs of characters
            if (word.length() <= 1) {
                allPairs.add(word);
            } else {
                String[] pairsInWord = letterPairs(word);
                Collections.addAll(allPairs, pairsInWord);
            }
        }
        return allPairs;

    }

    private static String[] letterPairs(String str) {
        int numPairs = str.length() - 1;
        String[] pairs = new String[numPairs];
        for (int i = 0; i < numPairs; i++) {
            pairs[i] = str.substring(i, i + n);
        }
        return pairs;
    }


}
