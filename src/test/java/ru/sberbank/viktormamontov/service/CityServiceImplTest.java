package ru.sberbank.viktormamontov.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.viktormamontov.DAO.CityDao;
import ru.sberbank.viktormamontov.DAO.CityDaoImpl;
import ru.sberbank.viktormamontov.MyCityDataBase;
import ru.sberbank.viktormamontov.entity.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceImplTest {

    private CityService cityService;
    private CityDao cityDao;
    private MyCityDataBase db;

    @BeforeEach
    void setUp() {

        List<City> cities = new ArrayList<>();

        cities.add(new City("Адыгейск", "Адыгея", "Южный", 12248,"1973"));
        cities.add(new City("Майкоп", "Адыгея", "Южный", 144246,"1857"));
        cities.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928,"1830"));

        db = new MyCityDataBase();
        db.setCities(cities);

        cityDao = new CityDaoImpl(db);
        cityService = new CityServiceImpl(cityDao);
    }

    @Test
    void addCities() {
        City city = new City("test", "test", "test", 1, "test");
        List<City> list = new ArrayList<>();
        list.add(city);
        cityService.addCities(list);
        assertEquals(city, cityService.getCities().get(3));
    }

    @Test
    void getCities() {
        List<City> cities = cityService.getCities();
        assertEquals(new City("Адыгейск", "Адыгея", "Южный", 12248,"1973"), cities.get(0));
    }

    @Test
    void getCitiesSortedByNameDesc() {
        List<City> cities = cityService.getCitiesSortedByNameDesc();
        assertEquals("Майкоп", cities.get(0).getName());
    }

    @Test
    void getCitiesSortedByDistrictAndNameDesc() {
        List<City> cities = cityService.getCitiesSortedByDistrictAndNameDesc();
        assertEquals("Южный", cities.get(0).getDistrict());
        assertEquals("Майкоп", cities.get(0).getName());
    }

    @Test
    void findCityIndexWithLargestPopulation() {
        Map<Integer, Integer> map = cityService.findCityIndexWithLargestPopulation();
        Integer integer = map.values().stream().findFirst().get();
        assertEquals(144246, integer);
    }

    @Test
    void findCityWithLargestPopulation() {
        City city = cityService.findCityWithLargestPopulation();
        assertEquals(144246, city.getPopulation());
    }

    @Test
    void countCitiesByRegion() {
        Map<String, Long> map = cityService.countCitiesByRegion();
        Map.Entry<String, Long> entry = map.entrySet().stream().findFirst().get();
        assertEquals("Адыгея", entry.getKey());
        assertEquals(2, entry.getValue());
    }
}