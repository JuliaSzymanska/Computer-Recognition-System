package tech.szymanskazdrzalik.fuzzy.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface DAO<T> {
    List<T> getAll(File file) throws IOException;

    List<T> getAll(String path) throws IOException;

    List<T> getAll(URL path) throws IOException;
}
