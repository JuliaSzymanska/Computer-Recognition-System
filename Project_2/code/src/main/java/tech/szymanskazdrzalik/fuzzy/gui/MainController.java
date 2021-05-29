package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDAO;
import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.PodsumowanieLingwistyczne;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQualifiers;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedQuantifiers;
import tech.szymanskazdrzalik.fuzzy.predefined.PredefinedSumarizators;
import tech.szymanskazdrzalik.fuzzy.utils.PropertiesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final String ABSOLUTNY = " (Absolutny)";
    private final String WZGLEDNY = " (Względny)";
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
    private List<Wypadek> podmioty;

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
        AccidentDAO accidentDao = new ResourcesAccidentDao();
        this.podmioty = new ArrayList<>();
        try {
            this.podmioty = accidentDao.getAll("Data/" + PropertiesLoader.getJsonName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
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
            kwantyfikatoryString.add(e.getEtykieta().getNazwa() + (e.getJestAbsolutny() ? ABSOLUTNY : WZGLEDNY));
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
        this.akceptacja.setOnAction(actionEvent -> MainController.this.podsumowanie());
    }

    private void podsumowanie() {
        System.out.println("Hejka naklejka");
        Kwantyfikator wybranyKwantyfikator = null;
        Etykieta<Wypadek> wybranyKwalifikator = null;
        List<Etykieta<Wypadek>> wybraneSumaryzatory = new ArrayList<>();
        String tempKwantyfiaktor = this.kwantyfikator.getSelectionModel().getSelectedItem();
        if (tempKwantyfiaktor.contains(ABSOLUTNY)) {
            tempKwantyfiaktor = tempKwantyfiaktor.substring(0, tempKwantyfiaktor.indexOf(ABSOLUTNY));
        } else {
            tempKwantyfiaktor = tempKwantyfiaktor.substring(0, tempKwantyfiaktor.indexOf(WZGLEDNY));
        }
        System.out.println(tempKwantyfiaktor);
        for (var e : this.kwantyfikatorList) {

            if (e.getEtykieta().getNazwa().equals(tempKwantyfiaktor)) {
                wybranyKwantyfikator = e;
                break;
            }
        }

        String tempKwalifikator = this.kwalifikator.getSelectionModel().getSelectedItem();
        for (var e : this.kwalifikatoryList) {
            if (e.getNazwa().equals(tempKwalifikator)) {
                wybranyKwalifikator = e;
                break;
            }
        }

        for (var e : this.sumaryzatoryList) {
            for (var f : this.sumaryzatoryWybraneList)
                if (e.getNazwa().equals(f)) {
                    wybraneSumaryzatory.add(e);
                    break;
                }
        }
        PodsumowanieLingwistyczne podsumowanieLingwistyczne = new PodsumowanieLingwistyczne(wybranyKwantyfikator, this.podmioty, wybraneSumaryzatory, wybranyKwalifikator);
        PodsumowanieLingwistyczneIMiary podsumowanieLingwistyczneIMiary = new PodsumowanieLingwistyczneIMiary(podsumowanieLingwistyczne);
        this.podsumowanieLingwistyczneIMiaryObservableList.add(podsumowanieLingwistyczneIMiary);

    }

}