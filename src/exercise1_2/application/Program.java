package exercise1_2.application;

import exercise1_2.model.entities.Contract;
import exercise1_2.model.entities.Installment;
import exercise1_2.model.services.ContractService;
import exercise1_2.model.services.PaypalPayment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();

        System.out.print("Enter data (dd/MM/yyyy): ");
        sc.nextLine();
        String date = sc.nextLine();
        LocalDate contractDate = LocalDate.parse(date, fmt);

        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        System.out.print("Enter number os installments: ");
        int quantityInstallments = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);
        ContractService contractService = new ContractService(new PaypalPayment());
        List<Installment> installments = contractService.processContract(contract, quantityInstallments);

        for(Installment inst : installments){
            System.out.println(inst);
        }

    }
}
