package tech.szymanskazdrzalik.ksr.ksr1.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Pair implements Comparable<Pair> {

    public Article article;
    public Double distance;

    public Pair(Article article, double distance) {
        this.article = article;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Double.compare(pair.distance, distance) == 0 && article.equals(pair.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, distance);
    }

    @Override
    public int compareTo(@NotNull Pair o) {
        if (this.distance == null || o.distance == null) {
            return 0;
        }
        return this.distance.compareTo(o.distance);
    }
}
