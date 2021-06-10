package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDAO;
import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.ZmiennaLingwistyczna;
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
    public ComboBox<String> kwalifikatoryWybrane;
    public Button usunKwalifikator;

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
        Wspolne.setKwantyfikator(kwantyfikatorList, this.kwantyfikator);
//        this.setKwalifikator();
//        this.setDodajKwalifikator();
//        this.setKwalifikatorWybrane();
//        this.setUsunKwalifikator();
//        this.setAkceptacja();
//        this.setSumaryzatory();
//        this.setSumaryzatoryWybrane();
//        this.setDodaj();
//        this.setUsun();
//        this.setPoliczSumeWag();
//        this.initTable();
//        AccidentDAO accidentDao = new ResourcesAccidentDao();
//        this.podmioty = new ArrayList<>();
//        try {
//            this.podmioty = accidentDao.getAll("Data/" + PropertiesLoader.getJsonName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



    public void podsumowanie(ActionEvent actionEvent) {
    }
}
