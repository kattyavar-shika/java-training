package com.kattyavar.shika.main.java.solid.srp;

public class WhySingleResponsibilityExample3 {
  public static void main(String[] args) {

  }


  static void problem() {
    class Order {

      void saveOrder() {
        //Save the order file, db
      }

      void sendNotification() {
        //via email, sms, whatsapp.
      }
    }

  }


}
