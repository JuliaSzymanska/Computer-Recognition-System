package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private TextField testText;

    @FXML
    private ComboBox<String> kwantyfikator;

    @FXML
    private ComboBox<String> kwalifikator;

    @FXML
    private ComboBox<String> sumaryzatory;

    @FXML
    private ComboBox<String> wybraneSumaryzatory;

    @FXML
    private Button dodaj;

    @FXML
    private Button usun;

    @FXML
    private Button akceptacja;

    private List<Kwantyfikator> kwantyfikatorList;
    private List<Etykieta<Wypadek>> kwalifikatoryList;
    private List<Etykieta<Wypadek>> sumaryzatoryList;
    private List<String> sumaryzatoryWybraneList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setKwantyfikator();
        this.setKwalifikator();
        this.setAkceptacja();
        this.setSumaryzatory();
        this.setSumaryzatoryWybrane();
        this.setDodaj();
        this.setUsun();
        this.testText.setText(this.kwantyfikator.getSelectionModel().getSelectedItem());
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
        List<String> sumaryzatoryString = new ArrayList<>();
        for (var e : this.sumaryzatoryList) {
            sumaryzatoryString.add(e.getNazwa());
        }
        sumaryzatoryString.add("Brak");
        this.kwalifikator.setItems(FXCollections.observableArrayList(sumaryzatoryString));
        this.kwalifikator.setValue(sumaryzatoryString.get(0));
    }

    private void setDodaj() {
        this.dodaj.setOnAction(actionEvent -> {
            MainController.this.sumaryzatoryWybraneList.add(MainController.this.kwantyfikator.getSelectionModel().getSelectedItem());
            MainController.this.kwalifikator.setValue(sumaryzatoryWybraneList.get(0));
        });
    }

    private void setSumaryzatoryWybrane() {
        this.sumaryzatoryWybraneList = new ArrayList<>();
        this.kwalifikator.setItems(FXCollections.observableArrayList(this.sumaryzatoryWybraneList));
    }

    private void setUsun() {
        this.usun.setOnAction(e -> MainController.this.sumaryzatoryWybraneList.remove(MainController.this.kwantyfikator.getSelectionModel().getSelectedItem()));
    }

    private void setAkceptacja() {
        this.akceptacja.setOnAction(e -> MainController.this.testText.setText(MainController.this.kwantyfikator.getSelectionModel().getSelectedItem()));
    }

}