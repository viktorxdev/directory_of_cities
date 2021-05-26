package ru.sberbank.viktormamontov.DAO;

import ru.sberbank.viktormamontov.MyCityDataBase;
import ru.sberbank.viktormamontov.entity.City;

import java.util.List;

public class CityDaoImpl implements CityDao{

    private MyCityDataBase db;

    public CityDaoImpl(MyCityDataBase db) {
        this.db = db;
    }

    @Override
    public void addCities(List<City> cities) {
        db.getCities().addAll(cities);
    }

    @Override
    public void addCity(City city) {
        db.getCities().add(city);
    }

    @Override
    public List<City> getCities() {
        return db.getCities();
    }
}
