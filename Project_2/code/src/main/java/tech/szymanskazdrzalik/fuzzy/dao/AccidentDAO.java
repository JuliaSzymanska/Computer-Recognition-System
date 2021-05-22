package tech.szymanskazdrzalik.fuzzy.dao;

import tech.szymanskazdrzalik.fuzzy.model.Accident;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface AccidentDAO extends DAO<Accident> {
    List<Accident> getAll(File file) throws IOException;

    List<Accident> getAll(String path) throws IOException;

    List<Accident> getAll(URL path) throws IOException;
}
