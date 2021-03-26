package tech.szymanskazdrzalik.ksr.ksr1.knn;

import tech.szymanskazdrzalik.ksr.ksr1.metric.Metric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;
import tech.szymanskazdrzalik.ksr.ksr1.model.Pair;

public class Classifier {

    private static String simulate(Metric metric, int k) {
        return "";
    }

    private static Pair[] findKNearestNeighbours(Article article, int k) {
        return null;
    }

    private static Pair calculateDistances(Article article, Article[] trainingArticles) {
        for (Article trainingArticle : trainingArticles) {
        }
        return null;
    }

    private static Pair setFeatureArray(Article article, Article trainingArticle) {
        double[] articleArray = new double[12];
        double[] trainingArticleArray = new double[12];
        articleArray[0] = article.getFeatureVector().getWordCount();
        trainingArticleArray[0] = trainingArticle.getFeatureVector().getWordCount();

        articleArray[1] = 0.0;
        trainingArticleArray[1] = areStringEquals(article.getFeatureVector().getAuthor(), trainingArticle.getFeatureVector().getAuthor());

        articleArray[2] = article.getFeatureVector().getUniqueWordCount();
        trainingArticleArray[2] = trainingArticle.getFeatureVector().getUniqueWordCount();

        articleArray[3] = 0.0;
        trainingArticleArray[3] = areStringEquals(article.getFeatureVector().getSecondCurrency(), trainingArticle.getFeatureVector().getSecondCurrency());

        articleArray[4] = article.getFeatureVector().getDayInYear();
        trainingArticleArray[4] = trainingArticle.getFeatureVector().getDayInYear();

        articleArray[5] = 0.0;
        trainingArticleArray[5] = areStringEquals(article.getFeatureVector().getLocation(), trainingArticle.getFeatureVector().getLocation());

        articleArray[6] = 0.0;
        trainingArticleArray[6] = areStringEquals(article.getFeatureVector().getTitle(), trainingArticle.getFeatureVector().getTitle());

        articleArray[7] = 0.0;
        trainingArticleArray[7] = areStringEquals(article.getFeatureVector().getMostPopularCountry(), trainingArticle.getFeatureVector().getMostPopularCountry());

//        articleArray[8] = 0.0;
//        trainingArticleArray[8] = areStringEquals(article.getFeatureVector().getKeyWords(), trainingArticle.getFeatureVector().getKeyWords());

        articleArray[9] = article.getFeatureVector().getKeyWordCount();
        trainingArticleArray[9] = trainingArticle.getFeatureVector().getKeyWordCount();

        articleArray[10] = article.getFeatureVector().getKeyWordSaturation();
        trainingArticleArray[10] = trainingArticle.getFeatureVector().getKeyWordSaturation();

        articleArray[11] = 0.0;
        trainingArticleArray[11] = areStringEquals(article.getFeatureVector().getMostPopularKeyWord(), trainingArticle.getFeatureVector().getMostPopularKeyWord());

        return null;
    }

    private static String classify(Article article) {
        return "";
    }

    private static double areStringEquals(String article, String trainingArticle) {
        if (article.equals(trainingArticle)) {
            return 0;
        }
        return 1;
    }


}
