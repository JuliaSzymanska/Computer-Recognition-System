package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.WielopodmiotowePodsumowanieLingwistyczne;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.ZmiennaLingwistyczna;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwalifikatorySumaryzatory;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwantyfikatory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Wielopodmiotowe implements Initializable {
    public ComboBox<String> forma;
    public ComboBox<String> podmiot1; ////////////////////////////////////////
    public ComboBox<String> podmiot2; ////////////////////////////////////////
    public ComboBox<String> sumaryzatory;
    public Button dodaj;
    public ComboBox<String> sumaryzatoryWybrane;
    public Button usun;
    public Button dalej; /////////////////////////////////////////
    public ComboBox<String> kwantyfikator;
    public ComboBox<String> kwalifikator;
    public Button dodajKwalifikator;
    public Button usunKwalifikator;
    public ComboBox<String> kwalifikatorWybrane;
    public Button podsumowaniePrzycisk;

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
        this.dodajKwalifikator.setOnAction(actionEvent -> Wspolne.setDodajKwalifikator(this.kwalifikator, this.kwalifikatoryString, this.kwalifikatorWybraneList, this.kwalifikatorWybrane));
        this.usunKwalifikator.setOnAction(actionEvent -> Wspolne.setUsunKwalifikator(this.kwalifikator, this.kwalifikatoryString, this.kwalifikatorWybraneList, this.kwalifikatorWybrane));
        Wspolne.setSumaryzatory(this.sumaryzatoryList, this.sumaryzatoryListString, this.sumaryzatory);
//        this.akceptacja.setOnAction(actionEvent -> podsumowanie());
        this.dodaj.setOnAction(actionEvent -> Wspolne.setDodaj(this.sumaryzatoryWybraneList, this.sumaryzatoryListString, this.sumaryzatoryWybrane, this.sumaryzatory));
        this.usun.setOnAction(actionEvent -> Wspolne.setUsun(this.sumaryzatoryWybraneList, this.sumaryzatoryListString, this.sumaryzatoryWybrane, this.sumaryzatory));
        this.dalej.setOnAction(actionEvent -> this.setDalej());
    }

    private void setDalej() {
        this.podsumowaniePrzycisk.setVisible(true);
        if (this.forma.getValue().equals(WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.PIERWSZA_FORMA.toString())) {
            this.jestAbsolutny.setVisible(true);
            this.jestAbsolutnyLabel.setVisible(true);
            this.zmienne.setVisible(false);
            this.zmiennaLabel.setVisible(false);
        } else if (this.element.getValue().equals(this.elementy.get(1)) || this.element.getValue().equals(this.elementy.get(2))) {
            this.zmienne.setVisible(true);
            this.zmiennaLabel.setVisible(true);
            this.jestAbsolutny.setVisible(false);
            this.jestAbsolutnyLabel.setVisible(false);
        }
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

    private void setForma() {
        List<String> kwantyfikatoryString = new ArrayList<>();
        for (var e : WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.values()) {
            kwantyfikatoryString.add(e.toString());
        }
        kwantyfikatoryString.add(WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.PIERWSZA_FORMA.toString());
        kwantyfikatoryString.add(WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.DRUGA_FORMA.toString());
        kwantyfikatoryString.add(WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.TRZECIA_FORMA.toString());
        kwantyfikatoryString.add(WielopodmiotowePodsumowanieLingwistyczne.RodzajPodsumowania.CZWARTA_FORMA.toString());
        this.forma.setItems(FXCollections.observableArrayList(kwantyfikatoryString));
        this.forma.setValue(kwantyfikatoryString.get(0));
    }


    public void podsumowanie(ActionEvent actionEvent) {
    }
}
