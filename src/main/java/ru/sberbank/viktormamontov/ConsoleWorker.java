package ru.sberbank.viktormamontov;

import ru.sberbank.viktormamontov.entity.City;
import ru.sberbank.viktormamontov.service.CityService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleWorker {

    private Scanner scanner;
    private CityService cityService;

    public ConsoleWorker(CityService cityService) {
        this.cityService = cityService;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("========================");
        System.out.println("Введите путь до файла: ");
        parseFile(scanner.nextLine());
    }

    public void showMenu() {
        do {
            System.out.println("Введите номер действия:");
            System.out.println("1 - получить список городов");
            System.out.println("2 - получить список городов, отсортированный по названию по убыванию");
            System.out.println("3 - получить список городов, отсортированный по региону и по названию по убыванию");
            System.out.println("4 - получить индекс города с наибольшим населением");
            System.out.println("5 - получить список регионов с количеством их городов");
            System.out.println("6 - добавить города");
            System.out.println("0 - нажмите для выхода");

            String s = scanner.nextLine();
            int number;
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные, попробуйте снова.");
                continue;
            }

            switch (number) {
                case 1:
                    System.out.println("========================");
                    cityService.getCities().forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 2:
                    System.out.println("========================");
                    cityService.getCitiesSortedByNameDesc()
                            .forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 3:
                    System.out.println("========================");
                    cityService.getCitiesSortedByDistrictAndNameDesc()
                            .forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 4:
                    System.out.println("========================");
                    cityService.findCityIndexWithLargestPopulation()
                            .forEach((key, value) -> System.out.printf("[%d] = %d\n", key, value));
                    System.out.println("========================");
                    break;
                case 5:
                    System.out.println("========================");
                    cityService.countCitiesByRegion()
                            .forEach((key, value) -> System.out.println(key + " - " + value));
                    System.out.println("========================");
                    break;
                case 6:
                    System.out.println("========================");
                    System.out.println("Введите путь до файла: ");
                    parseFile(scanner.nextLine());
                    System.out.println("========================");
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Сеанс завершен!");
                    return;
                default:
                    System.out.println("Введены некорректные данные, попробуйте снова.");
            }

        } while (true);
    }

    private void parseFile(String pathStr) {
        Path path = Paths.get(pathStr);
        try(Scanner scanner = new Scanner(path)) {

            List<String> inputLines = new ArrayList<>();
            while (scanner.hasNext()) {
                inputLines.add(scanner.nextLine());
            }

            parseLinesToCities(inputLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLinesToCities(List<String> lines) {

        List<City> cities = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(";");

            String name = split[1];
            String region = split[2];
            String district = split[3];
            int population = Integer.parseInt(split[4]);
            String foundation = split[5];

            cities.add(new City(name, region, district, population, foundation));
        }
        cityService.addCities(cities);
    }
}
