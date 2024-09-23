package com.kattyavar.shika.main.java.solid.srp;

import java.io.File;

public class WhySingleResponsibilityExample2 {
  public static void main(String[] args) {

  }

  //Example 1 ;

  class FileProcessing {

    //As you 3 reason to change this file.
    // What if we would like to save file to db, disk, in diff file format.
    //parse xml, json, binary file?
    //Download file

    public void downloadFile(File file) {

    }

    public void parseFile(File file) {

    }

    public void saveFile(File file) {

    }
  }

  //Example 2

}
