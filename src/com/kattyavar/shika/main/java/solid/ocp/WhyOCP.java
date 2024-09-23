package com.kattyavar.shika.main.java.solid.ocp;

public class WhyOCP {

  public static void main(String[] args) {

  }
}
// should be open for extension, but closed for modification
//Add new payment methods without modifying existing code:

interface PaymentMethod {
  void processPayment(double amount);
}

class PaymentProcessor {
  void processPayment(PaymentMethod paymentMethod, double amount) {

  }
}

class CreditCard implements PaymentMethod {

  @Override
  public void processPayment(double amount) {
    System.out.println("Using creditCard");
  }
}

class PayPal implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
    System.out.println("Using paypal");
  }
}

class BankTransfer implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
    System.out.println("Using BankTransfer");
  }
}
