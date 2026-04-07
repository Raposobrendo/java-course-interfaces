package exercise1.model.services;

import exercise1.model.entities.Contract;
import exercise1.model.entities.Installment;

import java.util.ArrayList;
import java.util.List;

public class ContractService {

    PaymentService paymentService;

    public ContractService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public double totalInstallment(double amount, int month){

        double totalInterest = amount + paymentService.interest(amount, month);

        return totalInterest + paymentService.tax(totalInterest);
    }

    public List<Installment> processContract(Contract contract, int months) {

        List<Installment> installments = new ArrayList<>();

        double baseInstallment = contract.getTotalValue()/months;

        for(int i = 1; i <= months; i++){

            double installmentValue = totalInstallment(baseInstallment, i);

            installments.add(new Installment(contract.getDate().plusMonths(i), installmentValue));
        }

        return installments;
    }







}
