package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.jetbrains.annotations.Nullable;
import tech.szymanskazdrzalik.ksr.ksr1.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class KeyWords {

    private static String[] words = new String[0];

    private static final KeyWords INSTANCE = new KeyWords();

    private KeyWords() {
        try {
            loadKeyWords(Objects.requireNonNull(Main.class.getClassLoader().getResource("Data/keywords.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadKeyWords(String path) throws IOException {
        loadKeyWords(new File(path));
    }

    private static void loadKeyWords(URL path) throws IOException {
        loadKeyWords(new File(path.getPath()));
    }

    private static void loadKeyWords(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);
        fileInputStream.close();
        String str = new String(data, StandardCharsets.UTF_8);
        words = str.split(" ");
    }

    public static boolean contains(@Nullable String word) {
        if (words.length == 0) {
            // TODO: 26.03.2021 load default keywords
        }
        return Arrays.asList(words).contains(word);
    }

}
