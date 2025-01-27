package com.kattyavar.shika.main.java.examtest;

import java.util.*;

public class MainTest {


  public static void main(String[] args) {
    Optional<String> temp = Optional.empty();

    List<String> strings = new ArrayList<>();

    Stack<String> agc = new Stack<>();

    strings.add("two");
    strings.add("two1");
    strings.add("two2");

    StringJoiner joiner = new StringJoiner("_");

    // Add elements from the list to the StringJoiner
    for (String item : strings) {
      joiner.add(item);
    }

    // Return the joined string

    System.out.println(joiner);

    System.out.println(temp);
  }


  public static int findFreq(Integer N, int array_length, List<Integer> arr) {
    int freq = 0;

    for (int i = 0; i < array_length; i++) {
      if (arr.get(i).equals(N)) {
        freq++;
      }

    }
    return freq;
  }


  String getDate (String input){
    String[] productEntries = input.split(";");

    String productWithLowestQty = null;
    int lowestQuantity = Integer.MAX_VALUE;

    // Iterate over each product entry
    for (String entry : productEntries) {
      // Split by space to separate product name and quantity
      String[] parts = entry.split(" ");

      if (parts.length == 2) {
        try {
          String productName = parts[0].trim();
          int quantity = Integer.parseInt(parts[1].trim());  // Parse the quantity

          // Check if this product has the lowest quantity
          if (quantity < lowestQuantity) {
            lowestQuantity = quantity;
            productWithLowestQty = productName;  // Update the product name with the lowest quantity
          }
        } catch (NumberFormatException e) {
          System.out.println("Invalid quantity for product: " + parts[1]);
        }
      } else {
        System.out.println("Invalid product entry: " + entry);
      }
    }

    // Return the product with the lowest quantity, or null if no valid product was found
    return productWithLowestQty;
  }
}
