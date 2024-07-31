package com.kattyavar.shika.main.java.live_session.abstract_example;

import java.io.File;

public class AbstractClassDemoExample {
    public static void main(String[] args) {
        AbsDemo obj = new AbsDemo() {
            @Override
            public String loadFile() {
                System.out.println("In A..loadFile()");
                return "";
            }

            @Override
            public String loadConfig() {
                System.out.println("in A...loadConfig");
                return "";
            }

            @Override
            public String loadDbConfig() {
                System.out.println("In A...loadDbConfig");
                return "";
            }
        };

        AbsDemo obj2 = new AbsDemo() {
            @Override
            public String loadFile() {
                System.out.println("In A..loadFile()");
                return "";
            }

            @Override
            public String loadConfig() {
                System.out.println("in A...loadConfig");
                return "";
            }

            @Override
            public String loadDbConfig() {
                System.out.println("In A...loadDbConfig");
                return "";
            }
        };
        obj.loadFile();
        obj.loadConfig();
        obj.loadDbConfig();


        System.out.println(obj);
    }
}

class BaseExample {
    private String name;
    public BaseExample() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


abstract class AbsDemo  {

    abstract public String loadFile();
    abstract public String loadConfig();
    abstract public String loadDbConfig();

    private String getName(){
        System.out.println("In getName");
        return "empty";
    }

    public String getName(String name){
        return name;
    }

    protected String getName (Integer input){
        return null;
    }

    public static  String getPatil() {
        return "Patil";
    }
}





abstract class Patil extends AbsDemo {
    @Override
    public String loadFile() {
        return "";
    }
}

class ABSIMPL extends Patil {
    @Override
    public String loadFile() {
        //give you implemenation ...
        return null;
    }

    @Override
    public String loadConfig() {
        return "";
    }

    @Override
    public String loadDbConfig() {
        return "";
    }
}


abstract class AbstractClassExample {

    private String name;
    private String CollegeName;
    private String lastName;

    public AbstractClassExample() {
    }

    public AbstractClassExample(String name, String collegeName, String lastName) {
        this.name = name;
        CollegeName = collegeName;
        this.lastName = lastName;
    }

    abstract String getName();

    abstract String getCollegeName();

    abstract File loadClassFile();


    abstract Boolean loadData();

}