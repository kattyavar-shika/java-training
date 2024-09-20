package com.kattyavar.shika.main.java.ioexample;

import java.io.*;
import java.util.Scanner;

public class ReadFromConsoleExample {
  public static void main(String[] args) {
    usingBufferReader();
    usingScanner();

    //readFileUsingBufferReader();
    //readFileUsingScanner();

    /**
     * Writing to a file in Java can be done using various classes, with FileWriter, BufferedWriter, and PrintWriter
     * being some of the most common.
     * Choose
     * BufferedWriter for efficiency with larger data,
     * PrintWriter for convenience with formatted text, and
     * FileWriter for simple text output.
     */

  }

  static void fileWriterExample() {
    String fileName = "abc.txt";
    try (FileWriter writer = new FileWriter(fileName)) {
      writer.write("Hello World");
      writer.write("File writing example");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static void bufferedWriterExample() throws IOException {
    String fileName = "abc.txt";
    //if you want to append then new FileWriter(filename, true); // true for appending
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
      bw.write("Hello World");
      bw.write("Write using BufferedWriter");
    }
  }

  static void printWriterExample() throws IOException {
    String fileName = "abc.txt";
    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

      writer.println("Hello World");
      writer.println("Write using PrintWriter");
    }
  }

  static void usingScanner() {
    /**
     * Scanner is easier and more convenient for reading user input due to its built-in methods for different data types.
     */

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter any name...");
    String input = scanner.nextLine();
    System.out.println("We read as -> " + input);

    System.out.println("Please enter any number ");
    int numberInput = scanner.nextInt();
    System.out.println("Number got as -> " + numberInput);

  }

  static void usingBufferReader() {

    /**
     * BufferedReader is more efficient for reading large text input but requires manual parsing for different data types.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.println("Enter any name...");
      String input = reader.readLine();
      System.out.println("We read as -> " + input);

      //Even if you want to read non String (int) values still you need to read as string and convert it.
      //in such cases use scanner

      System.out.println("Please enter any number ");
      String numberInput = reader.readLine();
      int number = Integer.parseInt(numberInput);
      System.out.println("Number got as -> " + numberInput);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  static void readFileUsingBufferReader() {

    try (BufferedReader br = new BufferedReader(new FileReader("abc.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  static void readFileUsingScanner() {

    try (Scanner scanner = new Scanner(new FileReader("abc.txt"))) {
      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

