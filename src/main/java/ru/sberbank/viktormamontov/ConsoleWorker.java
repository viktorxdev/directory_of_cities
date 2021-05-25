package ru.sberbank.viktormamontov;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleWorker {

    private CityHandler cityHandler;
    private Scanner scanner;
    private List<City> cities;

    public ConsoleWorker(List<String> lines) {
        this.cityHandler = new CityHandlerImpl();
        cities = cityHandler.parseLines(lines);
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        do {
            System.out.println("Введите номер действия:");
            System.out.println("1 - получить список городов");
            System.out.println("2 - получить список городов, отсортированный по названию по убыванию");
            System.out.println("3 - получить список городов, отсортированный по региону и по названию по убыванию");
            System.out.println("4 - получить индекс города с наибольшим населением");
            System.out.println("5 - получить список регионов с количеством их городов");
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
                    cities.forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 2:
                    System.out.println("========================");
                    cityHandler.sortByName(cities);
                    cities.forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 3:
                    System.out.println("========================");
                    cityHandler.sortByDistrictAndName(cities);
                    cities.forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case 4:
                    System.out.println("========================");
                    Map<Integer, Integer> cityWithLargestPopulation = cityHandler.findCityIndexWithLargestPopulation(cities);
                    cityWithLargestPopulation.forEach((key, value) -> System.out.printf("[%d] = %d\n", key, value));
                    System.out.println("========================");
                    break;
                case 5:
                    System.out.println("========================");
                    Map<String, Long> countCitiesByRegion = cityHandler.countCitiesByRegion(cities);
                    countCitiesByRegion.forEach((key, value) -> System.out.println(key + " - " + value));
                    System.out.println("========================");
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Сеанс завершен!");
                    return;
                default:
                    System.out.println("Введены некорректные данные, попробуйте снова.");
                    continue;
            }

        } while (true);
    }
}
