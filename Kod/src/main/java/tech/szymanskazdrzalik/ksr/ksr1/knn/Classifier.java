package tech.szymanskazdrzalik.ksr.ksr1.knn;

import tech.szymanskazdrzalik.ksr.ksr1.metric.Metric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;
import tech.szymanskazdrzalik.ksr.ksr1.model.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classifier {

    private final int k;
    private Article article;
    private final List<Article> trainingArticles;
    private final Metric metric;
    private List<Pair<Article, Double>> listOfPairs;

    public Classifier(List<Article> trainingArticles, Metric metric, int k) {
        this.trainingArticles = trainingArticles;
        this.k = k;
        this.metric = metric;
    }

    private String classify(List<Pair<Article, Double>> kNearestNeighbour) {
        Map<String, Integer> map = new HashMap<>();
        for (Pair<Article, Double> articleDoublePair : kNearestNeighbour) {
            String[] places = articleDoublePair.getM().getPlaces();
            for (String place : places) {
                if (!map.containsKey(place)) {
                    map.put(place, 1);
                } else {
                    map.replace(place, map.get(place) + 1);
                }
            }
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    private List<Pair<Article, Double>> findKNearestNeighbours() {
        Collections.sort(this.listOfPairs);
        return this.listOfPairs.subList(0, k);
    }

    public String simulate(Article article) {
        this.article = article;
        this.calculateDistances();
        List<Pair<Article, Double>> kNearestNeighbour = this.findKNearestNeighbours();
        return classify(kNearestNeighbour);
    }

    private void calculateDistances() {
        this.listOfPairs = new ArrayList<>();
        for (Article trainingArticle : this.trainingArticles) {
            double[] articleArray = new double[12];
            double[] trainingArticleArray = new double[12];
            setFeatureArray(trainingArticle, articleArray, trainingArticleArray);
            this.listOfPairs.add(new Pair<>(trainingArticle, this.metric.calculateDistance(articleArray, trainingArticleArray)));
        }
    }

    private void setFeatureArray(Article trainingArticle, double[] articleArray, double[] trainingArticleArray) {

        articleArray[0] = this.article.getFeatureVector().getWordCount();
        trainingArticleArray[0] = trainingArticle.getFeatureVector().getWordCount();

        articleArray[1] = 0.0;
        trainingArticleArray[1] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getAuthor(), trainingArticle.getFeatureVector().getAuthor());

        articleArray[2] = this.article.getFeatureVector().getUniqueWordCount();
        trainingArticleArray[2] = trainingArticle.getFeatureVector().getUniqueWordCount();

        articleArray[3] = 0.0;
        trainingArticleArray[3] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getSecondCurrency(), trainingArticle.getFeatureVector().getSecondCurrency());

        articleArray[4] = this.article.getFeatureVector().getDayInYear();
        trainingArticleArray[4] = trainingArticle.getFeatureVector().getDayInYear();

        articleArray[5] = 0.0;
        trainingArticleArray[5] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getLocation(), trainingArticle.getFeatureVector().getLocation());

        articleArray[6] = 0.0;
        trainingArticleArray[6] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getTitle(), trainingArticle.getFeatureVector().getTitle());

        articleArray[7] = 0.0;
        trainingArticleArray[7] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getMostPopularCountry(), trainingArticle.getFeatureVector().getMostPopularCountry());

        articleArray[8] = 0.0;
        trainingArticleArray[8] = CosMetric.cosMetric(article.getFeatureVector().getKeyWords(), trainingArticle.getFeatureVector().getKeyWords());

        articleArray[9] = this.article.getFeatureVector().getKeyWordCount();
        trainingArticleArray[9] = trainingArticle.getFeatureVector().getKeyWordCount();

        articleArray[10] = this.article.getFeatureVector().getKeyWordSaturation();
        trainingArticleArray[10] = trainingArticle.getFeatureVector().getKeyWordSaturation();

        articleArray[11] = 0.0;
        trainingArticleArray[11] = 1 - CosMetric.cosMetric(this.article.getFeatureVector().getMostPopularKeyWord(), trainingArticle.getFeatureVector().getMostPopularKeyWord());
    }


}
