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
import java.util.Arrays;
import java.util.Collections;
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
        System.out.println("Podaj procent artykułów treningowych: ");
        int trainings = 0;
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                trainings = in.nextInt();
                if (trainings > 0 && trainings < 100) {
                    break;
                }
            } else {
                System.out.println("Podaj procent artykułów treningowych: ");
                in.next();
            }
        }

        System.out.println("Czy chcesz wybrać zestaw cech do klasyfikacji: \n1. Tak\n2. Nie");
        int isSet = 0;
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                isSet = in.nextInt();
                if (isSet == 1 || isSet == 2) {
                    break;
                }
            } else {
                System.out.println("Czy chcesz wybrać zestaw cech do klasyfikacji: \n1. Tak\n2. Nie");
                in.next();
            }
        }
        boolean[] booleanSet = new boolean[]{true, true, true, true, true, true, true, true, true, true, true};
        if (isSet == 1) {
            System.out.println("Cechy do wyboru: ");
            System.out.println("1. Liczba słów");
            System.out.println("2. Autor");
            System.out.println("3. Liczba unikatowych słów");
            System.out.println("4. Data");
            System.out.println("5. Lokalizacja");
            System.out.println("6. Tytuł");
            System.out.println("7. Najczęściej występująca nazwa państwa");
            System.out.println("8. Kluczowe słowa");
            System.out.println("9. Liczba kluczowych słów");
            System.out.println("10. Nasycenie tekstu słowani kluczowymi");
            System.out.println("11. Najczęściej występujące słowo kluczowe");
            String set = "";
            while (in.hasNext()) {
                set = in.nextLine();
                if (set.trim().length() > 0) {
                    break;
                }
            }

            Arrays.fill(booleanSet, false);
            int[] stringSet = Arrays.stream(set.trim().replaceAll(" +", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
            try {
                for (int i : stringSet) {
                    booleanSet[i - 1] = true;
                }
            } catch (Exception e) {
                System.out.println("Z powodu bledu, wybrane zostaly wszystkie cechy. ");
                Arrays.fill(booleanSet, true);
            }
        }

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
        Collections.shuffle(trainingSet);
        trainingSet = trainingSet.subList(0, testSet.size() * trainings / (100 - trainings));
        for (Article a : articles) {
            if (a.isTestSet()) {
                testSet.add(a);
            } else {
                trainingSet.add(a);
            }
        }
        double properlyClassified = 0;
        System.out.println("\nRozpoczęto klasyfikację.\n");
        Classifier classifier = new Classifier(trainingSet, metricForClass, k, booleanSet);
        for (Article a : testSet) {
            String place = classifier.simulate(a);
            String place2 = a.getPlaces()[0];
//            System.out.println(place2 + "       " + place);
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
