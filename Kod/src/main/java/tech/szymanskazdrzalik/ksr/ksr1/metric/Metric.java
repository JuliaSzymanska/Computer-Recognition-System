package tech.szymanskazdrzalik.ksr.ksr1.metric;

import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

public interface Metric {

    public float calculateDistance(Article article, Article trainingArticle);
}
