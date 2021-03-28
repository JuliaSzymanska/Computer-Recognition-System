package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ResourcesArticleDAO implements ArticleDAO {
    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private final List<String> placesNames = Arrays.asList("west-germany", "france,", "uk", "canada", "japan");

    @Override
    public List<Article> getArticles(File file) throws IOException {

        String string = FileReader.Parse(file);
        List<String> articlesSplitStrings = new ArrayList<>(Arrays.asList(string.split(String.format(WITH_DELIMITER, "</REUTERS>"))));
        articlesSplitStrings.removeIf(s -> s.contains("</REUTERS>"));
        articlesSplitStrings.removeIf(s -> s.equals("\n"));
        articlesSplitStrings.removeIf(s -> s.contains("blah blah"));
        List<Article> articles = new ArrayList<>();
        for (var x : articlesSplitStrings) {
            articles.add(new Article(x.replace("<!DOCTYPE lewis SYSTEM \"lewis.dtd\">", "")));
        }
        articles.removeIf(article -> Objects.equals(article.getBody()[0], ""));
        articles.removeIf(article -> article.getPlaces().length > 1);
        articles.removeIf(article -> !placesNames.contains(article.getPlaces()[0]));
        for (var x : articles) {
            x.getFeatureVector();
        }
        return articles;
    }

    @Override
    public List<Article> getArticles(String path) throws IOException {
        return getArticles(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)));
    }

    @Override
    public List<Article> getArticles(URL path) throws IOException {
        return getArticles(new File(path.getPath()));
    }


}
