package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tech.szymanskazdrzalik.fuzzy.Main;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrapezoidalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrojkatna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Cisnienie;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.CzasTrwania;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.IloscOpadow;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Odleglosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PredkoscWiatru;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Temperatura;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.TemperaturaOdczuwalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Widocznosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Wilgotnosc;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwalifikatorySumaryzatory;
import tech.szymanskazdrzalik.fuzzy.predefiniowany.PredefiniowaneKwantyfikatory;

import java.io.IOException;
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
    public ComboBox<String> element;
    public ComboBox<String> zmienne;
    public Label jestAbsolutnyLabel;
    public Label zmiennaLabel;
    @FXML
    private TextField nazwa;

    @FXML
    private ComboBox<String> funkcjaKwantyfikatora;

    private String tempFunk;
    private List<String> elementy;
    private List<String> zmienneLista;

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
        this.setZapisz();
        this.setElement();
        this.setZmienne();
    }

    private void setElement() {
        this.elementy = new ArrayList<>();
        this.elementy.add("Kwantyfikator");
        this.elementy.add("Kwalifikator");
        this.elementy.add("Sumaryzator");
        this.element.setItems(FXCollections.observableArrayList(elementy));
        this.element.setValue(elementy.get(0));
    }

    private void setZmienne() {
        this.zmienneLista = new ArrayList<>();
        this.zmienneLista.add("Czas trwania");
        this.zmienneLista.add("Odległość");
        this.zmienneLista.add("Temperatura");
        this.zmienneLista.add("Temperatura odczuwalna");
        this.zmienneLista.add("Wilgotność");
        this.zmienneLista.add("Ciśnienie");
        this.zmienneLista.add("Widoczność");
        this.zmienneLista.add("Prędkość wiatru");
        this.zmienneLista.add("Ilość opadów");
        this.zmienne.setItems(FXCollections.observableArrayList(this.zmienneLista));
        this.zmienne.setValue(this.zmienneLista.get(0));
    }

    private void setDalej() {
        this.dalej.setOnAction(actionEvent -> ZaawansowanyUzytkownik.this.OnDalejClick());
    }

    private void OnDalejClick() {
        if (this.element.getValue().equals(this.elementy.get(0))) {
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

    private void setZapisz() {
        this.zapiszKwantyfiaktor.setOnAction(actionEvent -> ZaawansowanyUzytkownik.this.zapiszOnClick());
    }

    private void zapiszKwantyfikator(String nazwa) {
        Etykieta<Double> etykieta = setEtykietaKwantyfikator(nazwa);
        PredefiniowaneKwantyfikatory.addKwalifikator(new Kwantyfikator(etykieta, this.jestAbsolutny.isSelected()));
    }

    private Etykieta<Double> setEtykietaKwantyfikator(String nazwa) {
        Etykieta<Double> etykieta = null;
        switch (tempFunk) {
            case "Gaussowska":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaGausowska<>(Double.valueOf(this.pierwszyInput.getText()), 1.0,
                                Double.valueOf(this.drugiInput.getText()), 0.0, 1.0, aDouble -> aDouble));
                break;
            case "Trójkątna":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaTrojkatna<>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                Double.valueOf(this.trzeciInput.getText()), 0.0, 1.0, aDouble -> aDouble));
                break;
            case "Trapezoidalna":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaTrapezoidalna<>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                Double.valueOf(this.trzeciInput.getText()), Double.valueOf(this.czwartyInput.getText()),
                                0.0, 1.0, aDouble -> aDouble));

                break;
        }
        return etykieta;
    }

    private PobierzWartosc<Wypadek> pobierzWartoscZmiennej(String temp) {
        switch (temp) {
            case "Czas trwania":
                return new CzasTrwania();
            case "Odległość":
                return new Odleglosc();
            case "Temperatura":
                return new Temperatura();
            case "Temperatura odczuwalna":
                return new TemperaturaOdczuwalna();
            case "Wilgotność":
                return new Wilgotnosc();
            case "Ciśnienie":
                return new Cisnienie();
            case "Widoczność":
                return new Widocznosc();
            case "Prędkość wiatru":
                return new PredkoscWiatru();
            case "Ilość opadów":
                return new IloscOpadow();
        }
        return null;
    }


    private void zapiszKwalifikatorSumaryzator(String nazwa) {
        String temp = this.zmienne.getValue();
        Etykieta<Wypadek> wypadekEtykieta = setEtykietaKwalifikatorSumaryzator(nazwa, temp);
        switch (temp) {
            case "Czas trwania":
                PredefiniowaneKwalifikatorySumaryzatory.addCzasTrwania(wypadekEtykieta);
            case "Odległość":
                PredefiniowaneKwalifikatorySumaryzatory.addOdleglosc(wypadekEtykieta);
            case "Temperatura":
                PredefiniowaneKwalifikatorySumaryzatory.addTemperatura(wypadekEtykieta);
            case "Temperatura odczuwalna":
                PredefiniowaneKwalifikatorySumaryzatory.addTemperaturaOdczuwalna(wypadekEtykieta);
            case "Wilgotność":
                PredefiniowaneKwalifikatorySumaryzatory.addWilgotnosc(wypadekEtykieta);
            case "Ciśnienie":
                PredefiniowaneKwalifikatorySumaryzatory.addCisnienie(wypadekEtykieta);
            case "Widoczność":
                PredefiniowaneKwalifikatorySumaryzatory.addWidocznosc(wypadekEtykieta);
            case "Prędkość wiatru":
                PredefiniowaneKwalifikatorySumaryzatory.addPredkoscWiatru(wypadekEtykieta);
            case "Ilość opadów":
                PredefiniowaneKwalifikatorySumaryzatory.addIloscOpadow(wypadekEtykieta);
        }

    }

    private Etykieta<Wypadek> setEtykietaKwalifikatorSumaryzator(String nazwa, String temp) {
        PobierzWartosc<Wypadek> zmiennaAktualna = this.pobierzWartoscZmiennej(temp);
        Etykieta<Wypadek> etykieta = null;
        switch (tempFunk) {
            case "Gaussowska":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaGausowska<Wypadek>(Double.valueOf(this.pierwszyInput.getText()), 1.0,
                                Double.valueOf(this.drugiInput.getText()), 0.0, 1.0, zmiennaAktualna));
                break;
            case "Trójkątna":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaTrojkatna<Wypadek>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                Double.valueOf(this.trzeciInput.getText()), 0.0, 1.0, zmiennaAktualna));
                break;
            case "Trapezoidalna":
                etykieta = new Etykieta<>(nazwa,
                        new FunkcjaTrapezoidalna<Wypadek>(Double.valueOf(this.pierwszyInput.getText()), Double.valueOf(this.drugiInput.getText()),
                                Double.valueOf(this.trzeciInput.getText()), Double.valueOf(this.czwartyInput.getText()),
                                0.0, 1.0, zmiennaAktualna));

                break;
        }
        return etykieta;
    }

    private void zapiszOnClick() {
        String nazwa = this.nazwa.getText();
        String elementAktualny = this.element.getValue();
        switch (elementAktualny) {
            case "Kwantyfikator":
                this.zapiszKwantyfikator(nazwa);
                break;
            case "Kwalifikator":
            case "Sumaryzator":
                zapiszKwalifikatorSumaryzator(nazwa);
                break;
        }

    }

    public void doGlownego(ActionEvent actionEvent) throws IOException {
        Main.setRoot("main");
    }
}
