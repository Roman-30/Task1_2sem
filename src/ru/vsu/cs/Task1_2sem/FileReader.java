package ru.vsu.cs.Task1_2sem;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static String[][] readFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("src\\ru\\vsu\\cs\\Task1_2sem\\tests\\test" + Main.readSomething("Enter file number: ") + ".txt"));
        List<String> fileData = new ArrayList<>();
        while (bufferedReader.ready()) {
            fileData.add(bufferedReader.readLine());
        }
        String[][] arr = new String[fileData.size()][3];
        for (int i = 0; i < fileData.size(); i++) {
            arr[i] = fileData.get(i).split(", ");
        }
        bufferedReader.close();
        return arr;
    }

    public static TariffsList setLines() throws Exception {
        Tariffs tariffs;
        TariffsList tariffsList = new TariffsList(new ArrayList<Tariffs>());
        List<Tariffs> list = new ArrayList<>();
        String[][] lines = readFile();
        for (String[] strings : lines) {
            tariffs = new Tariffs(0, "0", 0);
            tariffs.setDirectionCode(Integer.parseInt(strings[0]));
            tariffs.setDirectionName(strings[1]);
            tariffs.setPriceMinute(Integer.parseInt(strings[2]));
            list.add(tariffs);
        }
        tariffsList.setTariffs(list);
        return tariffsList;
    }
}
