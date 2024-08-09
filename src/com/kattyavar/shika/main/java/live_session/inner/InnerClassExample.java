package com.kattyavar.shika.main.java.live_session.inner;

public class InnerClassExample {

    class Inner {

        public  static void TestMe(){
            System.out.println("Inner static classs");
        }
    }

    public static void main(String[] args) {
        InnerClassExample.Inner obj= new InnerClassExample().new Inner();

        Inner.TestMe();

    }
}
