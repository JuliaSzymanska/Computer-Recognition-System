package tech.szymanskazdrzalik.fuzzy.predefined;

import tech.szymanskazdrzalik.fuzzy.common.Stale;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Etykieta;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaGausowska;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrapezoidalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.FunkcjaTrojkatna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.ZmiennaLingwistyczna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Cisnienie;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.CzasTrwania;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.IloscOpadow;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Odleglosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PredkoscWiatru;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Temperatura;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.TemperaturaOdczuwalna;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Widocznosc;
import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.Wilgotnosc;

import java.util.ArrayList;
import java.util.List;

import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_ODLEGLOSC;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_ODLEGLOSC;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC;
import static tech.szymanskazdrzalik.fuzzy.common.Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC;

public class PredefinedQualifiersAndSumarizators {

    private static final PredefinedQualifiersAndSumarizators INSTANCE = new PredefinedQualifiersAndSumarizators();

    private static ZmiennaLingwistyczna predkoscWiatru;


    private static ZmiennaLingwistyczna iloscOpadow;


    private static ZmiennaLingwistyczna widocznosc;


    private static ZmiennaLingwistyczna cisnienie;


    private static ZmiennaLingwistyczna wilgotnosc;

    private static ZmiennaLingwistyczna temperatura;


    private static ZmiennaLingwistyczna temperaturaOdczuwalna;


    private static ZmiennaLingwistyczna czasTrwania;


    private static ZmiennaLingwistyczna odleglosc;

    private static boolean didInit = false;

    private PredefinedQualifiersAndSumarizators() {
        init();
    }

    public static ZmiennaLingwistyczna getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public static ZmiennaLingwistyczna getIloscOpadow() {
        return iloscOpadow;
    }

    public static ZmiennaLingwistyczna getWidocznosc() {
        return widocznosc;
    }

    public static ZmiennaLingwistyczna getCisnienie() {
        return cisnienie;
    }

    public static ZmiennaLingwistyczna getWilgotnosc() {
        return wilgotnosc;
    }

    public static ZmiennaLingwistyczna getTemperatura() {
        return temperatura;
    }

    public static ZmiennaLingwistyczna getTemperaturaOdczuwalna() {
        return temperaturaOdczuwalna;
    }

    public static ZmiennaLingwistyczna getCzasTrwania() {
        return czasTrwania;
    }

    public static ZmiennaLingwistyczna getOdleglosc() {
        return odleglosc;
    }


    private static void init() {
        predkoscWiatru = new ZmiennaLingwistyczna(new ArrayList<>());
        iloscOpadow = new ZmiennaLingwistyczna(new ArrayList<>());
        widocznosc = new ZmiennaLingwistyczna(new ArrayList<>());
        cisnienie = new ZmiennaLingwistyczna(new ArrayList<>());
        wilgotnosc = new ZmiennaLingwistyczna(new ArrayList<>());
        temperatura = new ZmiennaLingwistyczna(new ArrayList<>());
        temperaturaOdczuwalna = new ZmiennaLingwistyczna(new ArrayList<>());
        czasTrwania = new ZmiennaLingwistyczna(new ArrayList<>());
        odleglosc = new ZmiennaLingwistyczna(new ArrayList<>());
        predkoscWiatru.add(new Etykieta<>("przy słabym wietrze", new FunkcjaTrapezoidalna<>(0.0, 0.0, 3.0, 3.5, Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, new PredkoscWiatru())));
        predkoscWiatru.add(new Etykieta<>("przy umiarkowanym wietrze", new FunkcjaTrapezoidalna<>(3.0, 3.5, 8.0, 9.0, Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, new PredkoscWiatru())));
        predkoscWiatru.add(new Etykieta<>("przy silnym wietrze", new FunkcjaTrapezoidalna<>(8.0, 9.0, 17.0, 20.0, Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, new PredkoscWiatru())));
        predkoscWiatru.add(new Etykieta<>("przy wichrze", new FunkcjaTrapezoidalna<>(17.0, 20.0, 27.0, 30.0, Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, new PredkoscWiatru())));
        predkoscWiatru.add(new Etykieta<>("przy huraganie", new FunkcjaTrapezoidalna<>(27.0, 30.0, 40.0, 40.0, Stale.POCZATEK_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, KONIEC_PRZESTRZENI_ROZWAZAN_PREDKOSC_WIATRU, new PredkoscWiatru())));

        iloscOpadow.add(new Etykieta<>("przy niewielkich opadach", new FunkcjaTrapezoidalna<>(0.0, 0.0, 0.1, 0.2, POCZATEK_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, KONIEC_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, new IloscOpadow())));
        iloscOpadow.add(new Etykieta<>("przy umiarowanych opadach", new FunkcjaTrapezoidalna<>(0.1, 0.2, 0.3, 0.35, POCZATEK_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, KONIEC_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, new IloscOpadow())));
        iloscOpadow.add(new Etykieta<>("przy dużych opadach", new FunkcjaTrapezoidalna<>(0.3, 0.35, 0.4, 0.45, POCZATEK_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, KONIEC_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, new IloscOpadow())));
        iloscOpadow.add(new Etykieta<>("przy bardzo dużych opadach", new FunkcjaTrapezoidalna<>(0.4, 0.45, 0.5, 0.5, POCZATEK_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, KONIEC_PRZESTRZENI_ROZWAZAN_ILOSC_OPADOW, new IloscOpadow())));

        widocznosc.add(new Etykieta<>("przy słaba widoczność", new FunkcjaTrapezoidalna<>(0.0, 0.0, 0.1, 0.3, POCZATEK_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, new Widocznosc())));
        widocznosc.add(new Etykieta<>("przy ograniczonej widoczności", new FunkcjaTrapezoidalna<>(0.1, 0.3, 0.7, 1.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, new Widocznosc())));
        widocznosc.add(new Etykieta<>("przy dobrej widoczności", new FunkcjaTrapezoidalna<>(0.7, 1.0, 2.0, 3.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, new Widocznosc())));
        widocznosc.add(new Etykieta<>("przy pełnej widoczności", new FunkcjaTrapezoidalna<>(2.0, 3.0, 5.0, 10.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WIDOCZNOSC, new Widocznosc())));

        cisnienie.add(new Etykieta<>("przy bardzo niskim ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 27.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE, KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE, new Cisnienie())));
        cisnienie.add(new Etykieta<>("przy niskim ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 27.75, POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE, KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE, new Cisnienie())));
        cisnienie.add(new Etykieta<>("przy umiarkowanym ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 28.75, POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE, KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE, new Cisnienie())));
        cisnienie.add(new Etykieta<>("przy wysokim ciśnieniu", new FunkcjaGausowska<>(0.3, 1.0, 29.75, POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE, KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE, new Cisnienie())));
        cisnienie.add(new Etykieta<>("przy bardzo wysokim ciśnieniu", new FunkcjaTrapezoidalna<>(30.0, 30.5, 32.0, 32.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CISNIENIE, KONIEC_PRZESTRZENI_ROZWAZAN_CISNIENIE, new Cisnienie())));

        wilgotnosc.add(new Etykieta<>("przy bardzo suchym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 4.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, new Wilgotnosc())));
        wilgotnosc.add(new Etykieta<>("przy suchym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 25.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, new Wilgotnosc())));
        wilgotnosc.add(new Etykieta<>("przy umiarkowanie wilgotnym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 50.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, new Wilgotnosc())));
        wilgotnosc.add(new Etykieta<>("przy wilgotnym powietrzu", new FunkcjaGausowska<>(8.0, 1.0, 75.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, new Wilgotnosc())));
        wilgotnosc.add(new Etykieta<>("przy wilgotnym powietrzu", new FunkcjaTrapezoidalna<>(80.0, 90.0, 100.0, 100.0, POCZATEK_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, KONIEC_PRZESTRZENI_ROZWAZAN_WILGOTNOSC, new Wilgotnosc())));

        temperatura.add(new Etykieta<>("przy bardzo zimnej temperaturze", new FunkcjaTrapezoidalna<>(-16.0, -16.0, 14.0, 23.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new Temperatura())));
        temperatura.add(new Etykieta<>("przy zimnej temperaturze", new FunkcjaTrapezoidalna<>(14.0, 23.0, 44.0, 54.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new Temperatura())));
        temperatura.add(new Etykieta<>("przy umiarkowanej temperaturze", new FunkcjaTrapezoidalna<>(44.0, 54.0, 63.0, 71.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new Temperatura())));
        temperatura.add(new Etykieta<>("przy ciepłej temperaturze", new FunkcjaTrapezoidalna<>(63.0, 71.0, 80.0, 90.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new Temperatura())));
        temperatura.add(new Etykieta<>("przy bardzo ciepłej temperaturze", new FunkcjaTrapezoidalna<>(80.0, 90.0, 104.0, 104.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new Temperatura())));

        temperaturaOdczuwalna.add(new Etykieta<>("przy bardzo zimnej temperaturze odczuwalnej", new FunkcjaTrapezoidalna<>(-16.0, -16.0, 14.0, 23.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new TemperaturaOdczuwalna())));
        temperaturaOdczuwalna.add(new Etykieta<>("przy zimnej temperaturze odczuwalnej", new FunkcjaTrapezoidalna<>(14.0, 23.0, 44.0, 54.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new TemperaturaOdczuwalna())));
        temperaturaOdczuwalna.add(new Etykieta<>("przy umiarkowanej temperaturze odczuwalnej", new FunkcjaTrapezoidalna<>(44.0, 54.0, 63.0, 71.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new TemperaturaOdczuwalna())));
        temperaturaOdczuwalna.add(new Etykieta<>("przy ciepłej temperaturze odczuwalnej", new FunkcjaTrapezoidalna<>(63.0, 71.0, 80.0, 90.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new TemperaturaOdczuwalna())));
        temperaturaOdczuwalna.add(new Etykieta<>("przy bardzo ciepłej temperaturze odczuwalnej", new FunkcjaTrapezoidalna<>(80.0, 90.0, 104.0, 104.0, POCZATEK_PRZESTRZENI_ROZWAZAN_TEMPERATURA, KONIEC_PRZESTRZENI_ROZWAZAN_TEMPERATURA, new TemperaturaOdczuwalna())));


        odleglosc.add(new Etykieta<>("wywołuje utrudnienia w ruchu o długości poniżej pół mili", new FunkcjaTrojkatna<>(0.0, 0.0, 0.5, POCZATEK_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, KONIEC_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, new Odleglosc())));
        odleglosc.add(new Etykieta<>("wywołuje utrudnienia w ruchu o długości około jednej mili", new FunkcjaTrojkatna<>(0.0, 1.0, 2.0, POCZATEK_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, KONIEC_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, new Odleglosc())));
        odleglosc.add(new Etykieta<>("wywołuje utrudnienia w ruchu o długości około trzech mili", new FunkcjaTrojkatna<>(1.0, 3.0, 5.0, POCZATEK_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, KONIEC_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, new Odleglosc())));
        odleglosc.add(new Etykieta<>("wywołuje utrudnienia w ruchu o długości ponad trzech mili", new FunkcjaTrapezoidalna<>(3.0, 5.0, 6.0, 6.0, POCZATEK_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, KONIEC_PRZESTRZENI_ROZWAZAN_ODLEGLOSC, new Odleglosc())));


        czasTrwania.add(new Etykieta<>("wywołuje utrudnienia w ruchu trwające poniżej godziny", new FunkcjaTrojkatna<>(0.0, 0.0, 1.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, new CzasTrwania())));
        czasTrwania.add(new Etykieta<>("wywołuje utrudnienia w ruchu trwające około dwóch godzin", new FunkcjaTrojkatna<>(0.0, 2.0, 4.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, new CzasTrwania())));
        czasTrwania.add(new Etykieta<>("wywołuje utrudnienia w ruchu trwające około czterech godzin", new FunkcjaTrojkatna<>(2.0, 4.0, 6.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, new CzasTrwania())));
        czasTrwania.add(new Etykieta<>("wywołuje utrudnienia w ruchu trwające około sześciu godzin", new FunkcjaTrojkatna<>(4.0, 6.0, 8.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, new CzasTrwania())));
        czasTrwania.add(new Etykieta<>("wywołuje utrudnienia w ruchu trwające ponad sześć godzin", new FunkcjaTrojkatna<>(6.0, 8.0, 24.0, POCZATEK_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, KONIEC_PRZESTRZENI_ROZWAZAN_CZAS_TRWANIA, new CzasTrwania())));
        didInit = true;
    }

    public static List<ZmiennaLingwistyczna> getAll() {
        if (!didInit) {
            init();
        }
        return new ArrayList<>() {{
            add(predkoscWiatru);
            add(iloscOpadow);
            add(widocznosc);
            add(cisnienie);
            add(wilgotnosc);
            add(temperatura);
            add(temperaturaOdczuwalna);
            add(czasTrwania);
            add(odleglosc);
        }};
    }

}
