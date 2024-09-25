package com.kattyavar.shika.main.java.live_session.sep25.solid.dip.solution;

public class Solution {
  public static void main(String[] args) {

    Database database = new Database();
    UserService userService = new UserService(database);

    //System.out.println(userService.getUser());

    userService.setUserRepository(new MockDatabase());
    System.out.println(userService.getUser());
  }
}


interface UserRepository {
  String getUserData();
}


class Database implements UserRepository {
  @Override
  public String getUserData() {
    return "Data from Database";
  }
}

class MockDatabase implements UserRepository {
  @Override
  public String getUserData() {
    return "Data from Mock database";
  }
}

class UserService {
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getUser() {
    return userRepository.getUserData();
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}