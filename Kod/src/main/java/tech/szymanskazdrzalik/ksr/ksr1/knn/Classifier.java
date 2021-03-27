package tech.szymanskazdrzalik.ksr.ksr1.knn;

import tech.szymanskazdrzalik.ksr.ksr1.metric.Metric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;
import tech.szymanskazdrzalik.ksr.ksr1.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Classifier {

    int k = 0;
    Article article;
    Article[] trainingArticles;
    List<Pair> listOfPairs;
    Metric metric;

    private List<Pair> findKNearestNeighbours() {
        Collections.sort(this.listOfPairs);
        return this.listOfPairs.subList(0, k);
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

    private String simulate(Metric metric, int k) {
        this.k = k;
        this.metric = metric;
        this.calculateDistances();
        List<Pair> kNearestNeighbour = this.findKNearestNeighbours();
        return "";
    }

    private void calculateDistances() {
        this.listOfPairs = new ArrayList<>();
        for (Article trainingArticle : this.trainingArticles) {
            double[] articleArray = new double[12];
            double[] trainingArticleArray = new double[12];
            setFeatureArray(trainingArticle, articleArray, trainingArticleArray);
            this.listOfPairs.add(new Pair(trainingArticle, this.metric.calculateDistance(articleArray, trainingArticleArray)));
        }
    }

    private void setFeatureArray(Article trainingArticle, double[] articleArray, double[] trainingArticleArray) {

        articleArray[0] = this.article.getFeatureVector().getWordCount();
        trainingArticleArray[0] = trainingArticle.getFeatureVector().getWordCount();

        articleArray[1] = 0.0;
        trainingArticleArray[1] = areStringEquals(this.article.getFeatureVector().getAuthor(), trainingArticle.getFeatureVector().getAuthor());

        articleArray[2] = this.article.getFeatureVector().getUniqueWordCount();
        trainingArticleArray[2] = trainingArticle.getFeatureVector().getUniqueWordCount();

        articleArray[3] = 0.0;
        trainingArticleArray[3] = areStringEquals(this.article.getFeatureVector().getSecondCurrency(), trainingArticle.getFeatureVector().getSecondCurrency());

        articleArray[4] = this.article.getFeatureVector().getDayInYear();
        trainingArticleArray[4] = trainingArticle.getFeatureVector().getDayInYear();

        articleArray[5] = 0.0;
        trainingArticleArray[5] = areStringEquals(this.article.getFeatureVector().getLocation(), trainingArticle.getFeatureVector().getLocation());

        articleArray[6] = 0.0;
        trainingArticleArray[6] = areStringEquals(this.article.getFeatureVector().getTitle(), trainingArticle.getFeatureVector().getTitle());

        articleArray[7] = 0.0;
        trainingArticleArray[7] = areStringEquals(this.article.getFeatureVector().getMostPopularCountry(), trainingArticle.getFeatureVector().getMostPopularCountry());

//        articleArray[8] = 0.0;
//        trainingArticleArray[8] = areStringEquals(article.getFeatureVector().getKeyWords(), trainingArticle.getFeatureVector().getKeyWords());

        articleArray[9] = this.article.getFeatureVector().getKeyWordCount();
        trainingArticleArray[9] = trainingArticle.getFeatureVector().getKeyWordCount();

        articleArray[10] = this.article.getFeatureVector().getKeyWordSaturation();
        trainingArticleArray[10] = trainingArticle.getFeatureVector().getKeyWordSaturation();

        articleArray[11] = 0.0;
        trainingArticleArray[11] = areStringEquals(this.article.getFeatureVector().getMostPopularKeyWord(), trainingArticle.getFeatureVector().getMostPopularKeyWord());
    }


}
