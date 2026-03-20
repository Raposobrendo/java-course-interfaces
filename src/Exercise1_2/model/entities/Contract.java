package Exercise1_2.model.entities;

import java.time.LocalDate;

public class Contract {

    private int number;
    private LocalDate date;
    private double totalValue;

    public Contract(int name, LocalDate date, double totalValue) {
        this.number = name;
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
