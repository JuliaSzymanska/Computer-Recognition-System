package tech.szymanskazdrzalik.ksr.ksr1.knn;

import tech.szymanskazdrzalik.ksr.ksr1.metric.Metric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;
import tech.szymanskazdrzalik.ksr.ksr1.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classifier {

    private int k;
    private final Article article;
    private final Article[] trainingArticles;
    private List<Pair<Article, Double>> listOfPairs;
    private final Metric metric;

    public Classifier(Article article, Article[] trainingArticles, Metric metric, int k) {
        this.article = article;
        this.trainingArticles = trainingArticles;
        this.k = k;
        this.metric = metric;
    }

    private double cosMetric(String[] text1Array, String[] text2Array) {
        List<String> text1List = new ArrayList<>(Arrays.asList(text1Array));
        List<String> text2List = new ArrayList<>(Arrays.asList(text2Array));
        List<String> listOfWords = new ArrayList<>();
        for (String i : text1List) {
            if (!listOfWords.contains(i)) {
                listOfWords.add(i);
            }
        }
        for (String i : text2List) {
            if (!listOfWords.contains(i)) {
                listOfWords.add(i);
            }
        }
        int[] text1WordsCount = new int[listOfWords.size()];
        int[] text2WordsCount = new int[listOfWords.size()];
        for (int i = 0; i < listOfWords.size(); i++) {
            if (text1List.contains(listOfWords.get(i))) {
                text1WordsCount[i] += 1;
            }
            if (text2List.contains(listOfWords.get(i))) {
                text2WordsCount[i] += 1;
            }
        }
        return calculateCos(text1WordsCount, text2WordsCount);
    }

    private double cosMetric(String text1, String text2) {
        return cosMetric(text1.split(" "), text2.split(" "));
    }

    private double calculateCos(int[] text1WordsCount, int[] text2WordsCount) {
        int sum = 0;
        int sumOfSquaresText1 = 0;
        int sumOfSquaresText2 = 0;
        for (int i = 0; i < text1WordsCount.length; i++) {
            sum += text1WordsCount[i] * text2WordsCount[i];
            sumOfSquaresText1 += text1WordsCount[i] * text1WordsCount[i];
            sumOfSquaresText2 += text2WordsCount[i] * text2WordsCount[i];
        }
        return sum / Math.sqrt(sumOfSquaresText1 * sumOfSquaresText2);
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

    private String simulate() {
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
        trainingArticleArray[1] = 1 - cosMetric(this.article.getFeatureVector().getAuthor(), trainingArticle.getFeatureVector().getAuthor());

        articleArray[2] = this.article.getFeatureVector().getUniqueWordCount();
        trainingArticleArray[2] = trainingArticle.getFeatureVector().getUniqueWordCount();

        articleArray[3] = 0.0;
        trainingArticleArray[3] = 1 - cosMetric(this.article.getFeatureVector().getSecondCurrency(), trainingArticle.getFeatureVector().getSecondCurrency());

        articleArray[4] = this.article.getFeatureVector().getDayInYear();
        trainingArticleArray[4] = trainingArticle.getFeatureVector().getDayInYear();

        articleArray[5] = 0.0;
        trainingArticleArray[5] = 1 - cosMetric(this.article.getFeatureVector().getLocation(), trainingArticle.getFeatureVector().getLocation());

        articleArray[6] = 0.0;
        trainingArticleArray[6] = 1 - cosMetric(this.article.getFeatureVector().getTitle(), trainingArticle.getFeatureVector().getTitle());

        articleArray[7] = 0.0;
        trainingArticleArray[7] = 1 - cosMetric(this.article.getFeatureVector().getMostPopularCountry(), trainingArticle.getFeatureVector().getMostPopularCountry());

        articleArray[8] = 0.0;
        trainingArticleArray[8] = cosMetric(article.getFeatureVector().getKeyWords(), trainingArticle.getFeatureVector().getKeyWords());

        articleArray[9] = this.article.getFeatureVector().getKeyWordCount();
        trainingArticleArray[9] = trainingArticle.getFeatureVector().getKeyWordCount();

        articleArray[10] = this.article.getFeatureVector().getKeyWordSaturation();
        trainingArticleArray[10] = trainingArticle.getFeatureVector().getKeyWordSaturation();

        articleArray[11] = 0.0;
        trainingArticleArray[11] = 1 - cosMetric(this.article.getFeatureVector().getMostPopularKeyWord(), trainingArticle.getFeatureVector().getMostPopularKeyWord());
    }


}
