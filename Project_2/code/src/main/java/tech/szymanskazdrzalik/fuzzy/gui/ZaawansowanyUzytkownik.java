package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField nazwaKwantyfikatora;

    @FXML
    private ComboBox<String> funkcjaKwantyfikatora;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> list = new ArrayList<>();
        list.add("Gaussowska");
        list.add("Trójkątna");
        list.add("Trapezoidalna");
        this.funkcjaKwantyfikatora.setItems(FXCollections.observableArrayList(list));
        this.funkcjaKwantyfikatora.setValue(list.get(0));
    }

    private void setDalej() {
        this.dalej.setOnAction(actionEvent -> {
            ZaawansowanyUzytkownik.this.OnDalejClick();
        });
    }

    private void OnDalejClick() {
        String tempFunk = this.funkcjaKwantyfikatora.getValue();
        if (tempFunk.equals("Gaussowska")) {
            this.pierwszyLabel.setText("Sigma: ");
            this.pierwszyLabel.setVisible(true);
            this.pierwszyInput.setVisible(true);
            this.drugiLabel.setText("Środek");
            this.drugiLabel.setVisible(true);
            this.drugiInput.setVisible(true);
        }
        else if(tempFunk.equals("Trójkątna")){
            this.pierwszyLabel.setText("Sigma: ");
            this.pierwszyLabel.setVisible(true);
            this.pierwszyInput.setVisible(true);
            this.drugiLabel.setText("Środek");
            this.drugiLabel.setVisible(true);
            this.drugiInput.setVisible(true);
        }
    }


}
