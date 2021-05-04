package tech.szymanskazdrzalik.ksr.ksr1.metric;

public class ManhattanMetric implements Metric {
    @Override
    public double calculateDistance(double[] articleArrayVector, double[] trainingArticleArrayVector) {
        double sum = 0;
        for (int i = 0; i < articleArrayVector.length; i++) {
            sum += Math.abs(articleArrayVector[i] - trainingArticleArrayVector[i]);
        }
        return sum;
    }
}
