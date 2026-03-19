package Exercise1.model.services;

public interface PaymentService {

    double interest(double amount, int months);
    double tax (double amount);
}
