package com.kattyavar.shika.main.java.live_session.extra.bytewritte;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class ProblemSG5Implementation {

  public void readLineByLine(final File pffFile) throws IOException {
    byte[] buffer = new byte[1024]; // Adjust buffer size as needed
    int bytesRead;
    System.out.println("File length = " + pffFile.length());

    try (FileInputStream fis = new FileInputStream(pffFile)) {

      while ((bytesRead = fis.read(buffer)) != -1) {
        // Process the data in the buffer
        // bytesRead tells how many bytes were read, which could be less than buffer.length
        System.out.println(new String(buffer, 0, bytesRead));
        System.out.println("Total byte read " + bytesRead);
      }

    }
  }

  public final List<Rock> readRecords(final File pffFile) throws IOException {
    List<Rock> rocks = new ArrayList<>();
    int soFarRead = 0;

    try (FileInputStream fis = new FileInputStream(pffFile)) {
      byte[] buffer = new byte[4];
      int bytesRead;

      while (true) {
        buffer = new byte[4];
        if ((bytesRead = fis.read(buffer)) == -1) {
          break;  // End of file
        }
        if (bytesRead == 1) {
          String lastChar = new String(buffer);

          System.out.println(" index of " + lastChar.indexOf('\r'));


          System.out.println("Let have look at the char [" + new String(buffer) + "]");
          if (lastChar.equals(new String("\n"))) {
            System.out.println("Yes we have \n as charter ");
          } else {
            System.out.println(" no \n charss");
          }
          break;
        }
        if (bytesRead < 4) {
          throw new IOException("Unexpected end of file while reading fixed-length fields.");
        }
        soFarRead = soFarRead + 4;
        String storageNumber = new String(buffer).trim();
        System.out.println(storageNumber);

        buffer = new byte[15];
        if (fis.read(buffer) < 15) {
          throw new IOException("Unexpected end of file while reading fixed-length fields.");
        }
        soFarRead = soFarRead + 15;
        String rockSpecies = new String(buffer).trim();

        buffer = new byte[8];

        if (fis.read(buffer) < 8) {
          throw new IOException("Unexpected end of file while reading fixed-length fields.");
        }
        soFarRead = soFarRead + 8;
        String weight = new String(buffer).trim();

        //Now let read the variable length length of description

        buffer = new byte[3];

        if (fis.read(buffer) < 3) {
          throw new IOException("Unexpected end of file while reading fixed-length fields.");
        }
        soFarRead = soFarRead + 3;
        int descriptionLen = Integer.parseInt(new String(buffer).trim());

        String description = "";
        if (descriptionLen > 0) {
          //Now read the description
          buffer = new byte[descriptionLen];

          soFarRead = soFarRead + descriptionLen;

          if (fis.read(buffer) < descriptionLen) {
            throw new IOException("Unexpected end of file while reading fixed-length fields.");
          }

          System.out.println("We need to descripition of lenght of " + descriptionLen);

          description = new String(buffer).trim();
        }

        rocks.add(new Rock(storageNumber, rockSpecies, weight, description));
      }
    }
    return rocks;
  }


}
