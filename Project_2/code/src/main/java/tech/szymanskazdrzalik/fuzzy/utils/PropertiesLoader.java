package tech.szymanskazdrzalik.fuzzy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {

    private static final PropertiesLoader INSTANCE = new PropertiesLoader();

    private static String jsonName;

    public static String getJsonName() {
        return jsonName;
    }

    private PropertiesLoader() {
        jsonName = "";
        loadProperties();
    }

    private static void loadProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream inputStream  = PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream("application.properties");
            if (inputStream != null) {
                prop.load(inputStream);
                jsonName = prop.getProperty("json.name");
            }
        } catch (IOException e) {
            // TODO: 18.04.2021
        }
    }
}
