package com.kattyavar.shika.main.java.live_session.mar4.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    tesMe();
  }


  static void tesMe() throws IOException {

    BufferedReader br = null;
    FileWriter fw = null;
    try {

      br = new BufferedReader(new FileReader("inputdfdfdfdfd.txt"));
      fw = new FileWriter("output.txt");

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println();
      }

    } catch (Exception e) {

    }


    try (BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));
         FileWriter fw1 = new FileWriter("output.txt");
         Temp obj = new Temp();
    ) {

    }


  }

}


class Temp implements AutoCloseable {
  @Override
  public void close() {

  }
}

