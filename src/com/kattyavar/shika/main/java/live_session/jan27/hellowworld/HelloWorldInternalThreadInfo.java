package com.kattyavar.shika.main.java.live_session.jan27.hellowworld;

import java.util.Scanner;

public class HelloWorldInternalThreadInfo {
  public static void main(String[] args) {
    System.out.println("Hello World");

    long pid = ProcessHandle.current().pid();

    System.out.println("Use this command to check the process more information ");
    System.out.println("ps -T -p " + pid);

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }
}
