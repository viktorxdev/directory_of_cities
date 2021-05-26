//package ru.sberbank.viktormamontov;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ru.sberbank.viktormamontov.entity.City;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CityHandlerTest {
//
//    private List<String> inputLines;
//    private CityHandler cityHandler;
//
//
//    @BeforeEach
//    void setUp() {
//        inputLines = new ArrayList<>();
//        inputLines.add("1;Адыгейск;Адыгея;Южный;12248;1973");
//        inputLines.add("2;Майкоп;Адыгея;Южный;144246;1857");
//        inputLines.add("3;Горно-Алтайск;Алтай;Сибирский;56928;1830");
//        cityHandler = new CityHandlerImpl();
//    }
//
//    @Test
//    void parseLines() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        City city = cities.get(0);
//        assertEquals(new City("Адыгейск", "Адыгея", "Южный", 12248,"1973"), city);
//        city = cities.get(1);
//        assertEquals(new City("Майкоп", "Адыгея", "Южный", 144246,"1857"), city);
//        city = cities.get(2);
//        assertEquals(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928,"1830"), city);
//
//    }
//
//    @Test
//    void sortByName() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        cityHandler.sortByName(cities);
//        City city = cities.get(0);
//        assertEquals("Майкоп", city.getName());
//        city = cities.get(1);
//        assertEquals("Горно-Алтайск", city.getName());
//        city = cities.get(2);
//        assertEquals("Адыгейск", city.getName());
//
//    }
//
//    @Test
//    void sortByDistrictAndName() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        cityHandler.sortByDistrictAndName(cities);
//        City city = cities.get(0);
//        assertEquals("Южный", city.getDistrict());
//        assertEquals("Майкоп", city.getName());
//        city = cities.get(1);
//        assertEquals("Южный", city.getDistrict());
//        assertEquals("Адыгейск", city.getName());
//        city = cities.get(2);
//        assertEquals("Сибирский", city.getDistrict());
//        assertEquals("Горно-Алтайск", city.getName());
//    }
//
//    @Test
//    void findCityIndexWithLargestPopulation() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        Map<Integer, Integer> map = cityHandler.findCityIndexWithLargestPopulation(cities);
//        Integer population = map.values().stream().findFirst().get();
//        assertEquals(144246, population);
//    }
//
//    @Test
//    void findCityWithLargestPopulation() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        City city = cityHandler.findCityWithLargestPopulation(cities);
//        assertEquals(144246, city.getPopulation());
//    }
//
//    @Test
//    void countCitiesByRegion() {
//        List<City> cities = cityHandler.parseLines(inputLines);
//        Map<String, Long> map = cityHandler.countCitiesByRegion(cities);
//        Long i1 = map.get("Адыгея");
//        Long i2 = map.get("Алтай");
//        assertEquals(2, i1);
//        assertEquals(1, i2);
//    }
//}