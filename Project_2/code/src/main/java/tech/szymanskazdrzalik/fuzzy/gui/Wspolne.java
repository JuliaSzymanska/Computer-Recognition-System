package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwantyfikatory;

import java.util.ArrayList;
import java.util.List;

public class Wspolne {

    public static final String ABSOLUTNY = " (Absolutny)";
    public static final String WZGLEDNY = " (Względny)";

    protected static void setKwantyfikator(List<Kwantyfikator> kwantyfikatorList, ComboBox<String> kwantyfikator) {
        List<String> kwantyfikatoryString = new ArrayList<>();
        for (var e : kwantyfikatorList) {
            kwantyfikatoryString.add(e.getEtykieta().getNazwa() + (e.getJestAbsolutny() ? ABSOLUTNY : WZGLEDNY));
        }
        kwantyfikatoryString.add("Brak");
        kwantyfikator.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        kwantyfikator.setValue(kwantyfikatoryString.get(0));
    }

}
