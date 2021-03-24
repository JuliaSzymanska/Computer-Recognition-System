package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResourcesArticleDAO implements ArticleDAO {
    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    @Override
    public List<Article> getArticles(File file) throws IOException {

        String string = FileReader.Parse(file);
        List<String> articlesSplitStrings = new ArrayList<>(Arrays.asList(string.split(String.format(WITH_DELIMITER, "</REUTERS>"))));
        List<Article> articles = new ArrayList<>();
        for (var x : articlesSplitStrings) {
            System.out.println(x);
//            articles.add(new Article(x));
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
