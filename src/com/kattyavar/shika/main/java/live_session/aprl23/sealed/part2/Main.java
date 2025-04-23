package com.kattyavar.shika.main.java.live_session.aprl23.sealed.part2;

public class Main {

  public static void main(String[] args) {

  }
}


sealed class MyClass permits MySubClass {

}

non-sealed class MySubClass extends  MyClass {

}


class MySubSubClass extends  MySubClass {

}

class Temp extends MySubClass{

}




// A = B and B = C ~~ A=C