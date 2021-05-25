package ru.sberbank.viktormamontov;

import java.util.*;

public class CityHandler {

    public List<City> parseLines(List<String> lines) {
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
        return cities;
    }

    public void sortByName(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(c -> c.getName().toLowerCase()));
    }

    public void sortByDistrictAndName(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }


    //return map, where key is index of city in array with largest population, value is population
    public Map<Integer, Integer> findCityWithLargestPopulation(List<City> cities) {
        City[] arr = new City[cities.size()];
        arr = cities.toArray(arr);
        int maxPopulation = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPopulation() > maxPopulation) {
                maxPopulation = arr[i].getPopulation();
                idx = i;
            }
        }
        return Collections.singletonMap(idx, maxPopulation);
    }
}
