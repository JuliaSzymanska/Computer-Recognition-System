package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.MiaryJakosci;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.PodsumowanieLingwistyczne;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.function.Consumer;

public class PodsumowanieLingwistyczneIMiary {

    private final static NumberFormat formatter = new DecimalFormat("#0.00");
    private final PodsumowanieLingwistyczne podsumowanieLingwistyczne;
    private final SimpleStringProperty tekst;
    private final SimpleStringProperty T2;

    public String getTekst() {
        return tekst.get();
    }

    public SimpleStringProperty tekstProperty() {
        return tekst;
    }

    private final SimpleStringProperty T3;
    private final SimpleStringProperty T4;
    private final SimpleStringProperty T6;
    private final SimpleStringProperty T7;
    private final SimpleStringProperty T8;
    private final SimpleStringProperty T9;
    private final SimpleStringProperty T10;
    private final SimpleStringProperty T11;
    private SimpleStringProperty T1 = null;
    private final SimpleStringProperty T5;

    public static NumberFormat getFormatter() {
        return formatter;
    }

    public String getT2() {
        return T2.get();
    }

    public SimpleStringProperty t2Property() {
        return T2;
    }

    public String getT3() {
        return T3.get();
    }

    public SimpleStringProperty t3Property() {
        return T3;
    }

    public String getT4() {
        return T4.get();
    }

    public SimpleStringProperty t4Property() {
        return T4;
    }

    public String getT6() {
        return T6.get();
    }

    public SimpleStringProperty t6Property() {
        return T6;
    }

    public String getT7() {
        return T7.get();
    }

    public SimpleStringProperty t7Property() {
        return T7;
    }

    public String getT8() {
        return T8.get();
    }

    public SimpleStringProperty t8Property() {
        return T8;
    }

    public String getT9() {
        return T9.get();
    }

    public SimpleStringProperty t9Property() {
        return T9;
    }

    public String getT10() {
        return T10.get();
    }

    public SimpleStringProperty t10Property() {
        return T10;
    }

    public String getT11() {
        return T11.get();
    }

    public SimpleStringProperty t11Property() {
        return T11;
    }

    public String getT1() {
        return T1.get();
    }

    public SimpleStringProperty t1Property() {
        return T1;
    }

    public String getT5() {
        return T5.get();
    }

    public SimpleStringProperty t5Property() {
        return T5;
    }

    public PodsumowanieLingwistyczneIMiary(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getNazwa());
        stringBuilder.append(" wypadki");
        stringBuilder.append(podsumowanieLingwistyczne.getKwalifikator() == null ?  "" : " " + podsumowanieLingwistyczne.getKwalifikator().getNazwa());
        podsumowanieLingwistyczne.getSumaryzator().forEach(wypadekEtykieta -> stringBuilder.append(" ").append(wypadekEtykieta.getNazwa()));
        tekst = new SimpleStringProperty(stringBuilder.toString());
        this.podsumowanieLingwistyczne = podsumowanieLingwistyczne;
        try {
            var x = MiaryJakosci.stopienPrawdziwosci(podsumowanieLingwistyczne);
            this.T1 = new SimpleStringProperty(formatter.format(x));
        } catch (MiaryJakosci.BrakKwalifikatora brakKwalifikatora) {
            brakKwalifikatora.printStackTrace();
            // TODO: 29.05.2021
        }
        this.T2 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienNieperecyzyjnosci(podsumowanieLingwistyczne)));
        this.T3 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienPokrycia(podsumowanieLingwistyczne)));
        this.T4 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienTrafnosci(podsumowanieLingwistyczne)));
        this.T5 = new SimpleStringProperty(formatter.format(MiaryJakosci.dlugoscPodsumowania(podsumowanieLingwistyczne)));
        this.T6 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienNieprecyzyjnosciKwantyfikatora(podsumowanieLingwistyczne)));
        this.T7 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienKardynalnosciWzglednejKwantyfiaktora(podsumowanieLingwistyczne)));
        this.T8 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienKardynalnosciWzglednejSumaryzatora(podsumowanieLingwistyczne)));
        if (this.podsumowanieLingwistyczne.getKwalifikator() != null) {
            this.T9 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienNieprecyzyjnosciKwalifikatora(podsumowanieLingwistyczne)));
            this.T10 = new SimpleStringProperty(formatter.format(MiaryJakosci.stopienKardynalnosciWzglednejKwalifikatora(podsumowanieLingwistyczne)));
            this.T11 = new SimpleStringProperty(formatter.format(MiaryJakosci.dlugoscKwalifikatora(podsumowanieLingwistyczne)));
        } else {
            this.T9 = new SimpleStringProperty("null");
            this.T10 = new SimpleStringProperty("null");
            this.T11 = new SimpleStringProperty("0");
        }
    }

    public PodsumowanieLingwistyczne getPodsumowanieLingwistyczne() {
        return podsumowanieLingwistyczne;
    }


}
