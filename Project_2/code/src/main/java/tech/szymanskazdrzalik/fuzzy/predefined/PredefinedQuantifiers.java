package tech.szymanskazdrzalik.fuzzy.predefined;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;

import java.util.List;
import java.util.ArrayList;

public class PredefinedQuantifiers {
    private static List<Kwantyfikator> kwantyfikatorList = new ArrayList<>();

    private PredefinedQuantifiers() {}

    private void init() {
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Niewiele", new FunkcjaGausowska<>(0.1, 1.0, 0.0, 0.0, 1.0, aDouble -> aDouble)),
                false));
    }

    public List<Kwantyfikator> getKwantyfikatorList() {
        return kwantyfikatorList;
    }
}
