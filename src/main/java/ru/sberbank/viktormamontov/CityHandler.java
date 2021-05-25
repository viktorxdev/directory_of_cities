package ru.sberbank.viktormamontov;

import java.util.ArrayList;
import java.util.List;

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
}
