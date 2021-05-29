package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
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
        this.kwantyfikator.setItems(FXCollections.observableArrayList("Hejka", "naklejka", "Siemanko"));
        this.kwalifikator.setItems(FXCollections.observableArrayList("Hejka", "naklejka", "Siemanko"));
    }

}
