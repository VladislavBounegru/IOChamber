package ru.bounegru.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOChamber {

    private static Scanner scanner;
    private static List<String> lines;

    public static void main(String[] args) throws FileNotFoundException {
        lines = new ArrayList<>();
        if (args.length > 0) {
            outputFromFile(args[0]);
        } else {
            outputFromConsole();
        }
        printOddRows();

    }

    private static void outputFromFile(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не распознан. Введите ваши сообщения");
            outputFromConsole();
        }
    }

    private static void outputFromConsole() {

        scanner = new Scanner(System.in);
        String currentLine;
        while (!(currentLine = scanner.nextLine()).equals("")) {
            lines.add(currentLine);
        }
    }

    private static void printOddRows() {
        for (int i = 0; i < lines.size(); i += 2) {
            System.out.println(lines.get(i));
        }
    }

    private static void printAllRows() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
