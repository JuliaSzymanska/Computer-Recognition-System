package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.List;

public class PodsumowanieLingwistyczne {

    private final Kwantyfikator kwantyfikator;
    private final List<Wypadek> podmioty;
    private final List<Etykieta<Wypadek>> sumaryzator;
    private final Etykieta<Wypadek> kwalifikator;

    public PodsumowanieLingwistyczne(Kwantyfikator kwantyfikator, List<Wypadek> podmioty, List<Etykieta<Wypadek>> sumaryzator, Etykieta<Wypadek> kwalifikator) {
        this.kwantyfikator = kwantyfikator;
        this.podmioty = podmioty;
        this.sumaryzator = sumaryzator;
        this.kwalifikator = kwalifikator;
    }


}
