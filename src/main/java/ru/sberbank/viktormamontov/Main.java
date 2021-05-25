package ru.sberbank.viktormamontov;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get("/Users/u19223645/Downloads/Cities.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> inputLines = new ArrayList<>();
        while (scanner.hasNext()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();

        CityHandlerImpl cityHandler = new CityHandlerImpl();
        List<City> cities = cityHandler.parseLines(inputLines);
        System.out.println("========================");


        cities.forEach(System.out::println);
        System.out.println("========================");

        cityHandler.sortByName(cities);
        cities.forEach(System.out::println);
        System.out.println("========================");

        cityHandler.sortByDistrictAndName(cities);
        cities.forEach(System.out::println);
        System.out.println("========================");

        Map<Integer, Integer> cityWithLargestPopulation = cityHandler.findCityIndexWithLargestPopulation(cities);
        cityWithLargestPopulation.forEach((key, value) -> System.out.printf("[%d] = %d\n", key, value));
        System.out.println("========================");

//        City cityWithLargestPopulation1 = cityHandler.findCityWithLargestPopulation(cities);
//        System.out.println(cityWithLargestPopulation1);
//        System.out.println("========================");

        Map<String, Long> countCitiesByRegion = cityHandler.countCitiesByRegion(cities);
        countCitiesByRegion.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("========================");

    }
}
