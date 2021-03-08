package ru.vsu.cs.Task1_2sem;

public class Tariffs {
    private int directionCode;
    private String directionName;
    private int priceMinute;

    public Tariffs(int directionCode, String directionName, int priceMinute) {
        this.directionCode = directionCode;
        this.directionName = directionName;
        this.priceMinute = priceMinute;
    }

    public int getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(int directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public int getPriceMinute() {
        return priceMinute;
    }

    public void setPriceMinute(int priceMinute) {
        this.priceMinute = priceMinute;
    }
}
