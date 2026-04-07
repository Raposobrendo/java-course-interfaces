package exercise1.model.entities;

import java.time.LocalDate;

public class Contract {

    private final int number;
    private final LocalDate date;
    private final double totalValue;

    public Contract(int number, LocalDate date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalValue() {
        return totalValue;
    }
}
