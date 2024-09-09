package com.kattyavar.shika.main.java.live_session.sep9.lambdas;

public class LambdaWithThis {


   void display(Action action) {
    action.execute();
  }

  void letsUseWrapper(){
    display(() -> System.out.println(" I am working using lambda let try to print ths.." + this));
  }


  public static void main(String[] args) {
    LambdaWithThis obj = new LambdaWithThis();
    obj.display(new Action() {
      @Override
      public String toString() {
        return "anonymous Action{}";
      }
      @Override
      public void execute() {
        System.out.println(" printing this..." + this);
      }
    });

    //Lets use lambda ...
    //obj.display(() -> System.out.println(" I am working using lambda let try to print ths.." + this));

    obj.letsUseWrapper();
  }


}

