package com.kattyavar.shika.main.java.live_session.sep20;

import java.util.ArrayList;
import java.util.List;

public class RefMemoryIssue {
  public static void main(String[] args) {
    Configuration conf = new Configuration();

    List<Profile> profiles = conf.getProfiles();

    System.out.println("Configuration data ==> " + conf.toString());

    System.out.println("We got the profiles " + profiles);

    //profiles.add(new Profile("new Amol in local variable", "Passwordnew"));

    profiles.get(0).password = "Amol i am the king";

    System.out.println("Configuration data check again..==> " + conf.toString());


  }
}

class Configuration {
  List<Profile> profiles;

  public Configuration() {
    profiles = new ArrayList<>();
    //This information is coming from secure place..
    profiles.add(new Profile("p1", "password1"));
    profiles.add(new Profile("p2", "password2"));
    profiles.add(new Profile("p3", "password3"));
  }

  List<Profile> getProfiles() {
    //return profiles;
    return profiles.stream()
      .map(x -> new Profile(x.name, x.password))
      .toList();
  }

  @Override
  public String toString() {
    return "Configuration{" +
      "profiles=" + profiles +
      '}';
  }
}

class Profile {
  public String name;
  public String password;

  public Profile() {
    this.name = "Default Name";
    this.password = "Default password";
  }

  public Profile(String name, String password) {
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Profile{" +
      "name='" + name + '\'' +
      ", password='" + password + '\'' +
      '}';
  }
}
