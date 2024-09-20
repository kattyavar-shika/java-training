package com.kattyavar.shika.main.java.recordandsealed;

public class SealedClassExample {
  public static void main(String[] args) {

    AccountType accountType = new MyAccount();
    testMe(accountType);
  }

  static void testMe(AccountType accountType) {
    accountType.withdraw();
  }
}


//In case of class we have 3 options.
//sealed, non-sealed and final.

//In case of interface we have only two options.
//sealed and non-sealed

sealed interface IAccountType permits ISaving, CSaving {

}

non-sealed interface ISaving extends IAccountType {

}

final class CSaving implements IAccountType {

}


sealed class AccountType permits Saving, Current {

  void withdraw() {
    System.out.println("From account Type");
  }
}

non-sealed class Saving extends AccountType {
  @Override
  void withdraw() {
    System.out.println("From Saving ...");
  }
}

final class Current extends AccountType {

}


class MyAccount extends Saving {
  @Override
  void withdraw() {
    System.out.println("from my account");
  }
}