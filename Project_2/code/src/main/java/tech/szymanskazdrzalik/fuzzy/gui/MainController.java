package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQualifiers;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQuantifiers;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedSumarizators;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ComboBox<String> kwantyfikator;

    @FXML
    private ComboBox<String> kwalifikator;

    @FXML
    private ComboBox<String> sumaryzatory;

    @FXML
    private ComboBox<String> sumaryzatoryWybrane;

    @FXML
    private Button dodaj;

    @FXML
    private Button usun;

    @FXML
    private Button akceptacja;

    private List<Kwantyfikator> kwantyfikatorList;
    private List<Etykieta<Wypadek>> kwalifikatoryList;
    private List<Etykieta<Wypadek>> sumaryzatoryList;
    private ObservableList<String> sumaryzatoryListString;
    private ObservableList<String> sumaryzatoryWybraneList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setKwantyfikator();
        this.setKwalifikator();
        this.setAkceptacja();
        this.setSumaryzatory();
        this.setSumaryzatoryWybrane();
        this.setDodaj();
        this.setUsun();
    }

    private void setKwantyfikator() {
        this.kwantyfikatorList = PredefinedQuantifiers.getKwantyfikatorList();
        List<String> kwantyfikatoryString = new ArrayList<>();
        for (var e : this.kwantyfikatorList) {
            kwantyfikatoryString.add(e.getEtykieta().getNazwa() + (e.getJestAbsolutny() ? " (Absolutny)" : " (Względny)"));
        }
        kwantyfikatoryString.add("Brak");
        this.kwantyfikator.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        this.kwantyfikator.setValue(kwantyfikatoryString.get(0));
    }

    private void setKwalifikator() {
        this.kwalifikatoryList = PredefinedQualifiers.getKwalifikatorList();
        List<String> kwalifikatoryString = new ArrayList<>();
        for (var e : this.kwalifikatoryList) {
            kwalifikatoryString.add(e.getNazwa());
        }
        kwalifikatoryString.add("Brak");
        this.kwalifikator.setItems(FXCollections.observableArrayList(kwalifikatoryString));
        this.kwalifikator.setValue(kwalifikatoryString.get(0));
    }

    private void setSumaryzatory() {
        this.sumaryzatoryList = PredefinedSumarizators.getSumaryzatorList();
        this.sumaryzatoryListString = FXCollections.observableArrayList();
        for (var e : this.sumaryzatoryList) {
            this.sumaryzatoryListString.add(e.getNazwa());
        }
        this.sumaryzatory.setItems(this.sumaryzatoryListString);
        this.sumaryzatory.setValue(this.sumaryzatoryListString.get(0));
    }

    private void setDodaj() {
        this.dodaj.setOnAction(actionEvent -> {
            String selected = MainController.this.sumaryzatory.getSelectionModel().getSelectedItem();
            MainController.this.sumaryzatoryWybraneList.add(selected);
            MainController.this.sumaryzatoryListString.remove(selected);
            MainController.this.sumaryzatoryWybrane.setValue(sumaryzatoryWybraneList.get(0));
        });
    }

    private void setSumaryzatoryWybrane() {
        this.sumaryzatoryWybraneList = FXCollections.observableArrayList();
        this.sumaryzatoryWybrane.setItems(this.sumaryzatoryWybraneList);
    }

    private void setUsun() {
        this.usun.setOnAction(actionEvent -> {
            String selected = MainController.this.sumaryzatoryWybrane.getSelectionModel().getSelectedItem();
            MainController.this.sumaryzatoryListString.add(selected);
            MainController.this.sumaryzatoryWybraneList.remove(selected);
            MainController.this.sumaryzatory.setValue(sumaryzatoryListString.get(0));
        });
    }

    private void setAkceptacja() {
        this.usun.setOnAction(actionEvent -> {
            String selected = MainController.this.sumaryzatoryWybrane.getSelectionModel().getSelectedItem();
            MainController.this.sumaryzatoryListString.add(selected);
            MainController.this.sumaryzatoryWybraneList.remove(selected);
            MainController.this.sumaryzatory.setValue(sumaryzatoryListString.get(0));
        });
    }

}