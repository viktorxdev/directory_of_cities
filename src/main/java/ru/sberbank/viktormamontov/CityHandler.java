package ru.sberbank.viktormamontov;

import java.util.List;
import java.util.Map;

/**
 * @author Viktor Mamontov
 */
public interface CityHandler {

    /**
     * @param lines - list of strings, where every string - one city data, separated by ";", null or empty list will throw IllegalArgumentException
     * @return list of City.class objects
     */
    List<City> parseLines(List<String> lines);

    /**
     * sort cities by name ignore cases DESC
     * @param cities - list of City.class objects, null or empty list will throw IllegalArgumentException
     */
    void sortByName(List<City> cities);

    /**
     * sort cities by district and name DESC
     * @param cities - list of City.class objects, null or empty list will throw IllegalArgumentException
     */
    void sortByDistrictAndName(List<City> cities);

    /**
     * convert list to array
     * @param cities - list of City.class objects, null or empty list will throw IllegalArgumentException
     * @return map, where key is index of city in array with largest population, value is population
     */
    Map<Integer, Integer> findCityIndexWithLargestPopulation(List<City> cities);


    /**
     * additional implementation of findCityIndexWithLargestPopulation method
     * @param cities - list of City.class objects, null or empty list will throw IllegalArgumentException
     * @return City object with largest population
     */
    City findCityWithLargestPopulation(List<City> cities);

    /**
     * @param cities - list of City.class objects, null or empty list will throw IllegalArgumentException
     * @return map, where key is region, value is quantity of cities in this region
     */
    Map<String, Long> countCitiesByRegion(List<City> cities);
}
