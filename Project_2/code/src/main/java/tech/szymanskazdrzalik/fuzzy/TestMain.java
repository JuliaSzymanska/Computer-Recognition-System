package tech.szymanskazdrzalik.fuzzy;

import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.utils.PropertiesLoader;

import java.io.IOException;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // TODO: 10.06.2021 sprawdzic czy to sie wywoluje
        var all = new ResourcesAccidentDao().getAll("Data/" + PropertiesLoader.getJsonName());
        var x = ResourcesAccidentDao.class;
        var a = ResourcesAccidentDao.getWypadek_severity_1();
        var b = ResourcesAccidentDao.getWypadek_severity_2();
        var c = ResourcesAccidentDao.getWypadek_severity_3();
        var d = ResourcesAccidentDao.getWypadek_severity_4();
        var y = 1;

    }
}
