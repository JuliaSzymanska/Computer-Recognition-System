package tech.szymanskazdrzalik.ksr.ksr1.metric;

public interface Metric {

    public double calculateDistance(double[] articleArrayVector, double[] trainingArticleArrayVector);
}
