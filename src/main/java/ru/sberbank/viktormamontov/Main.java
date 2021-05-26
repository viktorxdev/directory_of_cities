package ru.sberbank.viktormamontov;

import ru.sberbank.viktormamontov.DAO.CityDao;
import ru.sberbank.viktormamontov.DAO.CityDaoImpl;
import ru.sberbank.viktormamontov.service.CityService;
import ru.sberbank.viktormamontov.service.CityServiceImpl;



public class Main {
    public static void main(String[] args) {

//       /Users/u19223645/Downloads/Cities.txt


        MyCityDataBase db = new MyCityDataBase();
        CityDao cityDao = new CityDaoImpl(db);
        CityService cityService = new CityServiceImpl(cityDao);

        ConsoleWorker consoleWorker = new ConsoleWorker(cityService);
        consoleWorker.start();
        consoleWorker.showMenu();

    }
}
