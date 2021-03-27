package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;
import tech.szymanskazdrzalik.ksr.ksr1.knn.Classifier;
import tech.szymanskazdrzalik.ksr.ksr1.metric.EuclideanMetric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(FolderReader.readArticlesFromFolderInResources("Data/")));
        Article[] articles = FolderReader.readArticlesFromFolderInResources("Data/");
        List<Article> trainingSet = new ArrayList<>();
        List<Article> testSet = new ArrayList<>();
        for(Article a : articles){
            if(a.isTestSet()){
                testSet.add(a);
            } else{
                trainingSet.add(a);
            }
        }
        Classifier classifier = new Classifier(testSet.get(0), trainingSet, new EuclideanMetric(), 5);
        System.out.println(classifier.simulate());

    }


}
