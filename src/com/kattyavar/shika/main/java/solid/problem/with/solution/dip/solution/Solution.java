package com.kattyavar.shika.main.java.solid.problem.with.solution.dip.solution;

/**
 * Benefits of This Design
 * Loose Coupling: UserService is now decoupled from the specific implementation of data access,
 * which makes it more flexible and easier to maintain.
 *
 */
public class Solution {
  public static void main(String[] args) {
    UserRepository database = new Database();
    UserService userService = new UserService(database);

    getUserData(userService); // Output User data from Database.

    //Now using the mock repository for testing.

    userService.setUserRepository(new MockUserRepository());
    getUserData(userService); // Output Mock user data

  }

  static void getUserData(UserService userService) {
    System.out.println(userService.getUser());
  }
}

interface UserRepository {
  String getUserData();
}

class Database implements UserRepository {
  @Override
  public String getUserData() {
    return "User data from Database.";
  }
}

class UserService {
  private UserRepository userRepository;

  // Constructor injection for better flexibility
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getUser() {
    return this.userRepository.getUserData();
  }

  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}

//Use a different implementation if needed (e.g., for testing)
//Or this could be another database, file or anything.

class MockUserRepository implements UserRepository {
  @Override
  public String getUserData() {
    return "Mock user data";
  }
}