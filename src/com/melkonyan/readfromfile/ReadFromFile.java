package com.melkonyan.readfromfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
  public static void main(String[] args) throws IOException {
    File file = new File("D:\\PROGECTS\\IDEAProgects\\ManipulationsWithArrays\\src\\com\\melkonyan\\readfromfile\\input.txt");
    FileUtil fileUtil = new FileUtil();

    List<String> dataFromFile = fileUtil.readDataFromFile(file);
    List<String> lettersWithCoordinates = new ArrayList<>();

    CharSequence modelString = "OneTwoTrip";

    for (int k = 0; k < modelString.length(); k++) {
      for (int i = 1; i < dataFromFile.size(); i++) {
        StringBuilder coordinates = new StringBuilder();
        if (dataFromFile.get(i).contains(String.valueOf(modelString.charAt(k)))) {
          coordinates
              .append(" ( ")
              .append(i)
              .append(", ")
              .append(dataFromFile.get(i).indexOf(String.valueOf(modelString.charAt(k))))
              .append(" )")
              .append("\n");
          lettersWithCoordinates.add(String.valueOf(modelString.charAt(k)) + coordinates);
          break;
        }
      }
    }

    StringBuilder toFile = new StringBuilder();
    for (String item : lettersWithCoordinates) {
      toFile.append(item);
    }

    fileUtil.writeDataIntoFile(toFile.toString());
  }

  /*
  String rowsAndColumns = dataFromFile.substring(0, dataFromFile.indexOf("\n"));
    String restData = dataFromFile.substring(rowsAndColumns.length(), dataFromFile.length());

    rowsAndColumns = rowsAndColumns.trim();
    int rows = Integer.parseInt(rowsAndColumns.substring(0, rowsAndColumns.indexOf(" ")));
    int columns = Integer.parseInt(rowsAndColumns.substring(rowsAndColumns.indexOf(" ")).trim());

    String[][] symbolsArray = new String[rows][columns];

    char[] charArray = restData.toCharArray();

    Scanner sc = new Scanner(restData).useDelimiter("\n");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        symbolsArray[i][j] = sc.next();
      }
      }
      */
}
