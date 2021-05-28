package tech.szymanskazdrzalik.fuzzy.dao;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface AccidentDAO extends DAO<Wypadek> {
    List<Wypadek> getAll(File file) throws IOException;

    List<Wypadek> getAll(String path) throws IOException;

    List<Wypadek> getAll(URL path) throws IOException;
}
