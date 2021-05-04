package tech.szymanskazdrzalik.ksr.ksr1.metric;

import java.util.ArrayList;
import java.util.Collections;

public class ChebyshevMetric implements Metric {
    @Override
    public double calculateDistance(double[] articleArrayVector, double[] trainingArticleArrayVector) {
        ArrayList<Double> listOfDifferences = new ArrayList<>();
        for (int i = 0; i < articleArrayVector.length; i++) {
            listOfDifferences.add(Math.abs(articleArrayVector[i] - trainingArticleArrayVector[i]));
        }
        return Collections.max(listOfDifferences);
    }
}
