package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;

public class ZbiorKlasyczny<T> extends FunkcjaTrapezoidalna<T> {
    public ZbiorKlasyczny(Double poczatek, Double koniec, PobierzWartosc<T> pobierzWartosc) {
        super(poczatek, poczatek, koniec, koniec, poczatek, koniec, pobierzWartosc);
    }
}
