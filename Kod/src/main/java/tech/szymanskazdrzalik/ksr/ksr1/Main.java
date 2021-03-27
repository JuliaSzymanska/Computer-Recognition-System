package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(FolderReader.readArticlesFromFolderInResources("Data/")));
    }


}
