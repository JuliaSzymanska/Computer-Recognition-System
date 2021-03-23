package tech.szymanskazdrzalik.ksr.ksr1;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static tech.szymanskazdrzalik.ksr.ksr1.dao.FileReader.Parse;

public class Main {
    private static List<String> strings = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        List<String> files = IOUtils.readLines(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("Data/")));
        for (var x : files) {
            if(x.endsWith(".sgm")) {
                System.out.println(x);
                Parse(Thread.currentThread().getContextClassLoader().getResource("Data/" + x));
            }
        }
        for (var x : strings) {
            System.out.println(x);
        }
        System.out.println(strings.size());
        System.out.println(files);

    }


}
