package tech.szymanskazdrzalik.ksr.ksr1.dao;

import org.apache.commons.io.IOUtils;
import tech.szymanskazdrzalik.ksr.ksr1.Main;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static tech.szymanskazdrzalik.ksr.ksr1.dao.FileReader.Parse;

public class FolderReader {
    private static ArticleDAO articleDAO = new ResourcesArticleDAO();

    private FolderReader() {
    }

    public static String[] getFilePathsFromFolder(String path) throws IOException {
        try {
            return IOUtils.readLines(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(path))).toArray(new String[0]);
        } catch (NullPointerException e) {
            throw new FileNotFoundException("Invalid folder path");
        }
    }

    public static Article[] readArticlesFromFolder(String path) throws IOException {
        List<Article> articles = new ArrayList<>();
        for (var x : getFilePathsFromFolder(path)) {
            if (x.endsWith(".sgm")) {
                articles.addAll(articleDAO.getArticles(x));
            }
        }
        return articles.toArray(Article[]::new);
    }
}
