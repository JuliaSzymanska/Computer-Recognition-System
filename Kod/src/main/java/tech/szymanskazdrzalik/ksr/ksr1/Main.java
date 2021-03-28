package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;
import tech.szymanskazdrzalik.ksr.ksr1.knn.Classifier;
import tech.szymanskazdrzalik.ksr.ksr1.metric.ChebyshevMetric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(FolderReader.readArticlesFromFolderInResources("Data/")));
        Article[] articles = FolderReader.readArticlesFromFolderInResources("Data/");
        List<Article> trainingSet = new ArrayList<>();
        List<Article> testSet = new ArrayList<>();
        for (Article a : articles) {
            if (a.isTestSet()) {
                testSet.add(a);
            } else {
                trainingSet.add(a);
            }
        }
        double properlyClassified = 0;
        for(Article a : testSet){
            Classifier classifier = new Classifier(a, trainingSet, new ChebyshevMetric(), 5);
            String place = classifier.simulate();
            String place2 = a.getPlaces()[0];
            System.out.println(place2 + "       " + place);
            if(place2.equals(place)){
                properlyClassified += 1;
            }
        }
        System.out.println("Sum: " + testSet.size());
        System.out.println("Properly classified: " + properlyClassified);
        double acc = properlyClassified/testSet.size();
        System.out.println("Accuracy: " + acc);
    }


}
