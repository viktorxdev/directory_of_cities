package ru.sberbank.viktormamontov;

import java.util.*;
import java.util.stream.Collectors;
/**
 * @author Viktor Mamontov
 */
public class CityHandlerImpl implements CityHandler {

    @Override
    public List<City> parseLines(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("input list is null or empty");
        }
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

    @Override
    public void sortByName(List<City> cities) {
        checkNullOrEmptyList(cities);
        Collections.sort(cities, Comparator.comparing(c -> c.getName().toLowerCase()));
        Collections.reverse(cities);
    }

    @Override
    public void sortByDistrictAndName(List<City> cities) {
        checkNullOrEmptyList(cities);
        Collections.sort(cities, Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName).reversed());
    }


    //return map, where key is index of city with largest population, value is population
    @Override
    public Map<Integer, Integer> findCityIndexWithLargestPopulation(List<City> cities) {
        checkNullOrEmptyList(cities);
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
    @Override
    public City findCityWithLargestPopulation(List<City> cities) {
        checkNullOrEmptyList(cities);
        Optional<City> max = cities.stream().max(Comparator.comparing(City::getPopulation));
        if (max.isPresent())
            return max.get();
        return null;
    }

    //return map where key is region, value is quantity of cities in this region
    @Override
    public Map<String, Long> countCitiesByRegion(List<City> cities) {
        checkNullOrEmptyList(cities);
        Map<String, Long> collect = cities.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        return collect;
    }

    private void checkNullOrEmptyList(List<City> cities) {
        if (cities == null || cities.isEmpty()) {
            throw new IllegalArgumentException("input list of cities is null or empty");
        }
    }

}
