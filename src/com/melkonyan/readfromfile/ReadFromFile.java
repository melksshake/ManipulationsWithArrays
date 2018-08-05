package com.melkonyan.readfromfile;

import java.io.File;
import java.io.IOException;

public class ReadFromFile {
  public static void main(String[] args) throws IOException {
    File file = new File("D:\\PROGECTS\\IDEAProgects\\ManipulationsWithArrays\\src\\com\\melkonyan\\readfromfile\\input.txt");
    FileUtil fileUtil = new FileUtil();

    String data = fileUtil.readDataFromFile(file);

    fileUtil.writeDataIntoFile(data);
  }
}
