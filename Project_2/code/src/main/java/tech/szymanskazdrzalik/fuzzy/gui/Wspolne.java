package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.ZmiennaLingwistyczna;

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
        kwantyfikator.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        kwantyfikator.setValue(kwantyfikatoryString.get(0));
    }

    protected static void setKwalifikator(ObservableList<String> kwalifikatoryString,
                                          List<ZmiennaLingwistyczna> kwalifikatoryList,
                                          ComboBox<String> kwalifikator) {
        for (var e : kwalifikatoryList) {
            for (var v : e.getEtykiety()) {
                kwalifikatoryString.add(v.getNazwa());
            }
        }
        kwalifikator.setItems(kwalifikatoryString);
        kwalifikator.setValue(kwalifikatoryString.get(0));
    }

    protected static void setDodajKwalifikator(ComboBox<String> kwalifikator,
                                               ObservableList<String> kwalifikatoryString,
                                               ObservableList<String> kwalifikatorWybraneList,
                                               ComboBox<String> kwalifikatorWybrane) {
        String selected = kwalifikator.getSelectionModel().getSelectedItem();
        kwalifikatorWybraneList.add(selected);
        kwalifikatoryString.remove(selected);
        kwalifikatorWybrane.setValue(kwalifikatorWybraneList.get(0));
    }

    protected static void setUsunKwalifikator(ComboBox<String> kwalifikator,
                                              ObservableList<String> kwalifikatoryString,
                                              ObservableList<String> kwalifikatorWybraneList,
                                              ComboBox<String> kwalifikatorWybrane) {
        String selected = kwalifikatorWybrane.getSelectionModel().getSelectedItem();
        kwalifikatoryString.add(selected);
        kwalifikatorWybraneList.remove(selected);
        kwalifikator.setValue(kwalifikatoryString.get(0));
    }

    protected static void setSumaryzatory(List<ZmiennaLingwistyczna> sumaryzatoryList,
                                          ObservableList<String> sumaryzatoryListString,
                                          ComboBox<String> sumaryzatory) {
        for (var e : sumaryzatoryList) {
            for (var v : e.getEtykiety()) {
                sumaryzatoryListString.add(v.getNazwa());
            }
        }
        sumaryzatory.setItems(sumaryzatoryListString);
        sumaryzatory.setValue(sumaryzatoryListString.get(0));
    }

    protected static void setDodaj(ObservableList<String> sumaryzatoryWybraneList,
                                   ObservableList<String> sumaryzatoryListString,
                                   ComboBox<String> sumaryzatoryWybrane,
                                   ComboBox<String> sumaryzatory) {
        String selected = sumaryzatory.getSelectionModel().getSelectedItem();
        sumaryzatoryWybraneList.add(selected);
        sumaryzatoryListString.remove(selected);
        sumaryzatoryWybrane.setValue(sumaryzatoryWybraneList.get(0));
    }

    protected static void setUsun(ObservableList<String> sumaryzatoryWybraneList,
                                  ObservableList<String> sumaryzatoryListString,
                                  ComboBox<String> sumaryzatoryWybrane,
                                  ComboBox<String> sumaryzatory) {
            String selected = sumaryzatoryWybrane.getSelectionModel().getSelectedItem();
            sumaryzatoryListString.add(selected);
            sumaryzatoryWybraneList.remove(selected);
            sumaryzatory.setValue(sumaryzatoryListString.get(0));
    }

}
