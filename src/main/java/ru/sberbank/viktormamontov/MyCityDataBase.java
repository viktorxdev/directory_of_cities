package ru.sberbank.viktormamontov;

import ru.sberbank.viktormamontov.entity.City;

import java.util.ArrayList;
import java.util.List;

public class MyCityDataBase {

    private List<City> cities;

    public MyCityDataBase() {
        cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
