package com.kattyavar.shika.main.java.live_session.aprl23.sealed.part3;

public class Main {
  public static void main(String[] args) {
    //area(new Square(11));
  }

  public static double area(Shape shape) {
    return switch (shape) {
      case Circle c -> Math.PI * c.radius() * c.radius();
      case Square s -> s.side() * s.side();
    };
  }
}


sealed interface Shape permits Circle, Square {}

record Circle(double radius) implements Shape {}
record Square(double side) implements Shape {}