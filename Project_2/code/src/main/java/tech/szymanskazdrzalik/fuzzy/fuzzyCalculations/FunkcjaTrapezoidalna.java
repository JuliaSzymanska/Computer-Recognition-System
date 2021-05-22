package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

public class FunkcjaTrapezoidalna implements FunkcjaPrzynaleznosci{
    private double start, maxStart, maxEnd, end;

    public FunkcjaTrapezoidalna(double start, double maxStart, double maxEnd, double end) {
        this.start = start;
        this.maxStart = maxStart;
        this.maxEnd = maxEnd;
        this.end = end;
    }

    @Override
    public double przynaleznosc(double x) {
        if (x >= maxStart && x <= maxEnd) {
            return 1;
        }
        if (x > start && x < maxStart) {
            return (x - start) / (maxStart - start);
        }
        if (x > maxEnd && x < end) {
            return  1 - ((x - maxEnd) / (end - maxEnd));
        }
        return 0;
    }
}
