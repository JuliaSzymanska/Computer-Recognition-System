package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class MiaryJakosci {

    /**
     * T1
     * To jest po prostu wartość funkcji przynależności obiektów dla kwalifikatora and z funckją przynależności zrobioną z andów funkcji przynależności tego sumaryzatora podzielonej przez funkcję przynależności obiektów dla kwalifikatora
     * A jak nie ma kwalifikatora to dzielimy przez liczbę obiektów
     * i na górze nie mnożymy
     * A jak jest kwantyfikator absolutny to nie dzielimy przez nic i robimy po prostu kwantyfikator od kardynalności dla andów funkcji przynależności sumaryzatora
     */
    public static Double stopienPrawdziwosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) throws BrakKwalifikatora {
        if (podsumowanieLingwistyczne.getKwantyfikator().getJestAbsolutny()) {
            if (podsumowanieLingwistyczne.getKwalifikator() == null) {
                throw new BrakKwalifikatora();
            }
            var x = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
            return podsumowanieLingwistyczne.getKwantyfikator()
                    .getEtykieta()
                    .getAbstractZbiorRozmyty()
                    .przynaleznosc(x.liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty()));
        }
        if (podsumowanieLingwistyczne.getKwalifikator() == null) {
            var x = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
            return podsumowanieLingwistyczne.getKwantyfikator()
                    .getEtykieta()
                    .getAbstractZbiorRozmyty()
                    .przynaleznosc(
                            x.liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty())
                                    / podsumowanieLingwistyczne.getPodmioty().size());
        }
        var x = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
        x = x.iloczynZbiorow(podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty());
        return podsumowanieLingwistyczne.getKwantyfikator()
                .getEtykieta()
                .getAbstractZbiorRozmyty()
                .przynaleznosc(x.liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty())
                        / podsumowanieLingwistyczne.
                        getKwalifikator().
                        getAbstractZbiorRozmyty().
                        liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty()));
    }

    /**
     * T2
     * Liczymy srednia kwadratowa ze stopni rozmycia
     */
    public static Double stopienNieperecyzyjnosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        double stopienPierwiastka = 1.0 / podsumowanieLingwistyczne.getSumaryzator().size();
        double iloczyn = 1;
        for (var x : podsumowanieLingwistyczne.getSumaryzator()) {
            iloczyn *= x.getAbstractZbiorRozmyty().stopienRozmycia(podsumowanieLingwistyczne.getPodmioty());
        }
        return 1.0 - Math.pow(iloczyn, stopienPierwiastka);
    }

    /**
     * T3
     */
    // TODO: 29.05.2021
    public static Double stopienPokrycia(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        var x = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
        if (podsumowanieLingwistyczne.getKwalifikator() == null) {
            return ((double) x.getNosnik(podsumowanieLingwistyczne.getPodmioty()).size()) / podsumowanieLingwistyczne.getPodmioty().size();
        }
        x = x.iloczynZbiorow(podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty());
        return ((double) x.getNosnik(podsumowanieLingwistyczne.getPodmioty()).size()) /
                podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty().getNosnik(podsumowanieLingwistyczne.getPodmioty()).size();
    }

    /**
     * T4
     */
    // TODO: 29.05.2021
    public static Double stopienTrafnosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        var x = stopienPokrycia(podsumowanieLingwistyczne);
        var iloczyn = 1;
        for (var y : podsumowanieLingwistyczne.getSumaryzator()) {
            iloczyn *= (double) y.getAbstractZbiorRozmyty().getNosnik(podsumowanieLingwistyczne.getPodmioty()).size();
            iloczyn /= podsumowanieLingwistyczne.getPodmioty().size();
        }
        return Math.abs(iloczyn - x);
    }


    /**
     * T5
     */

    public static Double dlugoscPodsumowania(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        return 2 * Math.pow(0.5, podsumowanieLingwistyczne.getPodmioty().size());
    }

    /**
     * T6
     */
    // TODO: 29.05.2021
    public static Double stopienNieprecyzyjnosciKwantyfikatora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        var z = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
        int count = 0;
        for (var x : podsumowanieLingwistyczne.getPodmioty()) {
            if (podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getAbstractZbiorRozmyty().przynaleznosc(z.przynaleznosc(x)) > 0) {
                count++;
            }
        }
        return (double) count / podsumowanieLingwistyczne.getPodmioty().size();
    }

    /**
     * T7
     */
    // TODO: 29.05.2021
    public static Double stopienKardynalnosciWzglednejKwantyfiaktora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        var z = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
        double suma = 0;
        for (var x : podsumowanieLingwistyczne.getPodmioty()) {
            suma += podsumowanieLingwistyczne.getKwantyfikator().getEtykieta().getAbstractZbiorRozmyty().przynaleznosc(z.przynaleznosc(x));
        }
        suma /= podsumowanieLingwistyczne.getPodmioty().size();
//        if (podsumowanieLingwistyczne.getKwantyfikator().getJestAbsolutny()) {
//            return 1 - (suma) / podsumowanieLingwistyczne.getPodmioty().size())
//        }
        return 1 - suma;
    }

    /**
     * T8
     */
    public static Double stopienKardynalnosciWzglednejSumaryzatora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        double stopienPierwiastka = 1.0 / podsumowanieLingwistyczne.getSumaryzator().size();
        double iloczyn = 1;
        for (var x : podsumowanieLingwistyczne.getSumaryzator()) {
            iloczyn *= x.getAbstractZbiorRozmyty().liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty());
            iloczyn /= podsumowanieLingwistyczne.getPodmioty().size();
        }
        return 1.0 - Math.pow(iloczyn, stopienPierwiastka);
    }

    /**
     * T9
     */
    public static Double stopienNieprecyzyjnosciKwalifikatora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        return 1.0 - podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty().stopienRozmycia(podsumowanieLingwistyczne.getPodmioty());
    }

    /**
     * T10
     */
    public static Double stopienKardynalnosciWzglednejKwalifikatora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        double iloczyn = podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty().liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty());
        iloczyn /= podsumowanieLingwistyczne.getPodmioty().size();
        return 1.0 - iloczyn;
    }

    /**
     * T11
     */
    public static Double dlugoscKwalifikatora(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        return 1.0;
    }

    public static class BrakKwalifikatora extends Exception {
        public BrakKwalifikatora() {
        }

        public BrakKwalifikatora(String message) {
            super(message);
        }

        public BrakKwalifikatora(String message, Throwable cause) {
            super(message, cause);
        }

        public BrakKwalifikatora(Throwable cause) {
            super(cause);
        }

        public BrakKwalifikatora(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

}
