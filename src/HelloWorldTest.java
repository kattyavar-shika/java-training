import com.kattyavar.shika.main.java.live_session.jan27.Test;

import java.lang.Object;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Scanner;

public class HelloWorldTest {

  public static void main(String[] args) {

    HumanPerson obj = new HumanPerson();

    Class cls = obj.getClass();

    //If i would like to all methods...

    for(Method method : cls.getDeclaredMethods()) {
      System.out.println("Method name -> " + method.getName());
    }

    Class superCls = cls.getSuperclass();

    System.out.println("Super class of HumanPerson is --> " + superCls.getName());

  }

}

class HumanPerson  {

  public String name;
  private String lastName;

  void display(){

  }

  void display(Integer inp){}


  private void testIfYouCanReadThis(){}


}


