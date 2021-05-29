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

public class PredefinedQualifiers {
    private static final List<Etykieta<Wypadek>> kwalifikatorList = new ArrayList<>();
    private static final PredefinedQualifiers INSTANCE = new PredefinedQualifiers();

    private PredefinedQualifiers() {
        init();
    }

    private static void init() {
        kwalifikatorList.add(new Etykieta<>("będące przy słabym wietrze", new FunkcjaTrapezoidalna<>(0.0, 0.0, 3.0, 3.5, 0.0, 40.0, new PredkoscWiatru())));
        kwalifikatorList.add(new Etykieta<>("będące przy wichrze", new FunkcjaTrapezoidalna<>(17.0, 20.0, 27.0, 30.0, 0.0, 40.0, new PredkoscWiatru())));
        kwalifikatorList.add(new Etykieta<>("będące przy niewielkich opadach", new FunkcjaTrapezoidalna<>(0.0, 0.0, 0.1, 0.2, 0.0, 0.5, new IloscOpadow())));
        kwalifikatorList.add(new Etykieta<>("będące przy pełnej widoczności", new FunkcjaTrapezoidalna<>(2.0, 3.0, 5.0, 10.0, 0.0, 10.0, new Widocznosc())));
        kwalifikatorList.add(new Etykieta<>("będące przy umiarkowanym ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 28.75, 27.0, 32.0, new Cisnienie())));
        kwalifikatorList.add(new Etykieta<>("będące przy bardzo suchym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 4.0, 27.0, 32.0, new Wilgotnosc())));
        kwalifikatorList.add(new Etykieta<>("będące przy ciepłej temperaturze", new FunkcjaTrapezoidalna<>(63.0, 71.0, 80.0, 90.0, -16.0, 104.0, new Temperatura())));

    }

    public static List<Etykieta<Wypadek>> getKwalifikatorList() {
        return kwalifikatorList;
    }
}
