package tech.szymanskazdrzalik.ksr.ksr1;

import tech.szymanskazdrzalik.ksr.ksr1.dao.FolderReader;
import tech.szymanskazdrzalik.ksr.ksr1.knn.Classifier;
import tech.szymanskazdrzalik.ksr.ksr1.metric.ChebyshevMetric;
import tech.szymanskazdrzalik.ksr.ksr1.metric.EuclideanMetric;
import tech.szymanskazdrzalik.ksr.ksr1.metric.ManhattanMetric;
import tech.szymanskazdrzalik.ksr.ksr1.metric.Metric;
import tech.szymanskazdrzalik.ksr.ksr1.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int k = 0;
        System.out.println("Podaj wartość k:");
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                k = in.nextInt();
                break;
            } else {
                System.out.println("Podaj wartość k:");
                in.next();
            }
        }
        int metric = 0;
        System.out.println("Wybierz metrykę: \n1. Euklidesowa\n2. Czebyszewa\n3. Uliczna");
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                metric = in.nextInt();
                if (metric == 1 || metric == 2 || metric == 3) {
                    break;
                }
            } else {
                System.out.println("Wybierz metrykę: \n1. Euklidesowa\n2. Czebyszewa\n3. Uliczna");
                in.next();
            }
        }
//        System.out.println("Podaj ilość testowych artykułów. ");

//        float b = in.nextFloat();
//        System.out.println("You entered float " + b);
        Metric metricForClass;
        if (metric == 1) {
            metricForClass = new EuclideanMetric();
        } else if (metric == 2) {
            metricForClass = new ChebyshevMetric();
        } else {
            metricForClass = new ManhattanMetric();
        }
        System.out.println("\nRozpoczęto wczytywanie danych.\n");
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
        System.out.println("\nRozpoczęto klasyfikację.\n");
        Classifier classifier = new Classifier(trainingSet, metricForClass, k);
        for (Article a : testSet) {
            String place = classifier.simulate(a);
            String place2 = a.getPlaces()[0];
            System.out.println(place2 + "       " + place);
            if (place2.equals(place)) {
                properlyClassified += 1;
            }
        }
        System.out.println("Sum: " + testSet.size());
        System.out.println("Properly classified: " + properlyClassified);
        double acc = properlyClassified / testSet.size();
        System.out.println("Accuracy: " + acc);
    }

}
