package tech.szymanskazdrzalik.fuzzy;


import tech.szymanskazdrzalik.fuzzy.dao.AccidentDAO;
import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.utils.PropertiesLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AccidentDAO accidentDao = new ResourcesAccidentDao();
        var x = accidentDao.getAll("Data/" + PropertiesLoader.getJsonName());
        int y = 0;
    }
}
