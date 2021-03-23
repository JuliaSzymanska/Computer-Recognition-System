package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public interface ArticleDAO {
    List<Article> getArticles(File file);

    List<Article> getArticles(String path);

    List<Article>getArticles(URL path);
}
