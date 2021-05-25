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

        CityHandler cityHandler = new CityHandler();
        List<City> cities = cityHandler.parseLines(inputLines);

        cities.forEach(System.out::println);
        System.out.println("========================");

        cityHandler.sortByName(cities);
        cities.forEach(System.out::println);
        System.out.println("========================");

        cityHandler.sortByDistrictAndName(cities);
        cities.forEach(System.out::println);
        System.out.println("========================");

        Map<Integer, Integer> cityWithLargestPopulation = cityHandler.findCityWithLargestPopulation(cities);
        System.out.println(cityWithLargestPopulation);
        System.out.println("========================");

    }
}
