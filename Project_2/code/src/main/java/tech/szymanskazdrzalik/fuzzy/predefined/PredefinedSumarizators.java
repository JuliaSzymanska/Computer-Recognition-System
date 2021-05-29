package tech.szymanskazdrzalik.fuzzy.predefined;

import tech.szymanskazdrzalik.fuzzy.model.Wypadek;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrapezoidalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Cisnienie;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.IloscOpadow;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PredkoscWiatru;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Temperatura;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Widocznosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Wilgotnosc;

import java.util.ArrayList;
import java.util.List;

public class PredefinedSumarizators {
    private static final List<Etykieta<Wypadek>> sumaryzatorList = new ArrayList<>();
    private static final PredefinedSumarizators INSTANCE = new PredefinedSumarizators();

    private PredefinedSumarizators() {
        init();
    }

    private static void init() {
        sumaryzatorList.add(new Etykieta<>("jest przy słabym wietrze", new FunkcjaTrapezoidalna<>(0.0, 0.0, 3.0, 3.5, 0.0, 40.0, new PredkoscWiatru())));
        sumaryzatorList.add(new Etykieta<>("jest przy wichrze", new FunkcjaTrapezoidalna<>(17.0, 20.0, 27.0, 30.0, 0.0, 40.0, new PredkoscWiatru())));
        sumaryzatorList.add(new Etykieta<>("jest przy niewielkich opadach", new FunkcjaTrapezoidalna<>(0.0, 0.0, 0.1, 0.2, 0.0, 0.5, new IloscOpadow())));
        sumaryzatorList.add(new Etykieta<>("jest przy pełnej widoczności", new FunkcjaTrapezoidalna<>(2.0, 3.0, 5.0, 10.0, 0.0, 10.0, new Widocznosc())));
        sumaryzatorList.add(new Etykieta<>("jest przy umiarkowanym ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 28.75, 27.0, 32.0, new Cisnienie())));
        sumaryzatorList.add(new Etykieta<>("jest przy bardzo suchym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 4.0, 27.0, 32.0, new Wilgotnosc())));
        sumaryzatorList.add(new Etykieta<>("jest przy ciepłej temperaturze", new FunkcjaTrapezoidalna<>(63.0, 71.0, 80.0, 90.0, -16.0, 104.0, new Temperatura())));
        sumaryzatorList.add(new Etykieta<>("jest przy zimnej temperaturze", new FunkcjaTrapezoidalna<>(14.0, 23.0, 44.0, 54.0, -16.0, 104.0, new Temperatura())));
        sumaryzatorList.add(new Etykieta<>("jest przy umiarkowanej temperaturze", new FunkcjaTrapezoidalna<>(44.0, 54.0, 63.0, 71.0, -16.0, 104.0, new Temperatura())));

    }

    public static List<Etykieta<Wypadek>> getSumaryzatorList() {
        return sumaryzatorList;
    }
}
