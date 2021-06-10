package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDAO;
import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.WielopodmiotowePodsumowanieLingwistyczne;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.ZmiennaLingwistyczna;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwalifikatorySumaryzatory;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwantyfikatory;
import tech.szymanskazdrzalik.fuzzy.utils.PropertiesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Wielopodmiotowe implements Initializable {
    public ComboBox<String> forma;
    public ComboBox<String> podmiot1;
    public ComboBox<String> podmiot2;
    public ComboBox<String> sumaryzatory;
    public Button dodaj;
    public ComboBox<String> sumaryzatoryWybrane;
    public Button usun;
    public Button dalej;
    public ComboBox<String> kwantyfikator;
    public ComboBox<String> kwalifikator;
    public Button dodajKwalifikator;
    public Button usunKwalifikator;
    public ComboBox<String> kwalifikatorWybrane;

    private ObservableList<PodsumowanieLingwistyczneIMiary> podsumowanieLingwistyczneIMiaryObservableList;
    private List<Kwantyfikator> kwantyfikatorList;
    private List<ZmiennaLingwistyczna> kwalifikatoryList;
    private List<ZmiennaLingwistyczna> sumaryzatoryList;
    private ObservableList<String> sumaryzatoryListString;
    private ObservableList<String> kwalifikatoryString;
    private ObservableList<String> sumaryzatoryWybraneList;
    private ObservableList<String> kwalifikatorWybraneList;
    private List<Wypadek> podmioty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.kwantyfikatorList = PredefiniowaneKwantyfikatory.getKwantyfikatorList();
        this.kwalifikatoryList = PredefiniowaneKwalifikatorySumaryzatory.getAll();
        this.kwalifikatoryString = FXCollections.observableArrayList();
        this.kwalifikatorWybraneList = FXCollections.observableArrayList();
        this.kwalifikatorWybrane.setItems(this.kwalifikatorWybraneList);
        this.sumaryzatoryList = PredefiniowaneKwalifikatorySumaryzatory.getAll();
        this.sumaryzatoryListString = FXCollections.observableArrayList();
        this.sumaryzatoryWybraneList = FXCollections.observableArrayList();
        this.sumaryzatoryWybrane.setItems(this.sumaryzatoryWybraneList);

        this.setForma();
        Wspolne.setKwantyfikator(this.kwantyfikatorList, this.kwantyfikator);
        Wspolne.setKwalifikator(this.kwalifikatoryString, this.kwalifikatoryList, this.kwalifikator);
        this.dodajKwalifikator.setOnAction(actionEvent -> Wspolne.setDodajKwalifikator(kwalifikator, kwalifikatoryString, kwalifikatorWybraneList, kwalifikatorWybrane));
        this.usunKwalifikator.setOnAction(actionEvent -> Wspolne.setUsunKwalifikator(kwalifikator, kwalifikatoryString, kwalifikatorWybraneList, kwalifikatorWybrane));
        Wspolne.setSumaryzatory(sumaryzatoryList, sumaryzatoryListString, sumaryzatory);
//        this.akceptacja.setOnAction(actionEvent -> podsumowanie());
        this.dodaj.setOnAction(actionEvent -> Wspolne.setDodaj(sumaryzatoryWybraneList, sumaryzatoryListString, sumaryzatoryWybrane, sumaryzatory));
        this.usun.setOnAction(actionEvent -> Wspolne.setUsun(sumaryzatoryWybraneList, sumaryzatoryListString, sumaryzatoryWybrane, sumaryzatory));

    }

    private void setForma(){
        List<String> kwantyfikatoryString = new ArrayList<>();
        for (var e : WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.values()) {
            kwantyfikatoryString.add(e.toString());
        }
        this.forma.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        this.forma.setValue(kwantyfikatoryString.get(0));
    }



    public void podsumowanie(ActionEvent actionEvent) {
    }
}
