package firstTry.entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {

    private String carName;
    private LocalDateTime pickupCar;
    private LocalDateTime returnCar;
    private Double priceHour;
    private Double priceDay;

    public Rent (){

    }

    public Rent(String carName, LocalDateTime pickupCar, LocalDateTime returnCar, Double priceHour, Double priceDay) {
        this.carName = carName;
        this.pickupCar = pickupCar;
        this.returnCar = returnCar;
        this.priceHour = priceHour;
        this.priceDay = priceDay;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public LocalDateTime getPickupCar() {
        return pickupCar;
    }

    public void setPickupCar(LocalDateTime pickupCar) {
        this.pickupCar = pickupCar;
    }

    public LocalDateTime getReturnCar() {
        return returnCar;
    }

    public void setReturnCar(LocalDateTime returnCar) {
        this.returnCar = returnCar;
    }

    public Double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
    }

    public Double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(Double priceDay) {
        this.priceDay = priceDay;
    }

    public int billedHours(){
        Duration duration = Duration.between(pickupCar, returnCar);

        return (int) Math.ceil(duration.toMinutes()/60.0);
    }

    public double basicPayment(){

        int hours = billedHours();

        if(hours <= 12){
            return priceHour * hours;
        }
        else{
            int days = (int) Math.ceil(hours/24.0);
            return priceDay * days;
        }
    }

    public Double tax(){

        double basic = basicPayment();

        if(basic <= 100){
            return basic * 0.2;
        }
        else {
            return basic * 0.15;
        }
    }

    public Double totalPayment(){
        return basicPayment() + tax();
    }

    @Override
    public String toString(){

        double basic = basicPayment();
        double tax = tax();
        double total = basic + tax;

        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE:\n");
        sb.append("Basic payment: " + String.format("%.2f%n", basic));
        sb.append("TAX: " + String.format("%.2f%n", tax));
        sb.append("Total payment: " + String.format("%.2f%n", total));
        return sb.toString();
    }


}
