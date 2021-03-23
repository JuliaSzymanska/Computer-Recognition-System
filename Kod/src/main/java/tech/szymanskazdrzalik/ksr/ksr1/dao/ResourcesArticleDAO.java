package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourcesArticleDAO implements ArticleDAO {

    @Override
    public List<Article> getArticles(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder str = new StringBuilder();
        while (bufferedReader.ready()) {
            str.append(bufferedReader.readLine());
        }
        String string = str.toString();
        List<String> ArticlesSplitStrings = new ArrayList<>(Arrays.asList(string.split("</REUTERS>")));
        List<Article> articles = new ArrayList<>();
        for (var x : ArticlesSplitStrings) {
            articles.add(new Article(x));
        }
        return articles;
    }

    @Override
    public List<Article> getArticles(String path) throws IOException {
        return getArticles(new File(path));
    }

    @Override
    public List<Article> getArticles(URL path) throws IOException {
        return getArticles(new File(path.getPath()));
    }


}
