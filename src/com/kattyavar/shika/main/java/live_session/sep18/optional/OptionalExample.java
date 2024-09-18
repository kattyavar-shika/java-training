package com.kattyavar.shika.main.java.live_session.sep18.optional;

import java.util.Optional;

public class OptionalExample {
  public static void main(String[] args) {

    //OptionData data = new OptionData("Option 1");
    OptionData data = null;


    Optional<OptionData> op = Optional.ofNullable(data);
    //op.ifPresent();
    // op.isPresent() // is null or not ..
    // op.get()  you will get the actual object...
    OptionData optionData = op.orElse(new OptionData("in case of op is null"));
    //op.orElseThrow(() -> new RuntimeException(""));

    processData(data);

    System.out.println("Process with null data ");
    processData(Optional.ofNullable(data));

  }


  private Optional<OptionData> getTheStringData() {
    //We don't know this function will return actual string or null also..
    return null;
  }

  static void processData(Optional<OptionData> data) {

    if (data.isPresent() == true) {
      OptionData obj = data.get();
    }

    data.ifPresent(x -> System.out.println("Option data name ==> " + x.getName() + " "));
  }

  static void processData(OptionData data) {

    if (data != null) {
      System.out.println("Option data name ==> " + data.getName() + " ");
    }


  }
}

class OptionData {

  private String name;

  public OptionData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "OptionData{" +
      "name='" + name + '\'' +
      '}';
  }
}
