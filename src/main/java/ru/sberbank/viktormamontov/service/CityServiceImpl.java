package ru.sberbank.viktormamontov.service;

import ru.sberbank.viktormamontov.DAO.CityDao;
import ru.sberbank.viktormamontov.entity.City;

import java.util.*;
import java.util.stream.Collectors;

public class CityServiceImpl implements CityService{

    private CityDao cityDao;

    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public void addCities(List<City> cities) {
        cityDao.addCities(cities);
    }

    @Override
    public List<City> getCities() {
        return cityDao.getCities();
    }

    @Override
    public List<City> getCitiesSortedByNameDesc() {
        List<City> cities = cityDao.getCities();
        cities.sort(Comparator.comparing(c -> c.getName().toLowerCase()));
        Collections.reverse(cities);
        return cities;
    }

    @Override
    public List<City> getCitiesSortedByDistrictAndNameDesc() {
        List<City> cities = cityDao.getCities();
        cities.sort(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName).reversed());
        return cities;
    }

    @Override
    public Map<Integer, Integer> findCityIndexWithLargestPopulation() {
        List<City> cities = cityDao.getCities();
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

    @Override
    public City findCityWithLargestPopulation() {
        List<City> cities = cityDao.getCities();
        Optional<City> max = cities.stream().max(Comparator.comparing(City::getPopulation));
        return max.orElse(null);
    }

    @Override
    public Map<String, Long> countCitiesByRegion() {
        List<City> cities = cityDao.getCities();
        return cities.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
    }
}
