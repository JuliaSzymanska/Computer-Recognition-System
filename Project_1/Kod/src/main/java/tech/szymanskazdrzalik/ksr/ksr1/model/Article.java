package tech.szymanskazdrzalik.ksr.ksr1.model;

import opennlp.tools.stemmer.PorterStemmer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Article {
    private final String[] body;
    private final String[] title;
    private final String[] author;
    private final String[] dateline;
    private final String[] places;
    private boolean isTestSet;
    private FeatureVector featureVector;

    public Article(@NotNull String text) {
        String[] strings = parseSGMToArray(text);
        String title = getTextPart(strings, "TITLE:");
        String body = getTextPart(strings, "BODY:");
        String dateline = getTextPart(strings, "DATELINE:").trim().replace("-", "");
        String author = getTextPart(strings, "AUTHOR:");
        this.places = getTextPart(strings, "PLACES:").trim().replaceAll("[\\p{Punct}&&[^_-]]+", "").split(" +");
        try {
            this.isTestSet = !getTextPart(getTextPart(strings, "REUTERS").
                    split(" "), "CGISPLIT").
                    strip().
                    replaceAll("\"", "").
                    replaceAll("=", "").equals("TRAINING-SET");
        } catch (Exception e) {
            e.printStackTrace();
            this.isTestSet = false;
        }
        this.title = applyStopList(title);
        this.body = applyStopList(body);
        this.dateline = applyStopList(dateline);
        this.author = applyStopList(author);
        // TODO: 26.03.2021 W tym miejscu nadal pozostaje na samym koncu string  Reuter //&#3; zmieniowny w 2 stringi reuter i 3 i nwm co z tym madrego zrobic

    }

    public boolean isTestSet() {
        return isTestSet;
    }

    @Override
    public String toString() {
        return "Article{" +
                "body=" + Arrays.toString(body) +
                ", title=" + Arrays.toString(title) +
                ", author=" + Arrays.toString(author) +
                ", dateline=" + Arrays.toString(dateline) +
                ", places=" + Arrays.toString(places) +
                ", isTestSet=" + isTestSet +
                ", featureVector=" + featureVector +
                '}' + "\n";
    }

    public String[] getBody() {
        return body;
    }

    public FeatureVector getFeatureVector() {
        if (this.featureVector == null) {
            this.featureVector = new FeatureVector(this);
        }
        return this.featureVector;
    }

    private boolean isStringTestSet(String string) {
        return Objects.equals(string, "PUBLISHED-TESTSET");
    }

    public String[] getPlaces() {
        return places;
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
            return "";
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
        string = string.trim().replaceAll("[\\p{Punct}&&[^_-]]+", "");
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

    public static class FeatureVector {
        private static final Map<String, Integer> monthsValuesMap = new HashMap<>() {{
            put("jan", 0);
            put("feb", 31);
            put("mar", 60);
            put("apr", 91);
            put("may", 121);
            put("jun", 152);
            put("jul", 182);
            put("aug", 213);
            put("sep", 244);
            put("oct", 274);
            put("nov", 305);
            put("dec", 335);
        }};
        private final int wordCount;
        private final int uniqueWordCount;
        private final String[] keyWords;
        private final int keyWordCount;
        private final float keyWordSaturation;
        @Nullable
        private final String mostPopularKeyWord;
        @Nullable
        private final String mostPopularCountry;
        @Nullable
        private String author = null;
        private int dayInYear;
        private String location;
        @Nullable
        private String title;

        // TODO: 23.03.2021  test
        // TODO: 23.03.2021 Finish
        public FeatureVector(Article article) {
            String[] fullText = new String[0];
            if (article.author != null) {
                fullText = Stream.concat(Arrays.stream(article.author), Arrays.stream(fullText)).toArray(String[]::new);
                this.author = String.join(" ", article.author);
            }
            if (article.body != null) {
                fullText = Stream.concat(Arrays.stream(article.body), Arrays.stream(fullText)).toArray(String[]::new);
            }
            if (article.dateline != null) {
                fullText = Stream.concat(Arrays.stream(article.dateline), Arrays.stream(fullText)).toArray(String[]::new);
                List<String> tmpList = new ArrayList<>();
                this.dayInYear = getDayInYearFromDateLineString(article.dateline, tmpList);
                this.location = String.join(" ", tmpList);
                // TODO: 29.03.2021 Pobierać wiecej lepiej
            }
            if (article.title != null) {
                fullText = Stream.concat(Arrays.stream(article.title), Arrays.stream(fullText)).toArray(String[]::new);
                this.title = String.join(" ", article.title);
            }
            List<String> tmp = new LinkedList<String>(Arrays.asList(fullText));
            tmp.removeIf(s -> !KeyWords.contains(s));
            this.keyWords = tmp.toArray(String[]::new);
            this.keyWordCount = this.keyWords.length;
            this.wordCount = fullText.length;
            this.keyWordSaturation = (float) (this.keyWordCount) / this.wordCount;
            this.mostPopularKeyWord = getMostPopularKeyword(this.keyWords);
            this.mostPopularCountry = this.findMostPopularCountry(fullText);

            this.uniqueWordCount = findUnique(fullText).length;
        }

        private static boolean isInteger(String s) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            } catch (NullPointerException e) {
                return false;
            }
            // only got here if we didn't return false
            return true;
        }

        @Override
        public String toString() {
            return "FeatureVector{" +
                    "wordCount=" + wordCount +
                    ", uniqueWordCount=" + uniqueWordCount +
                    ", keyWords=" + Arrays.toString(keyWords) +
                    ", keyWordCount=" + keyWordCount +
                    ", keyWordSaturation=" + keyWordSaturation +
                    ", mostPopularKeyWord='" + mostPopularKeyWord + '\'' +
                    ", mostPopularCountry='" + mostPopularCountry + '\'' +
                    ", author='" + author + '\'' +
                    ", dayInYear=" + dayInYear +
                    ", location='" + location + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        private String findMostPopularCountry(String[] fullText) {
            List<String> tmpList = new LinkedList<String>(Arrays.asList(fullText));
            tmpList.removeIf(s -> !Places.contains(s));
            String str = mostCommon(tmpList);
            return str == null ? "" : str;
        }

        private static <T> T mostCommon(List<T> list) {
            Map<T, Integer> map = new HashMap<>();

            for (T t : list) {
                Integer val = map.get(t);
                map.put(t, val == null ? 1 : val + 1);
            }

            Map.Entry<T, Integer> max = null;

            for (Map.Entry<T, Integer> e : map.entrySet()) {
                if (max == null || e.getValue() > max.getValue())
                    max = e;
            }

            return max == null ? null : max.getKey();
        }

        private String getMostPopularKeyword(String[] keyWords) {
            Map<String, Integer> stringIntegerMap = new HashMap<>();
            for (var x : keyWords) {
                stringIntegerMap.put(x, stringIntegerMap.getOrDefault(x, 0));
            }
            var maxEntry = stringIntegerMap.entrySet().stream().findFirst().orElse(null);
            for (var x : stringIntegerMap.entrySet()) {
                if (maxEntry == null || x.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = x;
                }
            }
            return maxEntry == null ? "" : maxEntry.getKey();
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

        private int getDayInYearFromDateLineString(String[] string, List<String> listOfStringWithoutDate) {
            // TODO: 27.03.2021 Mam nadzieje że to zawsze tak wyglada :p
            int dayN = 0;
            List<String> tmpList = new ArrayList<>(Arrays.asList(string));
            search:
            {
                for (var x : string) {
                    if (monthsValuesMap.keySet().stream().anyMatch(s -> x.toLowerCase().contains(s.toLowerCase()))) {
                        for (var y : monthsValuesMap.keySet()) {
                            if (x.toLowerCase().contains(y.toLowerCase())) {
                                dayN += monthsValuesMap.get(y);
                                tmpList.removeIf(s -> s.equals(x));
                                break search;
                            }
                        }
                    }
                }
            }

            for (var x : string) {
                if (isInteger(x)) {
                    tmpList.removeIf(s -> s.equals(x));
                    dayN += Integer.parseInt(x);
                    break;
                }
            }
            listOfStringWithoutDate.addAll(tmpList);

            return dayN; // TODO: 27.03.2021
        }

        public int getWordCount() {
            return wordCount;
        }

        public @Nullable String getAuthor() {
            return author;
        }

        public int getUniqueWordCount() {
            return uniqueWordCount;
        }

        public int getDayInYear() {
            return dayInYear;
        }

        public String getLocation() {
            return location;
        }

        public String getTitle() {
            return title;
        }

        public @Nullable String getMostPopularCountry() {
            return mostPopularCountry;
        }

        public String[] getKeyWords() {
            return keyWords;
        }

        public int getKeyWordCount() {
            return keyWordCount;
        }

        public float getKeyWordSaturation() {
            return keyWordSaturation;
        }

        public @Nullable String getMostPopularKeyWord() {
            return mostPopularKeyWord;
        }
    }
}
