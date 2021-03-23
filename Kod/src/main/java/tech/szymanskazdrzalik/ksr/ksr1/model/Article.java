package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
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

    public Article(@NotNull String text) {
    }

    // TODO: 23.03.2021 Usuwanie wszystkich znaków typu , . itp
    private Article(@NotNull String title, @NotNull String dateline, @NotNull String body, @Nullable String author) {
        this.title = applyStopList(title);
        this.body = applyStopList(body);
        this.dateline = applyStopList(dateline);
        this.author = applyStopList(author);
    }

    private String applyStopList(String string) {
        if (string == null) {
            return null;
        }
        List<String> textSplitList = Arrays.asList(string.split(" "));
        textSplitList.removeIf(StopList::contains);
        return StringUtils.join(textSplitList, " ");
    }

    private void createFeatureVector() {

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
