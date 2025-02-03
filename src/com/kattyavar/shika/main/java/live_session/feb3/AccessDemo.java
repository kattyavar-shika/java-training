package com.kattyavar.shika.main.java.live_session.feb3;

import com.kattyavar.shika.main.java.live_session.feb3.underfeb3.Employee;
import com.kattyavar.shika.main.java.live_session.feb3.pc1.Harendra;
import java.util.*;

public class AccessDemo {
  public static void main(String[] args) {


    Harendra harendra = new Harendra();
    com.kattyavar.shika.main.java.live_session.feb3.pc2.Harendra harendra2 = new com.kattyavar.shika.main.java.live_session.feb3.pc2.Harendra();



    Employee employee = new Employee(); // 9 th flore

    //Not allowed // 8 th compile time error...
   //System.out.println(employee.privateName);
    //Allowed
    System.out.println(employee.publicLastname);
    //Not Allowed
    //System.out.println(employee.protectedSalary);

    //Not allowed...
    //System.out.println(employee.defaultAccessAge);


    //Let play with Student in same package...

    // 8th you trying to access it 8th
    Student student = new Student();
    //Not Allowed...
    //System.out.println(student.privateName);

    //Allowed
    System.out.println(student.publicLastname);

    //Allowed
    System.out.println(student.protectedSalary);

    //Allowed
    System.out.println(student.defaultAccessAge);

  }
}




