package ru.sberbank.viktormamontov.DAO;

import ru.sberbank.viktormamontov.entity.City;

import java.util.List;

public interface CityDao {

    void addCities(List<City> cities);

    void addCity(City city);

    List<City> getCities();
}
