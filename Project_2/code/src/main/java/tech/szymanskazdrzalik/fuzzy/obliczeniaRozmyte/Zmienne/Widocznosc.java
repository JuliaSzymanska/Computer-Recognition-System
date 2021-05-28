package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

public class Widocznosc implements PobierzWartosc<Wypadek> {
    @Override
    public Double pobierzWartosc(Wypadek wypadek) {
        return wypadek.getWidocznosc();
    }
}
