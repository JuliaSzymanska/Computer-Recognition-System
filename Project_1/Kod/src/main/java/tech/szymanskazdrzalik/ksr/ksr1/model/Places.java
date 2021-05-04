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

public class Places {
    private static final Places INSTANCE = new Places();
    private static String[] words = new String[0];

    // FIXME: 27.03.2021 FIX CLASS
    private Places() {
        try {
            loadPlaces(Objects.requireNonNull(Main.class.getClassLoader().getResource("Data/places.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadPlaces(String path) throws IOException {
        loadPlaces(new File(path));
    }

    private static void loadPlaces(URL path) throws IOException {
        loadPlaces(new File(path.getPath()));
    }

    private static void loadPlaces(File file) throws IOException {
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
