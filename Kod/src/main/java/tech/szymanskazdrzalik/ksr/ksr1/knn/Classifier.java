package tech.szymanskazdrzalik.ksr.ksr1.knn;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;
import tech.szymanskazdrzalik.ksr.ksr1.model.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classifier {

    private final int k;
    private final List<Article> trainingArticles;
    private final tech.szymanskazdrzalik.ksr.ksr1.metric.Metric metric;
    private Article article;
    private List<Pair<Article, Double>> listOfPairs;
    private boolean[] filter;

    public Classifier(List<Article> trainingArticles, tech.szymanskazdrzalik.ksr.ksr1.metric.Metric metric, int k, boolean[] filter) {
        this.filter = filter;
        this.trainingArticles = trainingArticles;
        this.k = k;
        this.metric = metric;
    }

    private org.javatuples.Pair<double[], double[]> setFeatureArray(Article trainingArticle, boolean[] filter) {

        List<Double> articleList = new ArrayList<>();
        List<Double> trainingArticleList = new ArrayList<>();

        // Liczba słów
        if (filter[0]) {
            articleList.add((double) this.article.getFeatureVector().getWordCount());
            trainingArticleList.add((double) trainingArticle.getFeatureVector().getWordCount());
        }

        // Autor
        if (filter[1]) {
            articleList.add(0.0);
            trainingArticleList.add(1 - Metric.bigrams(this.article.getFeatureVector().getAuthor(), trainingArticle.getFeatureVector().getAuthor()));
        }

        // Liczba unikatowych słów
        if (filter[2]) {
            articleList.add((double) this.article.getFeatureVector().getUniqueWordCount());
            trainingArticleList.add((double) trainingArticle.getFeatureVector().getUniqueWordCount());
        }

        // Data
        if (filter[3]) {
            articleList.add((double) this.article.getFeatureVector().getDayInYear());
            trainingArticleList.add((double) trainingArticle.getFeatureVector().getDayInYear());
        }

        // Lokalizacja
        if (filter[4]) {
            articleList.add(0.0);
            trainingArticleList.add(1 - Metric.bigrams(this.article.getFeatureVector().getLocation(), trainingArticle.getFeatureVector().getLocation()));
        }

        // Tytuł
        if (filter[5]) {
            articleList.add(0.0);
            trainingArticleList.add(1 - Metric.bigrams(this.article.getFeatureVector().getTitle(), trainingArticle.getFeatureVector().getTitle()));
        }

        // Najczęsicej występujaca nazwa państwa
        if (filter[6]) {
            articleList.add(0.0);
            trainingArticleList.add(1 - Metric.bigrams(this.article.getFeatureVector().getMostPopularCountry(), trainingArticle.getFeatureVector().getMostPopularCountry()));
        }

        // Kluczowe słowa
        if (filter[7]) {
            articleList.add(0.0);
            trainingArticleList.add(Metric.bigrams(String.join(" ", article.getFeatureVector().getKeyWords()), String.join(" ", trainingArticle.getFeatureVector().getKeyWords())));
        }

        // Liczba słów kluczowych
        if (filter[8]) {
            articleList.add((double) this.article.getFeatureVector().getKeyWordCount());
            trainingArticleList.add((double) trainingArticle.getFeatureVector().getKeyWordCount());
        }

        // Nasycenie tekstu słowami kluczowymi
        if (filter[9]) {
            articleList.add((double) this.article.getFeatureVector().getKeyWordSaturation());
            trainingArticleList.add((double) trainingArticle.getFeatureVector().getKeyWordSaturation());
        }

        //Najczęsciej wystepujące słowo kluczowe
        if (filter[10]) {
            articleList.add(0.0);
            trainingArticleList.add(1 - Metric.bigrams(this.article.getFeatureVector().getMostPopularKeyWord(), trainingArticle.getFeatureVector().getMostPopularKeyWord()));
        }
        double[] doubles1 = new double[trainingArticleList.size()];
        double[] doubles2 = new double[trainingArticleList.size()];
        for (int i = 0; i < doubles1.length; i++) {
            doubles1[i] = articleList.get(i);
            doubles2[i] = trainingArticleList.get(i);
        }
        return new org.javatuples.Pair<>(doubles1, doubles2);
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
            org.javatuples.Pair<double[], double[]> pair = setFeatureArray(trainingArticle, this.filter);
            double[] articleArray = pair.getValue0();
            double[] trainingArticleArray = pair.getValue1();
            this.listOfPairs.add(new Pair<>(trainingArticle, this.metric.calculateDistance(articleArray, trainingArticleArray)));
        }
    }


}
