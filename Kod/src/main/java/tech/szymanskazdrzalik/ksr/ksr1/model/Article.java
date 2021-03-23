package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Article {
    private String body;
    private String title;
    @Nullable
    private String author;
    private String dateline;

    private FeatureVector featureVector;

    private void createFeatureVector() {

    }

    public Article(String text) {
        List<String> textSplitList = Arrays.asList(text.split(" "));
        textSplitList.removeIf(StopList::contains);
    }

    private static class FeatureVector {
        private int wordCount;
        @Nullable
        private String secondCurrency;
        private int dayInYear;
        private String location;
        private String title;
        @Nullable
        private String author;
        @Nullable
        private String mostPopularCountry;
        private String[] keyWords;
        private int keyWordCount;
        private int keyWordSaturation;
        @Nullable
        private String mostPopularKeyWord;
        private int uniqueWordCount;

        public FeatureVector(String text) {

        }

    }
}
