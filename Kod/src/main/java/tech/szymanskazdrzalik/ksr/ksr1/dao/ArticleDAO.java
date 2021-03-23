package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public interface ArticleDAO {
    List<Article> getArticles(File file) throws IOException;

    List<Article> getArticles(String path) throws IOException;

    List<Article>getArticles(URL path) throws IOException;
}
