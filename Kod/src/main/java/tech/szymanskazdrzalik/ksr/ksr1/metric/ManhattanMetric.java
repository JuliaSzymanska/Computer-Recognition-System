package tech.szymanskazdrzalik.ksr.ksr1.metric;

public class ManhattanMetric implements Metric {
    @Override
    public double calculateDistance(double[] article, double[] trainingArticle) {
        double sum = 0;
        for (int i = 0; i < article.length; i++) {
            sum += Math.abs(article[i] - trainingArticle[i]);
        }
        return sum;
    }
}
