package com.kattyavar.shika.main.java.live_session.interface_example.why;

public class WhyWeNeedInterface {

    public static void connectToDb(InterFAceName dbObject) {
        if (dbObject.isConnected() == Boolean.FALSE) {
            dbObject.connect();
        }
        String query = "Select * from Customer";
        dbObject.executeQuery(query);
        dbObject.disconnect();
    }




    public static void main(String[] args) {

        InterFAceName interFAceName = new OracleDataConnect();
        connectToDb(interFAceName);
        if (interFAceName instanceof LoadFileFromNetwork) {
            System.out.println("Yes we can cast it...");
            LoadFileFromNetwork loadFileFromNetwork = (LoadFileFromNetwork) interFAceName;
            loadFileFromNetwork.loadNetworkFile();
        }
    }
}

interface LoadFiles {
    abstract public void loadFile();
}

interface LoadFileFromNetwork {

    abstract void loadNetworkFile();
}

interface InterFAceName {

    //If you define any variable in interface by default it static final...
     String name = "Patil";
     void connect();

     Boolean isConnected();

     void disconnect();

     void executeQuery(String query);

     //Introduced in java 8 onwards... only...
     default void getName(){
         System.out.println("WE can give the implementation in interface using default keyword...");
     }

     default void getAnotherName() {
         System.out.println("WE can n number of default methods...");
    }

    static void getConfig(){
        //Here you can put the helper function as part of Interface...
    }

}

interface FunctionInterFaceDemo {

    //If you have only one abstract method then it call as function interface.
    void connect();

    //Introduced in java 8 onwards... only...
    default void getName(){
        System.out.println("WE can give the implementation in interface using default keyword...");
    }

    default void getAnotherName() {
        System.out.println("WE can n number of default methods...");
   }
   //We can overload the default method in interface...
    default void getAnotherName(String name) {
        System.out.println("WE can n number of default methods...");
    }

   private void yesWeCanDefinePrivateMethodJava9Onwards(){
        //you can give the implementation over here...
       // This will be private to interface only...
   }

   static void getConfig(){
        //Here you can put the helper function as part of Interface...
   }
}

interface MarkerInterfaceExampl {
    //This interface will not have any method or member variables...
}

abstract class DBManager {
    abstract void connect();

    abstract Boolean isConnected();

    abstract void disconnect();

    abstract void executeQuery(String query);

    public String getName () {
        //I can add any implementation..
        return "Yes we can";
    }

    public DBManager() {
    }
}


class OracleDataConnect implements InterFAceName, LoadFileFromNetwork, LoadFiles {
    private Boolean isConnectedToDd;

    public void connect() {
        if (isConnectedToDd == Boolean.FALSE) {
            isConnectedToDd = Boolean.TRUE;
            System.out.println("Connected to oracle db ...");
        } else {
            System.out.println("All ready connecdted to DB nothing to do...");
        }
    }

    public Boolean isConnected() {
        return isConnectedToDd;
    }

    public void disconnect() {
        System.out.println("Disconnect to oracle db");
        isConnectedToDd = Boolean.FALSE;
    }

    public void executeQuery(String query) {
        System.out.println("Lets execute this query " + query + " to mysql db...");
    }

    @Override
    public void loadNetworkFile() {

    }

    @Override
    public void loadFile() {

    }
}

class MySqlDataConnect extends DBManager {
    private Boolean isConnectedToDb;

    public void connect() {
        System.out.println("Connected to Mysql db");
        isConnectedToDb = true;
    }

    public void disconnect() {
        System.out.println("Closing the connection of mysql db");
        isConnectedToDb = false;
    }

    public void executeQuery(String query) {
        System.out.println("Lets execute this query " + query + " to mysql db...");
    }

    public Boolean isConnected() {
        return isConnectedToDb;
    }
}
