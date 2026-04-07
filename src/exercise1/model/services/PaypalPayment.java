package exercise1.model.services;

public class PaypalPayment implements PaymentService{

    @Override
    public double interest(double amount, int month){
        return amount * 0.01 * month;
    }

    @Override
    public double tax(double amount){
        return amount * 0.02;
    };
}
