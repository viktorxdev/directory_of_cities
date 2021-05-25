package ru.sberbank.viktormamontov;

import java.util.List;
import java.util.Map;

public interface CityHandler {

    List<City> parseLines(List<String> lines);

    void sortByName(List<City> cities);

    void sortByDistrictAndName(List<City> cities);

    //return map, where key is index of city with largest population, value is population
    Map<Integer, Integer> findCityIndexWithLargestPopulation(List<City> cities);

    //another implementation of module 3 task
    City findCityWithLargestPopulation(List<City> cities);

    //return map where key is region, value is quantity of cities in this region
    Map<String, Long> countCitiesByRegion(List<City> cities);
}
