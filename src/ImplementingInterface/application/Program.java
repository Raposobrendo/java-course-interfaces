package ImplementingInterface.application;

import ImplementingInterface.model.services.BrazilTaxService;
import ImplementingInterface.model.entities.CarRental;
import ImplementingInterface.model.services.RentalService;
import ImplementingInterface.model.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rent data");
        System.out.print("Enter car model: ");
        String carModel = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Return (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter the hour price: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter the day price: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.print("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()) + "\n");
        System.out.print("Tax: " + String.format("%.2f", cr.getInvoice().getTax()) + "\n");
        System.out.print("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));




        sc.close();
    }
}
