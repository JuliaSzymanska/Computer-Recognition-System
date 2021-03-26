package tech.szymanskazdrzalik.ksr.ksr1.metric;

public class EuclideanMetric implements Metric {
    @Override
    public double calculateDistance(double[] articleArrayVector, double[] trainingArticleArrayVector) {
        double sum = 0;
        for (int i = 0; i < articleArrayVector.length; i++) {
            sum += Math.pow(articleArrayVector[i] - trainingArticleArrayVector[i], 2);
        }
        return Math.sqrt(sum);
    }
}
