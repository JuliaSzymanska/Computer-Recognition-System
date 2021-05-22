package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

public class FunkcjaTrapezoidalna implements FunkcjaPrzynaleznosci{
    private double start, maxStart, maxEnd, end;

    public FunkcjaTrapezoidalna(double start, double maxStart, double maxEnd, double end) {
        if (start > maxStart || maxStart > maxEnd || maxEnd > end) {
            throw new RuntimeException();
        }
        this.start = start;
        this.maxStart = maxStart;
        this.maxEnd = maxEnd;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public double getMaxStart() {
        return maxStart;
    }

    public double getMaxEnd() {
        return maxEnd;
    }

    public double getEnd() {
        return end;
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
