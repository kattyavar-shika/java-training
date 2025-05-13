package com.kattyavar.shika.main.java.live_session.may5.part2;

import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Controller controller = new Controller();

    //Service service = new Service();
    //controller.setService(service);

    //controller.service = new Service(); // all new obj creation should be done by someone else...

    injectService(controller);
   controller.run();
  }

  static  void injectService(Object obj) throws NoSuchFieldException, IllegalAccessException {

    Field service = obj.getClass().getDeclaredField("service");
    service.setAccessible(true);
    Service service1 = new Service();
    service.set(obj, service1);

  }
}

class Service {
  public void serve() {
    System.out.println("Service is running or working...");
  }
}

class Controller {
  public Service service;

  public void run() {
    service.serve(); //Using service ...
  }

  void setService(Service service) {
    this.service = service;
  }

}