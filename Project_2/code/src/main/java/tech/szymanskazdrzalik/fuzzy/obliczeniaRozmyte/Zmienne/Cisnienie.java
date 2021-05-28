package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

public class Cisnienie implements PobierzWartosc<Wypadek> {
    @Override
    public Double pobierzWartosc(Wypadek wypadek) {
        return wypadek.getCisnienie();
    }
}
