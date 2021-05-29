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

    //* T1
    public Double stopienPrawdziwosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) throws BrakKwalifikatora {
        if (podsumowanieLingwistyczne.getKwantyfikator().getJestAbsolutny()) {
            if (podsumowanieLingwistyczne.getKwalifikator() == null) {
                throw new BrakKwalifikatora();
            }
            var x = Sumaryzator.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
            return podsumowanieLingwistyczne.getKwantyfikator()
                    .getEtykieta()
                    .getAbstractZbiorRozmyty()
                    .przynaleznosc(x.liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty()));
        }
        if (podsumowanieLingwistyczne.getKwalifikator() == null) {
            var x = Sumaryzator.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
            return podsumowanieLingwistyczne.getKwantyfikator()
                    .getEtykieta()
                    .getAbstractZbiorRozmyty()
                    .przynaleznosc(
                            x.liczbaKardynalna(podsumowanieLingwistyczne.getPodmioty())
                                    / podsumowanieLingwistyczne.getPodmioty().size());
        }
        var x = Sumaryzator.iloczyn(podsumowanieLingwistyczne.getSumaryzator());
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

    //* T2
    public Double stopienNieperecyzyjnosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        double stopienPierwiastka = 1.0 / podsumowanieLingwistyczne.getSumaryzator().size();
        double iloczyn = 1;
        for (var x : podsumowanieLingwistyczne.getSumaryzator()) {
            iloczyn *= x.getAbstractZbiorRozmyty().stopienRozmycia(podsumowanieLingwistyczne.getPodmioty());
        }
        return 1.0 - Math.pow(iloczyn, stopienPierwiastka);
    }

    //* T3
    public Double stopienPokrycia(PodsumowanieLingwistyczne podsumowanieLingwistyczne) throws BrakKwalifikatora {
        if(podsumowanieLingwistyczne.getKwalifikator() == null){
            throw new BrakKwalifikatora();
        }

    }

}
