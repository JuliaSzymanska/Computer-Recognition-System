package tech.szymanskazdrzalik.ksr.ksr1;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;

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
    public static void main(String[] args) throws IOException {
        FolderReader.readArticlesFromFolder("Data/");
    }


}
