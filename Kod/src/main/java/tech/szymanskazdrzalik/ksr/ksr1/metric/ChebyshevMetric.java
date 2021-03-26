package tech.szymanskazdrzalik.ksr.ksr1.metric;

import java.util.ArrayList;
import java.util.Collections;

public class ChebyshevMetric implements Metric {
    @Override
    public double calculateDistance(double[] article, double[] trainingArticle) {
        ArrayList<Double> listOfDifferences = new ArrayList<Double>();
        for (int i = 0; i < article.length; i++) {
            listOfDifferences.add(Math.abs(article[i] - trainingArticle[i]));
        }
        return Collections.max(listOfDifferences);
    }
}
