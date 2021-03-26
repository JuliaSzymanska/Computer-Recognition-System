package tech.szymanskazdrzalik.ksr.ksr1.metric;

public interface Metric {

    public double calculateDistance(double[] article, double[] trainingArticle);
}
