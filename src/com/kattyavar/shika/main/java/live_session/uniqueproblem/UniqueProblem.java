package com.kattyavar.shika.main.java.live_session.uniqueproblem;

public class UniqueProblem {
    public static void main() {
        System.out.println("Even who will call this...???");
    }

    public static void main(String[] args) {
        /*
        //Step 1
        Derived derived = new Derived();
        System.out.println(derived.x);
        //Step 2
        Base base = new Base();
        System.out.println(base.x);
        //Step 3
        Base obj = new Derived();
        System.out.println(obj.x);
        obj.printMe();

         */
        Derived derived = new Derived();

        //Base.BaseInner obj = new Base().new BaseInner();
        Base.BaseInner obj = derived.new BaseInner();
        obj.display();

    }

    public static void main(String[] args, Integer abc) {
        System.out.println("I don't know who will call me ... save .. me..");

    }


}

class Base {
    private int x = 20;

    void printMe() {
        System.out.println("In Base printMe");
    }

    class BaseInner {
        int x = 50;

        void display() {
            System.out.println(x);
            System.out.println("Let get the Outer member variable of x ..." + Base.this.x);
        }


    }
}

class Derived extends Base {
    int x = 30;

    @Override
    void printMe() {
        System.out.println("Derived printMe");
    }

    public Derived() {
        //super.x = 100;
    }
}

