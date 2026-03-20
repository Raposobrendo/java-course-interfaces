package Exercise1_2.model.services;

import Exercise1_2.model.entities.Contract;
import Exercise1_2.model.entities.Installment;

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

    public List<Installment> processContract(Contract contract, int month){

        List<Installment> installments = new ArrayList<>();
        double amount = contract.getTotalValue()/month;

        for(int i = 1; i <= month; i++){
            double installmentValue = totalAmount(amount, i);
            installments.add(new Installment(contract.getDate().plusMonths(i), installmentValue));
        }

        return installments;
    }
}
