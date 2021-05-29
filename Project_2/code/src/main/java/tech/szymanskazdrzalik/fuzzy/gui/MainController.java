package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView podsumowanieTable;
    @FXML
    public TableColumn columnTekst;
    @FXML
    public TableColumn columnT1;
    @FXML
    public TableColumn columnT2;
    @FXML
    public TableColumn columnT3;
    @FXML
    public TableColumn columnT4;
    @FXML
    public TableColumn columnT5;
    @FXML
    public TableColumn columnT6;
    @FXML
    public TableColumn columnT7;
    @FXML
    public TableColumn columnT8;
    @FXML
    public TableColumn columnT9;
    @FXML
    public TableColumn columnT10;
    @FXML
    public TableColumn columnT11;
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

    private ObservableList<PodsumowanieLingwistyczneIMiary> podsumowanieLingwistyczneIMiaryObservableList;
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
        this.initTable();
    }

    private void initTable () {
        this.podsumowanieLingwistyczneIMiaryObservableList = FXCollections.observableArrayList();
        this.columnTekst.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("tekst"));
        this.columnT1.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T1"));
        this.columnT2.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T2"));
        this.columnT3.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T3"));
        this.columnT4.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T4"));
        this.columnT5.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T5"));
        this.columnT6.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T6"));
        this.columnT7.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T7"));
        this.columnT8.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T8"));
        this.columnT9.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T9"));
        this.columnT10.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T10"));
        this.columnT11.setCellValueFactory(new PropertyValueFactory<PodsumowanieLingwistyczneIMiary, String>("T11"));
        this.podsumowanieTable.setItems(podsumowanieLingwistyczneIMiaryObservableList);
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