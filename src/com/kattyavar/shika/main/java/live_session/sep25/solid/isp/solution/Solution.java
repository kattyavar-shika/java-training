package com.kattyavar.shika.main.java.live_session.sep25.solid.isp.solution;

public class Solution {
}

interface Drivable {
  void start();
  void stop();
}

interface Flyable {
  void fly();
}

interface Sailable {
  void sail();
}


class Car implements Drivable {
  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }
}

class AirPlane implements Drivable, Flyable {
  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }

  @Override
  public void fly() {

  }
}

class Boat implements Drivable, Sailable {
  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }

  @Override
  public void sail() {

  }
}