package com.kattyavar.shika.main.java.solid.problem.with.solution.dip.problem;

/**
 * Issues with This Design
 * Tight Coupling: UserService is directly dependent on Database, making it hard to change the database implementation
 * (e.g., switching to a different database or a mock for testing).
 * Limited Flexibility: Any changes to Database require changes in UserService.
 */
public class Problem {

  public static void main(String[] args) {
  }
}

/**
 * Importance: DIP states that high-level modules should not depend on low-level modules;
 * both should depend on abstractions. This reduces tight coupling and enhances flexibility.
 */

class DataBase {
  public String getUserData() {
    return "User data from database.";
  }
}

class UserService {
  private DataBase dataBase;

  public UserService() {
    this.dataBase = new DataBase(); // Direct dependency
  }

  public String getUser() {
    return dataBase.getUserData();
  }
}


