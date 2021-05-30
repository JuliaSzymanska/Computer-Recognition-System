package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;

import java.util.concurrent.TimeUnit;

public class CzasTrwania implements PobierzWartosc<Wypadek> {

    @Override
    public Double pobierzWartosc(Wypadek wypadek) {
        long czasZakonczenia = wypadek.getCzasZakonczenia().getTime();
        long czasRozpoczecia = wypadek.getCzasRozpoczecia().getTime();
        long czasTrwania = czasZakonczenia - czasRozpoczecia;
        long minuty = TimeUnit.MILLISECONDS.toMinutes(czasTrwania);
        long godziny = TimeUnit.MILLISECONDS.toHours(czasTrwania);
        minuty %= 60;
        return godziny + (double) minuty / 60;
    }

}
