package tech.szymanskazdrzalik.ksr.ksr1.model;

import java.util.Objects;

public class Pair {

    public Article article;
    public float distance;

    public Pair(Article article, float distance) {
        this.article = article;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Float.compare(pair.distance, distance) == 0 && article.equals(pair.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, distance);
    }
}
