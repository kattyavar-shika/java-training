package com.kattyavar.shika.main.java.live_session.sep25.solid.dip.problem;

public class Problem {
}


class Database {
  public String getUserData() {
    //Get the data from database. and apply the logic.
    return "User data from database";
  }
}


class UserService {
  private Database database;

  public UserService() {
    this.database = new Database(); // Direct Dependency...
  }

  public String getUser() {
    return database.getUserData();
  }
}