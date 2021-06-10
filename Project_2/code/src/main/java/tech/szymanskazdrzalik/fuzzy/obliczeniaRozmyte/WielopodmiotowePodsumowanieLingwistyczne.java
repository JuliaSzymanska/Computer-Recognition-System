package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.ArrayList;
import java.util.List;


public class WielopodmiotowePodsumowanieLingwistyczne {
    private final List<Wypadek> podmioty1;
    private final List<Wypadek> podmioty2;
    private final List<Etykieta<Wypadek>> sumaryzator;
    private final RodzajPodsumowania rodzajPodsumowania;
    private Kwantyfikator kwantyfikator;
    private List<Etykieta<Wypadek>> kwalifikator;
    private AbstrakcyjnyZbiorRozmyty<Wypadek> kwalifikatorZbiorRozmyty;

    public WielopodmiotowePodsumowanieLingwistyczne(Kwantyfikator kwantyfikator,
                                                    List<Wypadek> podmioty1,
                                                    List<Wypadek> podmioty2,
                                                    List<Etykieta<Wypadek>> sumaryzator,
                                                    List<Etykieta<Wypadek>> kwalifikator,
                                                    RodzajPodsumowania rodzajPodsumowania) {
        if (kwantyfikator.getJestAbsolutny()) {
            // TODO: 10.06.2021 CHYBA!
            throw new RuntimeException(" ZLEEE ");
        }
        this.podmioty1 = podmioty1;
        this.podmioty2 = podmioty2;
        this.sumaryzator = sumaryzator;
        this.rodzajPodsumowania = rodzajPodsumowania;
        if (rodzajPodsumowania.equals(RodzajPodsumowania.PIERWSZA_FORMA)) {
            this.kwantyfikator = kwantyfikator;
            this.kwalifikator = null;
            this.kwalifikatorZbiorRozmyty = null;
        } else if (rodzajPodsumowania.equals(RodzajPodsumowania.DRUGA_FORMA) || rodzajPodsumowania.equals(RodzajPodsumowania.TRZECIA_FORMA)) {
            this.kwantyfikator = kwantyfikator;
            this.kwalifikator = kwalifikator;
            this.kwalifikatorZbiorRozmyty = Utils.iloczyn(this.kwalifikator);
        } else if (rodzajPodsumowania.equals(RodzajPodsumowania.CZWARTA_FORMA)) {
            this.kwantyfikator = null;
            this.kwalifikator = null;
            this.kwalifikatorZbiorRozmyty = null;
        }


    }

    public Kwantyfikator getKwantyfikator() {
        return kwantyfikator;
    }

    public void setKwantyfikator(Kwantyfikator kwantyfikator) {
        this.kwantyfikator = kwantyfikator;
    }

    public List<Wypadek> getPodmioty1() {
        return podmioty1;
    }

    public List<Wypadek> getPodmioty2() {
        return podmioty2;
    }

    public List<Etykieta<Wypadek>> getSumaryzator() {
        return sumaryzator;
    }

    public List<Etykieta<Wypadek>> getKwalifikator() {
        return kwalifikator;
    }

    public void setKwalifikator(List<Etykieta<Wypadek>> kwalifikator) {
        this.kwalifikator = kwalifikator;
    }

    public AbstrakcyjnyZbiorRozmyty<Wypadek> getKwalifikatorZbiorRozmyty() {
        return kwalifikatorZbiorRozmyty;
    }

    public void setKwalifikatorZbiorRozmyty(AbstrakcyjnyZbiorRozmyty<Wypadek> kwalifikatorZbiorRozmyty) {
        this.kwalifikatorZbiorRozmyty = kwalifikatorZbiorRozmyty;
    }

    public RodzajPodsumowania getRodzajPodsumowania() {
        return rodzajPodsumowania;
    }


    public enum RodzajPodsumowania {
        PIERWSZA_FORMA,
        DRUGA_FORMA,
        TRZECIA_FORMA,
        CZWARTA_FORMA
    }
}
