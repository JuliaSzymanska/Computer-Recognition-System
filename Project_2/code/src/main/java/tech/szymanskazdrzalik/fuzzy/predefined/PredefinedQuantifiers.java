package tech.szymanskazdrzalik.fuzzy.predefined;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrapezoidalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrojkatna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Kwantyfikator;

import java.util.ArrayList;
import java.util.List;

public class PredefinedQuantifiers {
    private final static double koniecUniversum = 300;
    private static final List<Kwantyfikator> kwantyfikatorList = new ArrayList<>();
    // TODO: 29.05.2021 poprawic absolutne
    private static final PredefinedQuantifiers INSTANCE = new PredefinedQuantifiers();

    private PredefinedQuantifiers() {
        init();
    }

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
                new Etykieta<>("Prawie wszystkie", new FunkcjaGausowska<>(0.1, 1.0, 1.0, 0.0, 1.0, aDouble -> aDouble)),
                false));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponizej 10", new FunkcjaTrojkatna<Double>(0.0, 0.0, 10.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Około 20", new FunkcjaTrojkatna<Double>(0.0, 20.0, 40.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Około 50", new FunkcjaTrapezoidalna<>(10.0, 40.0, 60.0, 90.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Około 100", new FunkcjaTrapezoidalna<>(50.0, 90.0, 110.0, 150.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Między 100 a 200", new FunkcjaTrojkatna<Double>(100.0, 150.0, 200.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Około 200", new FunkcjaTrapezoidalna<>(150.0, 190.0, 210.0, 250.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
        kwantyfikatorList.add(new Kwantyfikator(new Etykieta<>("Ponad 200", new FunkcjaTrapezoidalna<>(200.0, 250.0, 300.0, 300.0, 0.0, koniecUniversum, aDouble -> aDouble)), true));
    }

    public static List<Kwantyfikator> getKwantyfikatorList() {
        return kwantyfikatorList;
    }

    public static void addKwalifikator(Kwantyfikator kwantyfikator){
        kwantyfikatorList.add(kwantyfikator);
    }

}
