package tech.szymanskazdrzalik.ksr.ksr1.dao;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class FileReader {

    private FileReader() {

    }

    public static String Parse(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder str = new StringBuilder();
        while (bufferedReader.ready()) {
            str.append(bufferedReader.readLine());
        }
        return str.toString();
    }

    public static String Parse(String path) throws IOException {
        return Parse(new File(path));
    }

    public static String Parse(URL path) throws IOException {
        return Parse(new File(path.getPath()));
    }
}
