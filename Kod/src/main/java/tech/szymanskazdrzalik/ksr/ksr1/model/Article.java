package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Article {
    private String[] body;
    private String[] title;
    private String[] author;
    private String[] dateline;

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

    private String[] applyStopList(String string) {
        if (string == null) {
            return null;
        }
        List<String> textSplitList = Arrays.asList(string.split(" "));
        textSplitList.removeIf(StopList::contains);
        return textSplitList.toArray(new String[0]);
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

        // TODO: 23.03.2021  test
        // TODO: 23.03.2021 Finish
        public FeatureVector(Article article) {
            String[] fullText =
                    Stream.concat(
                            Stream.concat(
                                    Stream.concat(
                                            Arrays.stream(article.author),
                                            Arrays.stream(article.body)),
                                    Arrays.stream(article.dateline)),
                            Arrays.stream(article.title)).
                            toArray(String[]::new);
            this.wordCount = fullText.length;
            this.author = String.join(" ", article.author);

            this.uniqueWordCount = findUnique(fullText).length;
        }

        private String[] findUnique(String[] strings) {
            Map<String, Integer> stringIntegerHashMap = new HashMap<>();
            for (var x : strings) {
                stringIntegerHashMap.put(x, stringIntegerHashMap.getOrDefault(x, 0) + 1);
            }
            List<String> stringList = new ArrayList<>();
            // TODO: 23.03.2021 sprawdzic
            stringIntegerHashMap.forEach((s, integer) -> {
                if (integer == 1) {
                    stringList.add(s);
                }
            });
            return stringList.toArray(String[]::new);
        }

    }
}
