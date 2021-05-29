package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class MiaryJakosci {

    public static class BrakKwalifikatora extends Exception{
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

    /**
     * T1
     * To jest po prostu wartość funkcji przynależności obiektów dla kwalifikatora and z funckją przynależności zrobioną z andów funkcji przynależności tego sumaryzatora podzielonej przez funkcję przynależności obiektów dla kwalifikatora
     * A jak nie ma kwalifikatora to dzielimy przez liczbę obiektów
     * i na górze nie mnożymy
     * A jak jest kwantyfikator absolutny to nie dzielimy przez nic i robimy po prostu kwantyfikator od kardynalności dla andów funkcji przynależności sumaryzatora
     */
    public Double stopienPrawdziwosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) throws BrakKwalifikatora {
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
    public Double stopienNieperecyzyjnosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
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
    public Double stopienPokrycia(PodsumowanieLingwistyczne podsumowanieLingwistyczne) throws BrakKwalifikatora {
        if(podsumowanieLingwistyczne.getKwalifikator() == null){
            throw new BrakKwalifikatora();
        }
        var x = Utils.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
        x = x.iloczynZbiorow(podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty());
        return ((double)x.getNosnik(podsumowanieLingwistyczne.getPodmioty()).size()) /
                podsumowanieLingwistyczne.getKwalifikator().getAbstractZbiorRozmyty().getNosnik(podsumowanieLingwistyczne.getPodmioty()).size();
    }

}
