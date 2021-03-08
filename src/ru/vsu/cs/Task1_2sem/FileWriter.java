package ru.vsu.cs.Task1_2sem;

public class FileWriter {
    public static void writeFile(TariffsList noName) throws Exception {
        java.io.FileWriter writer = new java.io.FileWriter("src\\ru\\vsu\\cs\\Task1_2sem\\tests\\tariffsList.txt");
        for (int i = 0; i < noName.getTariffs().size(); i++) {
            writer.write(noName.getTariffs().get(i).getDirectionCode() + ", ");
            writer.write(noName.getTariffs().get(i).getDirectionName() + ", ");
            writer.write(String.valueOf(noName.getTariffs().get(i).getPriceMinute()));
            writer.write("\n");
        }
        System.out.println("Tariffs saved to file!");
        writer.close();
    }
}
