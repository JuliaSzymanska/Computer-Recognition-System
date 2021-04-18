package tech.szymanskazdrzalik.ksr.ksr1.knn;

import java.util.*;

public class Bigrams {


    public static double bigramSimilarity(String s, String t) {
        // Verifying the input:
        if (s == null || t == null)
            return 0;
        // Quick check to catch identical objects:
        if (s == t)
            return 1;
        // avoid exception for single character searches
        if (s.length() < 2 || t.length() < 2)
            return 0;

        // Create the bigrams for string s:
        final int n = s.length() - 1;
        final int[] sPairs = new int[n];
        createBigrams(s, n, sPairs);

        // Create the bigrams for string t:
        final int m = t.length() - 1;
        final int[] tPairs = new int[m];
        createBigrams(t, m, tPairs);

        // Sort the bigram lists:
        Arrays.sort(sPairs);
        Arrays.sort(tPairs);

        // Count the matches:
        int matches = 0, i = 0, j = 0;
        while (i < n && j < m) {
            if (sPairs[i] == tPairs[j]) {
                matches += 2;
                i++;
                j++;
            } else if (sPairs[i] < tPairs[j])
                i++;
            else
                j++;
        }
        return (double) matches / (n + m);
    }

    private static void createBigrams(String t, int m, int[] tPairs) {
        for (int i = 0; i <= m; i++)
            if (i == 0)
                tPairs[i] = t.charAt(i) << 16;
            else if (i == m)
                tPairs[i - 1] |= t.charAt(i);
            else
                tPairs[i] = (tPairs[i - 1] |= t.charAt(i)) << 16;
    }


}
