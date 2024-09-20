package com.kattyavar.shika.main.java.live_session.sep20;

public class SealedExample {

  public static void main(String[] args) {

    Account account = new Saving();
    makePayment(account);
  }

  static void makePayment(Account account) {
    account.makePayment();
  }
}

sealed class Account permits Saving, Current {
  void makePayment() {
    System.out.println("In Account");
  }

}

non-sealed class Saving extends Account {

  void makePayment() {
    System.out.println("In Saving");
  }

}

non-sealed class Current extends Account {
  void makePayment() {
    System.out.println("In Current");
  }
}

sealed interface IAccount permits ISaving, ICAccount {

}


non-sealed interface ISaving extends IAccount {

}


final class ICAccount implements IAccount {

}

















