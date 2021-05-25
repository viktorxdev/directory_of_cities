package ru.sberbank.viktormamontov;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get("/Users/u19223645/Downloads/Cities.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> inputLines = new ArrayList<>();
        while (scanner.hasNext()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();

        ConsoleWorker consoleWorker = new ConsoleWorker(inputLines);
        consoleWorker.showMenu();

    }
}
