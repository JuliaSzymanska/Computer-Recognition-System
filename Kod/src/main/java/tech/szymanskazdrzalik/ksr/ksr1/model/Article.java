package tech.szymanskazdrzalik.ksr.ksr1.model;

import opennlp.tools.stemmer.PorterStemmer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Article {
    private final String[] body;
    private final String[] title;
    private final String[] author;
    private final String[] dateline;
    private final String isTestSet;

    private FeatureVector featureVector;


    public Article(@NotNull String text) {
        String[] strings = parseSGMToArray(text);
        String title = getTextPart(strings, "TITLE:");
        String body = getTextPart(strings, "BODY:");
        String dateline = getTextPart(strings, "DATELINE:");
        String author = getTextPart(strings, "AUTHOR:");
        String isTestSet = getTextPart(strings, "CGISPLIT:");

//        boolean this.isTestSet = getIsTestSet(strings);
        this.isTestSet = isTestSet;
        this.title = applyStopList(title);
        this.body = applyStopList(body);
        this.dateline = applyStopList(dateline);
        this.author = applyStopList(author);
        System.out.println("title" + Arrays.toString(this.title));
        // TODO: 26.03.2021 W tym miejscu nadal pozostaje na samym koncu string  Reuter //&#3; zmieniowny w 2 stringi reuter i 3 i nwm co z tym madrego zrobic
        System.out.println("body" + Arrays.toString(this.body));
        System.out.println("dateline" + Arrays.toString(this.dateline));
        System.out.println("author " + Arrays.toString(this.author));
        System.out.println("isTestSet " + this.isTestSet);

        System.exit(0);
    }

    private boolean getIsTestSet(String[] strings) {
        String string = getTextPart(strings, "CGISPLIT:");
        return Objects.equals(string, "PUBLISHED-TESTSET");
    }


    private String[] parseSGMToArray(String text) {
        text = text.replace("\n", " ");
        text = text.replace("<DATE>", "\nDATE: ");
        text = text.replace("</DATE>", "");
        text = text.replace("<TOPICS>", "\nTOPICS: ");
        text = text.replace("</TOPICS>", "");
        text = text.replace("<PLACES", "\nPLACES: ");
        text = text.replace("</PLACES>", "");
        text = text.replace("<D>", " ");
        text = text.replace("</D>", "");
        text = text.replace("<PEOPLE>", "\nPEOPLE: ");
        text = text.replace("</PEOPLE>", "");
        text = text.replace("<ORGS>", "\nORGS: ");
        text = text.replace("</ORGS>", "");
        text = text.replace("<EXCHANGES>", "\nEXCHANGES: ");
        text = text.replace("</EXCHANGES>", "");
        text = text.replace("<COMPANIES>", "\nCOMPANIES: ");
        text = text.replace("</COMPANIES>", "");
        text = text.replace("<UNKNOWN>", "\nUNKNOWN: ");
        text = text.replace("</UNKNOWN>", "");
        text = text.replace("<TEXT>", "\nTEXT: ");
        text = text.replace("</TEXT>", "");
        text = text.replace("<TITLE>", "\nTITLE: ");
        text = text.replace("</TITLE>", "");
        text = text.replace("<DATELINE>", "\nDATELINE: ");
        text = text.replace("</DATELINE>", "");
        text = text.replace("<AUTHOR>", "\nAUTHOR: ");
        text = text.replace("</AUTHOR>", "");
        text = text.replace("<BODY>", "\nBODY: ");
        text = text.replace("</BODY>", "");
        text = text.replace("<REUTERS", "REUTERS: ");
        text = text.replace(">", "");
        return text.split("\n");
    }

    private String getTextPart(String[] strings, String charSeq) {
        int index = contains(strings, charSeq);
        if (index == -1) {
            return null;
        }
        return strings[index].replace(charSeq, "");
    }

    private int contains(String[] strings, String charSeq) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains(charSeq)) {
                return i;
            }
        }
        return -1;
    }

    private String[] applyStopList(String string) {
        if (string == null) {
            return null;
        }
        // usuniecie wszystkich znaków interpunkcyjnych
        string = string.trim().replaceAll("\\p{Punct}", " ");
        // usuniecie spacji i podzielenie
        List<String> textSplitList = Arrays.asList(string.split(" +"));
        // stemizacja
        textSplitList = stemString(textSplitList);
        // użycie stoplisty
        textSplitList.removeIf(StopList::contains);
        return textSplitList.toArray(new String[0]);
    }

    private List<String> stemString(List<String> strings) {
        PorterStemmer porterStemmer = new PorterStemmer();
        List<String> newStrings = new ArrayList<>();
        for (var x : strings) {
            newStrings.add(porterStemmer.stem(x));
        }
        return newStrings;
    }

    private void createFeatureVector() {

    }

    private static class FeatureVector {
        private final int wordCount;
        @Nullable
        private final String author;
        private final int uniqueWordCount;
        @Nullable
        private String secondCurrency;
        private int dayInYear;
        private String location;
        private String title;
        @Nullable
        private String mostPopularCountry;
        private String[] keyWords;
        private int keyWordCount;
        private int keyWordSaturation;
        @Nullable
        private String mostPopularKeyWord;

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
