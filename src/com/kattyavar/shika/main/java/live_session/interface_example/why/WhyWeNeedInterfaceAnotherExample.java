package com.kattyavar.shika.main.java.live_session.interface_example.why;

interface PaymentMethod {
    void processPayment(double amount);
}

public class WhyWeNeedInterfaceAnotherExample {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        CreditCardPayment creditCardPayment = new CreditCardPayment("1794-5678-9176-5412");
        PayPalPayment payPalPayment = new PayPalPayment("test@test.com");

        paymentProcessor.processPayment(creditCardPayment, 10);
        paymentProcessor.processPayment(payPalPayment, 10);

    }

}

class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {

        System.out.println("Processing credit card payment of " + amount + " with card number :" + cardNumber);
    }
}


class PayPalPayment implements PaymentMethod {
    private String payPalEmail;

    public PayPalPayment(String payPalEmail) {
        this.payPalEmail = payPalEmail;
    }

    @Override
    public void processPayment(double amount) {

        System.out.println("Processing Paypal payment of " + amount + " with email :" + payPalEmail);

    }
}


