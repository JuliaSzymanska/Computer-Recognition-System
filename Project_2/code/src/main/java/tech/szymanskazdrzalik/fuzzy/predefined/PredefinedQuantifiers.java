package tech.szymanskazdrzalik.fuzzy.predefined;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrojkatna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;

import java.util.ArrayList;
import java.util.List;

public class PredefinedQuantifiers {
    private final static double koniecUniversum = 300;
    private static final List<Kwantyfikator> kwantyfikatorList = new ArrayList<>();

    private PredefinedQuantifiers() {
        init();
    }

    private static PredefinedQuantifiers INSTANCE = new PredefinedQuantifiers();

    private static void init() {
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Niewiele", new FunkcjaGausowska<>(0.1, 1.0, 0.0, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Około 1/4", new FunkcjaGausowska<>(0.1, 1.0, 0.25, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Około połowy", new FunkcjaGausowska<>(0.1, 1.0, 0.5, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Większość", new FunkcjaGausowska<>(0.1, 1.0, 0.75, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(
                new Etykieta<>("Prawie Wszystkie", new FunkcjaGausowska<>(0.1, 1.0, 1.0, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));

    }

    public static List<Kwantyfikator> getKwantyfikatorList() {
        return kwantyfikatorList;
    }
}
