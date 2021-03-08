package ru.vsu.cs.Task1_2sem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int n;
        TariffsList noName = FileReader.setLines();
        TariffsList.writeCommands();
        String line = readLine("Enter command: ");
        while (!line.equals("\\e")) {
            switch (line) {
                case "\\c":
                    TariffsList.calculateCallRate(noName);
                    break;
                case "\\a":
                    n = readSomething("Enter the number of new tariffs: ");
                    TariffsList.addTariffs(noName, n);
                    break;
                case "\\d":
                    n = readSomething("Enter the line you want to delete: ");
                    TariffsList.deleteTariffs(noName, n - 1);
                    break;
                case "\\i":
                    TariffsList.writeTariffs(noName);
                    break;
                case "\\w":
                    FileWriter.writeFile(noName);
                    break;
                case "\\r":
                    n = readSomething("Enter the number line who you want to correct: ");
                    TariffsList.editTariff(noName, n);
                    break;
                default:
                    System.out.println("There is no such command!");
                    TariffsList.writeCommands();
            }
            line = readLine("\nEnter command: ");
        }
    }

    public static int readSomething(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextInt();
    }

    public static String readLine(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextLine();
    }
}
