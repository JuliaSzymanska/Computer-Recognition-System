package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;
import tech.szymanskazdrzalik.ksr.ksr1.knn.Classifier;
import tech.szymanskazdrzalik.ksr.ksr1.metric.ChebyshevMetric;
import tech.szymanskazdrzalik.ksr.ksr1.metric.EuclideanMetric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(FolderReader.readArticlesFromFolderInResources("Data/")));
        Article[] articles = FolderReader.readArticlesFromFolderInResources("Data/");
        List<Article> trainingSet = new ArrayList<>();
        List<Article> testSet = new ArrayList<>();
        int[][] acc = new int[2][];
        acc[0] = new int[2];
        acc[1] = new int[2];
        for (Article a : articles) {
            if (a.isTestSet()) {
                testSet.add(a);
            } else {
                trainingSet.add(a);
            }
        }
        for(Article a : testSet){
            Classifier classifier = new Classifier(a, trainingSet, new ChebyshevMetric(), 2);
            System.out.println(Arrays.toString(a.getPlaces()) + "       " + classifier.simulate());

        }


    }


}
