package firstTry.application;

import firstTry.entities.Rent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramTry1 {
    public static void main(String[] Args){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carName = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        LocalDateTime pickUp = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime returnCar = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Enter price per hour: ");
        Double priceHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        Double priceDay = sc.nextDouble();

        Rent rent = new Rent(carName, pickUp, returnCar, priceHour, priceDay);

        System.out.println(rent);




    }
}
