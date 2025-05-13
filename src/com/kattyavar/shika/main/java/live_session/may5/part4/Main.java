package com.kattyavar.shika.main.java.live_session.may5.part4;

public class Main {

  public static void main(String[] args) {

  }
}


interface UserRepository {

  String getUserDetails();
}

class DataBase implements UserRepository{
  public String getUserDetails() {
    return "User Data from database mysql";
  }
}

class NewDB implements UserRepository {
  @Override
  public String getUserDetails() {
    return "";
  }
}

class UserService {
  private UserRepository userRepository;

  public UserService(DataBase dataBase) {
    this.userRepository = dataBase;
  }

  public String getUser() {
    return userRepository.getUserDetails();
  }
}