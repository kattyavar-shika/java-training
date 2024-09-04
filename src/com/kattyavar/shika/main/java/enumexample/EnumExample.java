package com.kattyavar.shika.main.java.enumexample;

public class EnumExample {

  static void tryFindOutEnumParentClass() {
    Color color = Color.BlUE;

    Class<?> cls = color.getClass();

    System.out.println("Enum class parent is : " + cls.getSuperclass().getName());

  }

  static void usageWithExtraAttributeInEnum() {
    ColorWithPrice colorWithPrice = ColorWithPrice.BLUE;
    //Now let try to access this.
    System.out.println(" colorWithPrice = " + colorWithPrice);
    System.out.println(" colorWithPrice = " + colorWithPrice + " let check the Ordinal " + colorWithPrice.ordinal());

    //You can get the custom attribute also.

    System.out.println("Custom attribute as price =" + colorWithPrice.getPrice());
    colorWithPrice.setPrice(999);
    System.out.println("Custom attribute as price =" + colorWithPrice.getPrice());

    //Now let try to check..
    //This is happening bcoz every enum constant is public static final.
    //That why you get the 999 as output of below line.
    System.out.println("Price with Blue is " + ColorWithPrice.BLUE.getPrice());

  }

  static void findAllEnumsInEnum() {
    for (ColorWithPrice colorWithPrice : ColorWithPrice.values()) {
      System.out.println("Enum name =" + colorWithPrice.name() + " with out name =" + colorWithPrice + " ordinal =" + colorWithPrice.ordinal());

    }
  }

  static void exampleEnumWithMethod() {
    int x = 20;
    int y = 10;

    System.out.println("we have x =" + x + ", y=" + y);

    for (Operation operation : Operation.values()) {
      System.out.println(" Operation name =" + operation + " as return values is =" + operation.apply(x, y));
    }
  }

  public static void main(String[] args) {
    //tryFindOutEnumParentClass();
    //usageWithExtraAttributeInEnum();
    //findAllEnumsInEnum();
    exampleEnumWithMethod();

    //Note you can not extends any enum.
  }
}


//simple enum

interface Idemo {
  void display();
}

//Simple use case. Keep in mind super class of this class is java.lang.Enum
enum Color {
  RED,
  WHITE,
  BlUE
}

//You can have constructor and attribute to enum class

enum ColorWithPrice {
  //Note Ordinal start with 0, and jvm give this ordinal.
  RED(200),
  WHITE(300),
  BLUE(10);

  private Integer price;

  ColorWithPrice(Integer price) {
    this.price = price;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}

//As you can extends but you can implement the interface in enum
enum InterfaceImplEnmDemo implements Idemo {
  ENUM_VALUE1;

  @Override
  public void display() {

  }
}


//Enum with custom method
enum Operation {
  ADD {
    public int apply(int x, int y) {
      return x + y;
    }

  },
  SUBTRACT {
    public int apply(int x, int y) {
      return x - y;
    }
  };

  public abstract int apply(int x, int y);

}
