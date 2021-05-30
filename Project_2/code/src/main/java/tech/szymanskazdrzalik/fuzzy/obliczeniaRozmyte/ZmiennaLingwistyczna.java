package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.List;

public class ZmiennaLingwistyczna {

    public ZmiennaLingwistyczna(List<Etykieta<Wypadek>> etykiety) {
        this.etykiety = etykiety;
    }

    public void add(Etykieta<Wypadek> etykieta) {
        etykiety.add(etykieta);
    }

    private List<Etykieta<Wypadek>> etykiety;

    public List<Etykieta<Wypadek>> getEtykiety() {
        return etykiety;
    }
}
