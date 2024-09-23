package com.kattyavar.shika.main.java.solid.srp;


public class WhySingleResponsibilityExample4 {

  public static void main(String[] args) {

    class PaymentProcessor {
      void processCreditCard(double amount) {
        System.out.println("Payment done using credit card " + amount);
      }

      void processBankTransfer(double amount) {
        System.out.println("Payment done using Bank transfer " + amount);
      }

      void processPayPal(double amount) {
        System.out.println("Payment done using paypal " + amount);
      }
    }

  }

  static void solution() {
    interface PaymentMethod {
      void processPayment(double amount);
    }

    class PaymentProcessor {
      void processPayment(PaymentMethod paymentMethod, double amount) {

      }
    }

  }


}
