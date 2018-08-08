package com.melkonyan.readfromfile;

import java.io.File;
import java.io.IOException;

public class ReadFromFile {
  public static void main(String[] args) throws IOException {
    final String modelString = "OneTwoTrip";
    final String errorMessage = "Impossible";

    FileUtil fileUtil = new FileUtil();
    File inputFile = new File("input.txt");

    String toFile = fileUtil.proceedToCharPositions(modelString, fileUtil.readDataFromFile(inputFile));

    fileUtil.writeDataIntoFile(toFile == null ? errorMessage : toFile);
  }
}
