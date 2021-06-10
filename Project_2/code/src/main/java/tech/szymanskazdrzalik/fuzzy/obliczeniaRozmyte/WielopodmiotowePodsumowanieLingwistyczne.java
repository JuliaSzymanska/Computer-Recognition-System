package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.ArrayList;
import java.util.List;


public class WielopodmiotowePodsumowanieLingwistyczne {
    private Kwantyfikator kwantyfikator;
    private final List<Wypadek> podmioty1;
    private final List<Wypadek> podmioty2;
    private final List<Etykieta<Wypadek>> sumaryzator;
    private List<Etykieta<Wypadek>> kwalifikator;
    private AbstrakcyjnyZbiorRozmyty<Wypadek> kwalifikatorZbiorRozmyty;
    private final RodzajPodsumowania rodzajPodsumowania;
    public WielopodmiotowePodsumowanieLingwistyczne(Kwantyfikator kwantyfikator,
                                                    List<Wypadek> podmioty1,
                                                    List<Wypadek> podmioty2,
                                                    List<Etykieta<Wypadek>> sumaryzator,
                                                    List<Etykieta<Wypadek>> kwalifikator,
                                                    RodzajPodsumowania rodzajPodsumowania) {
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


    public enum RodzajPodsumowania {
        PIERWSZA_FORMA,
        DRUGA_FORMA,
        TRZECIA_FORMA,
        CZWARTA_FORMA
    }
}
