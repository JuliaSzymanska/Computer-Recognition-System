package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrapezoidalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrojkatna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQuantifiers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ZaawansowanyUzytkownik implements Initializable {

    public Button dalej;
    public Label pierwszyLabel;
    public TextField pierwszyInput;
    public Label drugiLabel;
    public TextField drugiInput;
    public Label trzeciLabel;
    public TextField trzeciInput;
    public TextField czwartyInput;
    public Label czwartyLabel;
    public Button zapiszKwantyfiaktor;
    public CheckBox jestAbsolutny;
    @FXML
    private TextField nazwaKwantyfikatora;

    @FXML
    private ComboBox<String> funkcjaKwantyfikatora;

    private String tempFunk;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> list = new ArrayList<>();
        list.add("Gaussowska");
        list.add("Trójkątna");
        list.add("Trapezoidalna");
        this.funkcjaKwantyfikatora.setItems(FXCollections.observableArrayList(list));
        this.funkcjaKwantyfikatora.setValue(list.get(0));
        this.setDalej();
        this.tempFunk = null;
        this.setZapiszKwantyfiaktor();
    }

    private void setDalej() {
        this.dalej.setOnAction(actionEvent -> {
            ZaawansowanyUzytkownik.this.OnDalejClick();
        });
    }

    private void OnDalejClick() {
        tempFunk = this.funkcjaKwantyfikatora.getValue();
        switch (tempFunk) {
            case "Gaussowska":
                this.pierwszyLabel.setText("Sigma: ");
                this.pierwszyLabel.setVisible(true);
                this.pierwszyInput.setVisible(true);
                this.drugiLabel.setText("Środek");
                this.drugiLabel.setVisible(true);
                this.drugiInput.setVisible(true);
                this.zapiszKwantyfiaktor.setVisible(true);
                this.trzeciLabel.setVisible(false);
                this.trzeciInput.setVisible(false);
                this.czwartyLabel.setVisible(false);
                this.czwartyInput.setVisible(false);
                break;
            case "Trójkątna":
                this.pierwszyLabel.setText("Początek: ");
                this.pierwszyLabel.setVisible(true);
                this.pierwszyInput.setVisible(true);
                this.drugiLabel.setText("Najwyższy");
                this.drugiLabel.setVisible(true);
                this.drugiInput.setVisible(true);
                this.trzeciLabel.setText("Koniec");
                this.trzeciLabel.setVisible(true);
                this.trzeciInput.setVisible(true);
                this.zapiszKwantyfiaktor.setVisible(true);
                this.czwartyLabel.setVisible(false);
                this.czwartyInput.setVisible(false);
                break;
            case "Trapezoidalna":
                this.pierwszyLabel.setText("Początek: ");
                this.pierwszyLabel.setVisible(true);
                this.pierwszyInput.setVisible(true);
                this.drugiLabel.setText("Początek max:");
                this.drugiLabel.setVisible(true);
                this.drugiInput.setVisible(true);
                this.trzeciLabel.setText("Koniec max:");
                this.trzeciLabel.setVisible(true);
                this.trzeciInput.setVisible(true);
                this.czwartyLabel.setText("Koniec");
                this.czwartyLabel.setVisible(true);
                this.czwartyInput.setVisible(true);
                this.zapiszKwantyfiaktor.setVisible(true);
                break;
        }
    }

    public void setZapiszKwantyfiaktor() {
        this.zapiszKwantyfiaktor.setOnAction(actionEvent -> {
            ZaawansowanyUzytkownik.this.zapiszKwantyfiaktorOnClick();
        });
    }

    private void zapiszKwantyfiaktorOnClick() {
        switch (tempFunk) {
            case "Gaussowska":
                PredefinedQuantifiers.addKwalifikator(
                        new Kwantyfikator(
                                new Etykieta<>(this.nazwaKwantyfikatora.getText(),
                                        new FunkcjaGausowska<>(Double.valueOf(this.pierwszyInput.getText()), 1.0,
                                                Double.valueOf(this.drugiInput.getText()), 0.0, 1.0, aDouble -> aDouble)),
                                this.jestAbsolutny.isSelected()));
                break;
            case "Trójkątna":
                PredefinedQuantifiers.addKwalifikator(
                        new Kwantyfikator(
                                new Etykieta<>(this.nazwaKwantyfikatora.getText(),
                                        new FunkcjaTrojkatna<>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                                Double.valueOf(this.trzeciInput.getText()), 0.0, 1.0, aDouble -> aDouble)),
                                this.jestAbsolutny.isSelected()));
                break;
            case "Trapezoidalna":
                PredefinedQuantifiers.addKwalifikator(
                        new Kwantyfikator(
                                new Etykieta<>(this.nazwaKwantyfikatora.getText(),
                                        new FunkcjaTrapezoidalna<>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                                Double.valueOf(this.trzeciInput.getText()), Double.valueOf(this.czwartyInput.getText()), 0.0, 1.0, aDouble -> aDouble)),
                                this.jestAbsolutny.isSelected()));
                break;
        }

    }
}
