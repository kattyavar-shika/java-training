package com.kattyavar.shika.main.java.live_session.feb10;

public class Base {

  private String baseStr1Private;
  final public String baseStr1Public;
  final protected String baseStr1Protected;
  String baseStr1Default;

  public Base() {
    baseStr1Private = "Base private value ";
    baseStr1Public = " Base public value using final...";
    baseStr1Protected = "Base protected value";
    baseStr1Default = "Base default value";
  }
}