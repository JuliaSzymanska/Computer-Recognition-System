package tech.szymanskazdrzalik.fuzzy.dao;

import tech.szymanskazdrzalik.fuzzy.gui.PodsumowanieLingwistyczneIMiary;
import tech.szymanskazdrzalik.fuzzy.gui.WielopodmiotowePodsumowanieLingwistyczneIMiary;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.WielopodmiotowePodsumowanieLingwistyczne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

public class FileWielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao implements WielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao{
    private final String fileName;

    private DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMddHH");

    public FileWielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao(String filename) {
        this.fileName = filename;
    }

    @Override
    public void Save(WielopodmiotowePodsumowanieLingwistyczneIMiary podsumowanieLingwistyczneIMiary) {
        try (
                OutputStreamWriter writer = new OutputStreamWriter(
                        new FileOutputStream(fileName + "_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".txt", true), StandardCharsets.UTF_8);
        ) {
            writer.append(podsumowanieLingwistyczneIMiary.toString());
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
