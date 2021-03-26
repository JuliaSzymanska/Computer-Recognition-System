package tech.szymanskazdrzalik.ksr.ksr1.metric;

public interface Metric {

    public float calculateDistance(double[] article, double[] trainingArticle);
}
