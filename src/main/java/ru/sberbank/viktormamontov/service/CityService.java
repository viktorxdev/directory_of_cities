package ru.sberbank.viktormamontov.service;

import ru.sberbank.viktormamontov.entity.City;

import java.util.List;
import java.util.Map;

public interface CityService {

    void addCities(List<City> cities);

    List<City> getCities();

    List<City> getCitiesSortedByNameDesc();

    List<City> getCitiesSortedByDistrictAndNameDesc();

    Map<Integer, Integer> findCityIndexWithLargestPopulation();

    City findCityWithLargestPopulation();

    Map<String, Long> countCitiesByRegion();
}
