package tech.szymanskazdrzalik.fuzzy.dao;

import tech.szymanskazdrzalik.fuzzy.gui.PodsumowanieLingwistyczneIMiary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FilePodsumowanieLingwistyczneIMiarySaveDAO implements PodsumowanieLingwistyczneIMiarySaveDAO {
    private final String fileName;

    public FilePodsumowanieLingwistyczneIMiarySaveDAO(String filename) {
        this.fileName = filename;
    }

    @Override
    public void Save(PodsumowanieLingwistyczneIMiary podsumowanieLingwistyczneIMiary) {
        try (
                OutputStreamWriter writer = new OutputStreamWriter(
                        new FileOutputStream(fileName + ".txt"), StandardCharsets.UTF_8);
        ) {
            writer.write(podsumowanieLingwistyczneIMiary.toString());
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
