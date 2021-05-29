package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQuantifiers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField testText;

    @FXML
    private ComboBox<String> kwantyfikator = new ComboBox<>();

    @FXML
    private ComboBox<String> kwalifikator = new ComboBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.testText.setText("SEIMANKO");
        List<Kwantyfikator> kwantyfikatorList = PredefinedQuantifiers.getKwantyfikatorList();
        this.kwantyfikator.setItems(FXCollections.observableArrayList());
        this.kwalifikator.setItems(FXCollections.observableArrayList());
    }

}
