package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class MiaryJakosci {

    //* T1
    public Double stopienPrawdziwosci(PodsumowanieLingwistyczne podsumowanieLingwistyczne) {
        if (podsumowanieLingwistyczne.getKwantyfikator().getJestAbsolutny()) {
            if (podsumowanieLingwistyczne.getKwalifikator() == null) {
                throw new IllegalArgumentException();
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
    public Double stopienNieperecyzyjnosci(){}


}
