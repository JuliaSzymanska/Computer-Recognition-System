package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import tech.szymanskazdrzalik.fuzzy.dao.FilePodsumowanieLingwistyczneIMiarySaveDAO;
import tech.szymanskazdrzalik.fuzzy.dao.FileWielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao;
import tech.szymanskazdrzalik.fuzzy.dao.PodsumowanieLingwistyczneIMiarySaveDAO;
import tech.szymanskazdrzalik.fuzzy.dao.WielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.MiaryJakosci;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.WielopodmiotowePodsumowanieLingwistyczne;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class WielopodmiotowePodsumowanieLingwistyczneIMiary {
    private final static String NAZWA_PLIKU = "podsumowanie";
    private final static NumberFormat formatter = new DecimalFormat("#0.00");
    private final WielopodmiotowePodsumowanieLingwistyczne podsumowanieLingwistyczne;
    private final SimpleStringProperty tekst;
    private final Button button;
    private final SimpleStringProperty T1;
    private final Double T1value;

    public WielopodmiotowePodsumowanieLingwistyczneIMiary(WielopodmiotowePodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        // TODO: 10.06.2021 TEKST
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getNazwa());
        stringBuilder.append(" wypadków");
        podsumowanieLingwistyczne.getKwalifikator().forEach(etykieta -> stringBuilder.append(" będących ").append(etykieta.getNazwa()));
        podsumowanieLingwistyczne.getSumaryzator().forEach(wypadekEtykieta -> stringBuilder.append(", jest ").append(wypadekEtykieta.getNazwa()));
        tekst = new SimpleStringProperty(stringBuilder.toString());
        this.podsumowanieLingwistyczne = podsumowanieLingwistyczne;
        var x = MiaryJakosci.stopienPrawdziwosci(podsumowanieLingwistyczne);
        this.T1value = x;
        this.T1 = new SimpleStringProperty(formatter.format(x));
        this.button = new Button("Zapisz");
        this.button.setOnAction(actionEvent -> zapiszDoPliku());
    }


    public static String getNazwaPliku() {
        return NAZWA_PLIKU;
    }

    public static NumberFormat getFormatter() {
        return formatter;
    }

    public WielopodmiotowePodsumowanieLingwistyczne getPodsumowanieLingwistyczne() {
        return podsumowanieLingwistyczne;
    }

    public String getTekst() {
        return tekst.get();
    }

    public SimpleStringProperty tekstProperty() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst.set(tekst);
    }

    public Button getButton() {
        return button;
    }

    public String getT1() {
        return T1.get();
    }

    public SimpleStringProperty t1Property() {
        return T1;
    }

    public void setT1(String t1) {
        this.T1.set(t1);
    }

    public Double getT1value() {
        return T1value;
    }

    private void zapiszDoPliku() {
        WielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao saveDAO = new FileWielopodmiotowePodsumowanieLingwistyczneIMiarySaveDao(NAZWA_PLIKU);
        saveDAO.Save(this);
    }





}
