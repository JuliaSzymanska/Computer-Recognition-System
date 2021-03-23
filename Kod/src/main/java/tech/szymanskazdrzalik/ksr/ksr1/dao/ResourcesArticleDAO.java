package tech.szymanskazdrzalik.ksr.ksr1.dao;

import org.apache.commons.io.IOUtils;
import tech.szymanskazdrzalik.ksr.ksr1.Main;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResourcesArticleDAO implements ArticleDAO {
    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    @Override
    public List<Article> getArticles(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder str = new StringBuilder();
        while (bufferedReader.ready()) {
            str.append(bufferedReader.readLine());
        }
        String string = str.toString();
        List<String> ArticlesSplitStrings = new ArrayList<>(Arrays.asList(string.split(String.format(WITH_DELIMITER, "</REUTERS>"))));
        List<Article> articles = new ArrayList<>();
        for (var x : ArticlesSplitStrings) {
            articles.add(new Article(x));
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
