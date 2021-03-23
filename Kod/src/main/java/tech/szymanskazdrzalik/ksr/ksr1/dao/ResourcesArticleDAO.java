package tech.szymanskazdrzalik.ksr.ksr1.dao;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public class ResourcesArticleDAO implements ArticleDAO {

    @Override
    public List<Article> getArticles(File file) {
        return null;
    }

    @Override
    public List<Article> getArticles(String path) {
        return getArticles(new File(path));
    }

    @Override
    public List<Article> getArticles(URL path) {
        return getArticles(new File(path.getPath()));
    }
}
