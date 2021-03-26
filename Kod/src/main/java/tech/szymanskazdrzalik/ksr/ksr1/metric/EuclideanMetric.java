package tech.szymanskazdrzalik.ksr.ksr1.metric;

public class EuclideanMetric implements Metric {
    @Override
    public double calculateDistance(double[] article, double[] trainingArticle) {
        double sum = 0;
        for (int i = 0; i < article.length; i++) {
            sum += Math.pow(article[i] - trainingArticle[i], 2);
        }
        return Math.sqrt(sum);
    }
}
