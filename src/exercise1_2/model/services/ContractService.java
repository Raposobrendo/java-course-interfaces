package exercise1_2.model.services;

import exercise1_2.model.entities.Contract;
import exercise1_2.model.entities.Installment;

import java.util.ArrayList;
import java.util.List;

public class ContractService {

    PaymentService paymentService;

    public ContractService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public double totalAmount(double amount, int month){

        double basicTotal = amount + paymentService.interest(amount, month);

        return basicTotal + paymentService.tax(basicTotal);
    }

    public List<Installment> processContract(Contract contract, int months){

        List<Installment> installments = new ArrayList<>();
        double amount = contract.getTotalValue()/months;

        for(int i = 1; i <= months; i++){
            double installmentValue = totalAmount(amount, i);
            installments.add(new Installment(contract.getDate().plusMonths(i), installmentValue));
        }

        return installments;
    }
}
