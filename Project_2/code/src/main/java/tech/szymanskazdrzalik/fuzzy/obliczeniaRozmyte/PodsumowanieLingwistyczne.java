package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.ArrayList;
import java.util.List;

public class PodsumowanieLingwistyczne {

    private final Kwantyfikator kwantyfikator;
    private final List<Wypadek> podmioty;
    private final List<Etykieta<Wypadek>> sumaryzator;
    private final List<Etykieta<Wypadek>> kwalifikator;
    private final AbstrakcyjnyZbiorRozmyty<Wypadek> kwalifikatorZbiorRozmyty;
    public PodsumowanieLingwistyczne(Kwantyfikator kwantyfikator, List<Wypadek> podmioty, List<Etykieta<Wypadek>> sumaryzator, Etykieta<Wypadek> kwalifikator) {
        this.kwantyfikator = kwantyfikator;
        this.podmioty = podmioty;
        this.sumaryzator = sumaryzator;
        this.kwalifikator = new ArrayList<>() {{
            add(kwalifikator);
        }};
        this.kwalifikatorZbiorRozmyty = kwalifikator.getAbstractZbiorRozmyty();
    }

    public PodsumowanieLingwistyczne(Kwantyfikator kwantyfikator, List<Wypadek> podmioty, List<Etykieta<Wypadek>> sumaryzator, List<Etykieta<Wypadek>> kwalifikator) {
        this.kwantyfikator = kwantyfikator;
        this.podmioty = podmioty;
        this.sumaryzator = sumaryzator;
        this.kwalifikator = kwalifikator;
        this.kwalifikatorZbiorRozmyty = Utils.iloczyn(this.kwalifikator);
    }

    public AbstrakcyjnyZbiorRozmyty<Wypadek> getKwalifikatorZbiorRozmyty() {
        return kwalifikatorZbiorRozmyty;
    }

    public Kwantyfikator getKwantyfikator() {
        return kwantyfikator;
    }

    public List<Wypadek> getPodmioty() {
        return podmioty;
    }

    public List<Etykieta<Wypadek>> getSumaryzator() {
        return sumaryzator;
    }

    public List<Etykieta<Wypadek>> getKwalifikator() {
        return kwalifikator;
    }
}
