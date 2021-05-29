package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
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
    private Button akceptacja;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setKwantyfikator();
        this.setKwalifikator();
        this.setAkceptacja();
        this.testText.setText(this.kwantyfikator.getSelectionModel().getSelectedItem());
    }

    private void setKwantyfikator() {
        List<Kwantyfikator> kwantyfikatorList = PredefinedQuantifiers.getKwantyfikatorList();
        List<String> kwantyfikatoryString = new ArrayList<>();
        for (var e : kwantyfikatorList) {
            kwantyfikatoryString.add(e.getEtykieta().getNazwa() + (e.getJestAbsolutny() ? " (Absolutny)" : " (Względny)"));
        }
        kwantyfikatoryString.add("Brak");
        this.kwantyfikator.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        this.kwantyfikator.setValue(kwantyfikatoryString.get(0));
    }

    private void setKwalifikator() {
        List<Etykieta<Wypadek>> kwalifikatoryList = PredefinedQualifiers.getKwalifikatorList();
        List<String> kwalifikatoryString = new ArrayList<>();
        for (var e : kwalifikatoryList) {
            kwalifikatoryString.add(e.getNazwa());
        }
        kwalifikatoryString.add("Brak");
        this.kwalifikator.setItems(FXCollections.observableArrayList(kwalifikatoryString));
        this.kwalifikator.setValue(kwalifikatoryString.get(0));
    }

    private void setAkceptacja() {
        this.akceptacja.setText("Wybierz");
        this.akceptacja.setOnAction(e -> MainController.this.testText.setText(MainController.this.kwantyfikator.getSelectionModel().getSelectedItem()));
    }

}