package Exercise1_2.model.services;

public interface PaymentService {


    double interest(double amount, int month);
    double tax(double amount);
}
