package ru.sberbank.viktormamontov;

import java.util.*;
import java.util.stream.Collectors;

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
        Collections.reverse(cities);
    }

    public void sortByDistrictAndName(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName).reversed());
    }


    //return map, where key is index of city with largest population, value is population
    public Map<Integer, Integer> findCityIndexWithLargestPopulation(List<City> cities) {
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

    //another implementation of module 3 task
    public City findCityWithLargestPopulation(List<City> cities) {
        Optional<City> max = cities.stream().max(Comparator.comparing(City::getPopulation));
        if (max.isPresent())
            return max.get();
        return null;
    }

    //return map where key is region, value is quantity of cities in this region
    public Map<String, Long> countCitiesByRegion(List<City> cities) {
        Map<String, Long> collect = cities.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        return collect;
    }

}
