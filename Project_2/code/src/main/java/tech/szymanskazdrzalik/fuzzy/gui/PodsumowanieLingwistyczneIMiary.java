package tech.szymanskazdrzalik.fuzzy.gui;

import javafx.beans.property.SimpleStringProperty;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.MiaryJakosci;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.PodsumowanieLingwistyczne;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PodsumowanieLingwistyczneIMiary {

    private final static NumberFormat formatter = new DecimalFormat("#0.00");
    private final PodsumowanieLingwistyczne podsumowanieLingwistyczne;
    private final SimpleStringProperty tekst;
    private final SimpleStringProperty T2;
    private final SimpleStringProperty T3;
    private final SimpleStringProperty T4;
    private final SimpleStringProperty T6;
    private final SimpleStringProperty T7;
    private final SimpleStringProperty T8;
    private final SimpleStringProperty T9;
    private final SimpleStringProperty T10;
    private final SimpleStringProperty T11;
    private final SimpleStringProperty T5;
    private final Double T2value;
    private final Double T3value;
    private final Double T4value;
    private final Double T5value;
    private final Double T6value;
    private final Double T7value;
    private final Double T8value;
    private final Double T9value;
    private final Double T10value;
    private final Double T11value;
    private SimpleStringProperty T1 = null;
    private Double T1value;
    private SimpleStringProperty glownaMiaraJakosci;
    private Double glownaMiaraJakosciValue;

    public PodsumowanieLingwistyczneIMiary(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getNazwa());
        stringBuilder.append(" wypadków");
        stringBuilder.append(podsumowanieLingwistyczne.getKwalifikator() == null ? "" : " będących " + podsumowanieLingwistyczne.getKwalifikator().getNazwa());
        podsumowanieLingwistyczne.getSumaryzator().forEach(wypadekEtykieta -> stringBuilder.append(", jest ").append(wypadekEtykieta.getNazwa()));
        tekst = new SimpleStringProperty(stringBuilder.toString());
        this.podsumowanieLingwistyczne = podsumowanieLingwistyczne;
        try {
            var x = MiaryJakosci.stopienPrawdziwosci(podsumowanieLingwistyczne);
            this.T1value = x;
            this.T1 = new SimpleStringProperty(formatter.format(x));
        } catch (MiaryJakosci.BrakKwalifikatora brakKwalifikatora) {
            brakKwalifikatora.printStackTrace();
            // TODO: 29.05.2021
        }
        this.T2value = MiaryJakosci.stopienNieperecyzyjnosci(podsumowanieLingwistyczne);
        this.T2 = new SimpleStringProperty(formatter.format(this.T2value));
        this.T3value = MiaryJakosci.stopienPokrycia(podsumowanieLingwistyczne);
        this.T3 = new SimpleStringProperty(formatter.format(this.T3value));
        this.T4value = MiaryJakosci.stopienTrafnosci(podsumowanieLingwistyczne);
        this.T4 = new SimpleStringProperty(formatter.format(this.T4value));
        this.T5value = MiaryJakosci.dlugoscPodsumowania(podsumowanieLingwistyczne);
        this.T5 = new SimpleStringProperty(formatter.format(this.T5value));
        this.T6value = MiaryJakosci.dlugoscPodsumowania(podsumowanieLingwistyczne);
        this.T6 = new SimpleStringProperty(formatter.format(this.T6value));
        this.T7value = MiaryJakosci.stopienKardynalnosciWzglednejKwantyfiaktora(podsumowanieLingwistyczne);
        this.T7 = new SimpleStringProperty(formatter.format(this.T7value));
        this.T8value = MiaryJakosci.stopienKardynalnosciWzglednejSumaryzatora(podsumowanieLingwistyczne);
        this.T8 = new SimpleStringProperty(formatter.format(this.T8value));
        if (this.podsumowanieLingwistyczne.getKwalifikator() != null) {
            this.T9value = MiaryJakosci.stopienNieprecyzyjnosciKwalifikatora(podsumowanieLingwistyczne);
            this.T10value = MiaryJakosci.stopienKardynalnosciWzglednejKwalifikatora(podsumowanieLingwistyczne);
            this.T11value = MiaryJakosci.dlugoscKwalifikatora(podsumowanieLingwistyczne);
            this.T9 = new SimpleStringProperty(formatter.format(this.T9value));
            this.T10 = new SimpleStringProperty(formatter.format(this.T10value));
            this.T11 = new SimpleStringProperty(formatter.format(this.T11value));
        } else {
            this.T9value = null;
            this.T10value = null;
            this.T11value = 0.0;
            this.T9 = new SimpleStringProperty("null");
            this.T10 = new SimpleStringProperty("null");
            this.T11 = new SimpleStringProperty("0");
        }
        this.glownaMiaraJakosciValue = null;
        this.glownaMiaraJakosci = new SimpleStringProperty("null");
    }

    public static NumberFormat getFormatter() {
        return formatter;
    }

    public void calculateGlownaMiaraJakosci(MiaryJakosciWagi miaryJakosciWagi) {
        this.glownaMiaraJakosciValue = this.T1value * miaryJakosciWagi.getT1() +
                this.T2value * miaryJakosciWagi.getT2() +
                this.T3value * miaryJakosciWagi.getT3() +
                this.T4value * miaryJakosciWagi.getT4() +
                this.T5value * miaryJakosciWagi.getT5() +
                this.T6value * miaryJakosciWagi.getT6() +
                this.T7value * miaryJakosciWagi.getT7() +
                this.T8value * miaryJakosciWagi.getT8() +
                this.T9value * miaryJakosciWagi.getT9() +
                this.T10value * miaryJakosciWagi.getT10() +
                this.T11value * miaryJakosciWagi.getT11();
        this.glownaMiaraJakosci = new SimpleStringProperty(formatter.format(this.glownaMiaraJakosciValue));
    }

    public String getGlownaMiaraJakosci() {
        return glownaMiaraJakosci.get();
    }

    public SimpleStringProperty glownaMiaraJakosciProperty() {
        return glownaMiaraJakosci;
    }

    public String getTekst() {
        return tekst.get();
    }

    public SimpleStringProperty tekstProperty() {
        return tekst;
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

    public PodsumowanieLingwistyczne getPodsumowanieLingwistyczne() {
        return podsumowanieLingwistyczne;
    }

    public static class MiaryJakosciWagi {
        private double T1;
        private double T2;
        private double T3;
        private double T4;
        private double T5;
        private double T6;
        private double T7;
        private double T8;
        private double T9;
        private double T10;
        private double T11;

        public MiaryJakosciWagi() {
        }

        public MiaryJakosciWagi(double t1, double t2, double t3, double t4, double t5, double t6, double t7, double t8, double t9, double t10, double t11) {
            T1 = t1;
            T2 = t2;
            T3 = t3;
            T4 = t4;
            T5 = t5;
            T6 = t6;
            T7 = t7;
            T8 = t8;
            T9 = t9;
            T10 = t10;
            T11 = t11;
        }

        public double getT1() {
            return T1;
        }

        public void setT1(double t1) {
            T1 = t1;
        }

        public double getT2() {
            return T2;
        }

        public void setT2(double t2) {
            T2 = t2;
        }

        public double getT3() {
            return T3;
        }

        public void setT3(double t3) {
            T3 = t3;
        }

        public double getT4() {
            return T4;
        }

        public void setT4(double t4) {
            T4 = t4;
        }

        public double getT5() {
            return T5;
        }

        public void setT5(double t5) {
            T5 = t5;
        }

        public double getT6() {
            return T6;
        }

        public void setT6(double t6) {
            T6 = t6;
        }

        public double getT7() {
            return T7;
        }

        public void setT7(double t7) {
            T7 = t7;
        }

        public double getT8() {
            return T8;
        }

        public void setT8(double t8) {
            T8 = t8;
        }

        public double getT9() {
            return T9;
        }

        public void setT9(double t9) {
            T9 = t9;
        }

        public double getT10() {
            return T10;
        }

        public void setT10(double t10) {
            T10 = t10;
        }

        public double getT11() {
            return T11;
        }

        public void setT11(double t11) {
            T11 = t11;
        }
    }


}
