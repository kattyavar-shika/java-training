package com.kattyavar.shika.main.java.solid.srp;

public class WhySingleResponsibility {


  class Product {
    String name;
    String colour;
    int yearOfManufacturing;
    int price;

    public Product(String name, String colour, int yearOfManufacturing, int price) {
      this.name = name;
      this.colour = colour;
      this.yearOfManufacturing = yearOfManufacturing;
      this.price = price;
    }
  }


//Lets apply the below changes
// 1) Change the Total price calculation
// 2) Save to another data base
// 3)

  class Invoice {
    private Product product;  // has a relationship.
    private int quantity;

    public Invoice(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }

    public int calculateTotal() {
      int price = quantity * product.price;
      return price;
    }

    public void printInvoice() {
      //Print invoice
    }

    public void save() {
      //Save to database.
    }
  }

  public static void main(String[] args) {

  }

  //Now lets apply Single Responsibility principle

  public static void solution() {

    //Robert C. Martin conceptualized SOLID principles (also known as Uncle Bob)
    /**
     *  A class should have only 1 reason to change.
     * - Avoid duplicate code.
     * - Easy to maintain
     * - Easy to Understand
     * - Flexible software
     * - Reduce complexity
     */
    class Invoice {
      private Product product;
      private int quantity;
    }

    //for Invoice lets create the Separate class
    class InvoiceDTO {
      Invoice invoice;

      public InvoiceDTO(Invoice invoice) {
        this.invoice = invoice;
      }

      public void save() {
        //Save to DB
      }

    }

    class InvoicePrinter {
      private Invoice invoice;

      public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
      }

      public void print() {
        // print the Invoice
      }
    }

  }


}

