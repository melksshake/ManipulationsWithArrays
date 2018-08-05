package com.melkonyan.readfromfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
  public static void main(String[] args) throws IOException {
    File file = new File("D:\\PROGECTS\\IDEAProgects\\ManipulationsWithArrays\\src\\com\\melkonyan\\readfromfile\\input.txt");

    String data = dataFromFile(file);


  }

  private static String dataFromFile(File file) throws IOException {
    BufferedReader bufferedReader = null;
    String fromFile = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(file));

      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        stringBuilder.append(System.lineSeparator());
        line = bufferedReader.readLine();
      }
      fromFile = stringBuilder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      bufferedReader.close();
    }
//    System.out.print(fromFile);
    return fromFile;
  }
}
