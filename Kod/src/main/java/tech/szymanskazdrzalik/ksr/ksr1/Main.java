package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(FolderReader.readArticlesFromFolderInResources("Data/"));
    }


}
