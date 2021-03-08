package ru.vsu.cs.Task1_2sem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TariffsList {

    private List<Tariffs> tariffs;

    public TariffsList(List<Tariffs> tariffs) {
        this.tariffs = tariffs;
    }
    
    public List<Tariffs> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<Tariffs> tariffs) {
        this.tariffs = tariffs;
    }
    
    public static void calculateCallRate(TariffsList tariffsList) {
        int callNumber = Main.readSomething("Enter call number: ");
        double callMinute = Double.parseDouble(String.valueOf(roundTheNumber()));
        double sale = 0;
        String name = null;
        if (callMinute <= 0.11) callMinute = 0;
        while (String.valueOf(callNumber).length() != 1) {
            if (sale != 0) break;
            for (int i = 0; i < tariffsList.getTariffs().size(); i++) {
                if (callNumber == tariffsList.getTariffs().get(i).getDirectionCode()) {
                    sale = callMinute * tariffsList.getTariffs().get(i).getPriceMinute();
                    name = tariffsList.getTariffs().get(i).getDirectionName();
                    break;
                }
            }
            callNumber = callNumber / 10;
        }
        if (sale == 0 && name == null) System.out.println("Incorrect number or no tariff for this country!");
        else System.out.printf("Country call %s will cost %s c.u\n", name, sale);
    }
    
    public static BigDecimal roundTheNumber() {
        double value = Main.readSomething("Enter the number of seconds: ");
        value /= 60;
        BigDecimal result = new BigDecimal(value);
        result = result.setScale(2, RoundingMode.UP);
        return result;
    }

    public static void writeTariffs(TariffsList tariffsList) {
        for (int i = 0; i < tariffsList.getTariffs().size(); i++) {
            System.out.printf(i + 1 + ") Code of the country: %s. The name of the country: %s. Price per minute of conversation: %s c.u. \n",
                    tariffsList.getTariffs().get(i).getDirectionCode(),
                    tariffsList.getTariffs().get(i).getDirectionName(),
                    tariffsList.getTariffs().get(i).getPriceMinute());
        }
    }

    public static void addTariffs(TariffsList tariffsList, int n) {
        List<Tariffs> list = new ArrayList<>(tariffsList.getTariffs());
        for (int i = 0; i < n; i++) {
            Tariffs tariff = new Tariffs(0, "0", 0);
            tariff.setDirectionCode(Main.readSomething("Input direction code: "));
            tariff.setDirectionName(Main.readLine("Input direction name: "));
            tariff.setPriceMinute(Main.readSomething("Input price minute: "));
            list.add(tariff);
        }
        System.out.println("Tariff added!");
        tariffsList.setTariffs(list);
    }

    public static void deleteTariffs(TariffsList tariffsList, int n) {
        if (tariffsList.getTariffs().size() != 0) {
            tariffsList.getTariffs().remove(n);
            System.out.print("Tariff removed!\n");
        } else {
            System.out.println("The list is empty!");
        }
    }

    public static void editTariff(TariffsList tariffsList, int n) {
        System.out.println("Old tariff ");
        System.out.printf("Code of the country: %s.\nThe name of the country: %s.\nPrice per minute of conversation: %s.\n\n",
                tariffsList.getTariffs().get(n - 1).getDirectionCode(),
                tariffsList.getTariffs().get(n - 1).getDirectionName(),
                tariffsList.getTariffs().get(n - 1).getPriceMinute());
        System.out.println("Enter the corrected data ");
        Tariffs tariff = new Tariffs(0, "0", 0);
        List<Tariffs> list = new ArrayList<>(tariffsList.getTariffs());
        tariff.setDirectionCode(Main.readSomething("Code of the country: "));
        tariff.setDirectionName(Main.readLine("The name of the country: "));
        tariff.setPriceMinute(Main.readSomething("Price per minute of conversation: "));
        list.remove(n - 1);
        list.add(n - 1, tariff);
        tariffsList.setTariffs(list);
        System.out.println("Correction was successful!");
    }

    public static void writeCommands() {
        System.out.println("Command List:\n\\c - Calculate the cost of a call.\n\\a - Add tariff.\n\\w - Save tariffs to file.\n\\d - Delete tariff.\n\\i - Information about tariffs\n\\r - Edit tariff.\n\\e - Finish work.");
    }
}
