package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Pair<M, N extends Comparable<N>> implements Comparable<Pair<M, N>> {

    public M m;
    public N n;

    public Pair(M m, N n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return m.equals(pair.m) && n.equals(pair.n);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, n);
    }


    @Override
    public int compareTo(@NotNull Pair<M, N> o) {
        if (this.n == null || o.n == null) {
            return 0;
        }
        return this.n.compareTo(o.n);
    }
}
