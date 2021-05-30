package tech.szymanskazdrzalik.fuzzy.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SaveDAO<T> {

    void Save(T t);
}
