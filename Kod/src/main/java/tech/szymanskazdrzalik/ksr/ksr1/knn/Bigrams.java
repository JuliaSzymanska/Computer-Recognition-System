package tech.szymanskazdrzalik.ksr.ksr1.knn;

import java.util.*;

public class Bigrams {


    public static double bigramSimilarity(String s, String t) {
        if (s == null || t == null)
            return 0;
        if (s.length() < 2 || t.length() < 2) {
            return 0;
        }
        final int n = s.length() - 1;
        final int[] sPairs = new int[n];
        createBigrams(s, n, sPairs);
        final int m = t.length() - 1;
        final int[] tPairs = new int[m];
        createBigrams(t, m, tPairs);
        Arrays.sort(sPairs);
        Arrays.sort(tPairs);
        int matches = 0, i = 0, j = 0;
        while (i < n && j < m) {
            if (sPairs[i] == tPairs[j]) {
                matches += 2;
                i++;
                j++;
            } else if (sPairs[i] < tPairs[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return (double) matches / (n + m);
    }

    private static void createBigrams(String t, int m, int[] tPairs) {
        for (int i = 0; i <= m; i++) {
            if (i == 0) {
                tPairs[i] = t.charAt(i) << 16;
            } else if (i == m) {
                tPairs[i - 1] |= t.charAt(i);
            } else {
                tPairs[i] = (tPairs[i - 1] |= t.charAt(i)) << 16;
            }
        }
    }


}
