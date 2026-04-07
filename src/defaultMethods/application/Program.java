package defaultMethods.application;

import defaultMethods.model.entities.BrazilInterestService;
import defaultMethods.model.entities.InterestService;
import defaultMethods.model.entities.UsaInterestService;
import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Let's calculate the total amount to pay a loan.");
        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Months: ");
        int months = sc.nextInt();


        InterestService bis = new BrazilInterestService(2.0);
        UsaInterestService uis = new UsaInterestService(1.0);

        double payment = uis.payment(amount, months);

        System.out.println("Payment after " + months + " months: ");
        System.out.println(String.format("%.2f", payment));

        sc.close();
    }
}
