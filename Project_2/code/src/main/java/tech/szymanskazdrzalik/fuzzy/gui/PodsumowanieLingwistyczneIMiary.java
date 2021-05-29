package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.MiaryJakosci;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.PodsumowanieLingwistyczne;

import java.util.function.Consumer;

public class PodsumowanieLingwistyczneIMiary {

    private final PodsumowanieLingwistyczne podsumowanieLingwistyczne;
    private final SimpleStringProperty tekst;
    private final SimpleDoubleProperty T2;

    public String getTekst() {
        return tekst.get();
    }

    public SimpleStringProperty tekstProperty() {
        return tekst;
    }

    private final SimpleDoubleProperty T3;
    private final SimpleDoubleProperty T4;
    private final SimpleDoubleProperty T6;
    private final SimpleDoubleProperty T7;
    private final SimpleDoubleProperty T8;
    private final SimpleDoubleProperty T9;
    private final SimpleDoubleProperty T10;
    private final SimpleDoubleProperty T11;
    private SimpleDoubleProperty T1 = null;
    private final SimpleDoubleProperty T5;

    public PodsumowanieLingwistyczneIMiary(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        final String[] tmp = {podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getNazwa()};
        // todo: NAZWA?
        tmp[0] += podsumowanieLingwistyczne.getKwalifikator() == null ?  "" :  podsumowanieLingwistyczne.getKwalifikator().getNazwa();
        podsumowanieLingwistyczne.getSumaryzator().forEach(wypadekEtykieta -> tmp[0] += wypadekEtykieta.getNazwa());
        tekst = new SimpleStringProperty(tmp[0]);
        this.podsumowanieLingwistyczne = podsumowanieLingwistyczne;
        try {
            this.T1 = new SimpleDoubleProperty(MiaryJakosci.stopienPrawdziwosci(podsumowanieLingwistyczne));
        } catch (MiaryJakosci.BrakKwalifikatora brakKwalifikatora) {
            brakKwalifikatora.printStackTrace();
            // TODO: 29.05.2021
        }
        this.T2 = new SimpleDoubleProperty(MiaryJakosci.stopienNieperecyzyjnosci(podsumowanieLingwistyczne));
        this.T3 = new SimpleDoubleProperty(MiaryJakosci.stopienPokrycia(podsumowanieLingwistyczne));
        this.T4 = new SimpleDoubleProperty(MiaryJakosci.stopienTrafnosci(podsumowanieLingwistyczne));
        this.T5 = new SimpleDoubleProperty(MiaryJakosci.dlugoscPodsumowania(podsumowanieLingwistyczne));
        this.T6 = new SimpleDoubleProperty(MiaryJakosci.stopienNieprecyzyjnosciKwantyfikatora(podsumowanieLingwistyczne));
        this.T7 = new SimpleDoubleProperty(MiaryJakosci.stopienKardynalnosciWzglednejKwantyfiaktora(podsumowanieLingwistyczne));
        this.T8 = new SimpleDoubleProperty(MiaryJakosci.stopienKardynalnosciWzglednejSumaryzatora(podsumowanieLingwistyczne));
        this.T9 = new SimpleDoubleProperty(MiaryJakosci.stopienNieprecyzyjnosciKwalifikatora(podsumowanieLingwistyczne));
        this.T10 = new SimpleDoubleProperty(MiaryJakosci.stopienKardynalnosciWzglednejKwalifikatora(podsumowanieLingwistyczne));
        this.T11 = new SimpleDoubleProperty(MiaryJakosci.dlugoscKwalifikatora(podsumowanieLingwistyczne));
    }

    public PodsumowanieLingwistyczne getPodsumowanieLingwistyczne() {
        return podsumowanieLingwistyczne;
    }

    public double getT2() {
        return T2.get();
    }

    public SimpleDoubleProperty t2Property() {
        return T2;
    }

    public double getT3() {
        return T3.get();
    }

    public SimpleDoubleProperty t3Property() {
        return T3;
    }

    public double getT4() {
        return T4.get();
    }

    public SimpleDoubleProperty t4Property() {
        return T4;
    }

    public double getT6() {
        return T6.get();
    }

    public SimpleDoubleProperty t6Property() {
        return T6;
    }

    public double getT7() {
        return T7.get();
    }

    public SimpleDoubleProperty t7Property() {
        return T7;
    }

    public double getT8() {
        return T8.get();
    }

    public SimpleDoubleProperty t8Property() {
        return T8;
    }

    public double getT9() {
        return T9.get();
    }

    public SimpleDoubleProperty t9Property() {
        return T9;
    }

    public double getT10() {
        return T10.get();
    }

    public SimpleDoubleProperty t10Property() {
        return T10;
    }

    public double getT11() {
        return T11.get();
    }

    public SimpleDoubleProperty t11Property() {
        return T11;
    }

    public double getT1() {
        return T1.get();
    }

    public SimpleDoubleProperty t1Property() {
        return T1;
    }

    public double getT5() {
        return T5.get();
    }

    public SimpleDoubleProperty t5Property() {
        return T5;
    }
}
