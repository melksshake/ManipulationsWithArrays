package com.melkonyan.readfromfile;

import java.io.File;
import java.util.List;

public class ReadFromFile {
  public static void main(String[] args) {
    final String modelString = "OneTwoTrip";
    final String errorMessage = "Impossible";

    FileUtil fileUtil = new FileUtil();
    File inputFile = new File("input.txt");

    List<String> toFile = fileUtil.proceedToCharPositions(modelString, fileUtil.readDataFromFile(inputFile));
    if (toFile == null) {
      fileUtil.writeDataIntoFile(errorMessage);
    } else {
      fileUtil.writeDataIntoFile(toFile);
    }
  }
}
