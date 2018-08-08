package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil implements FileUtilMethods {
  private final String fileName = "output.txt";

  public FileUtil() {
  }

  @Override
  public List<String> readDataFromFile(@NotNull File file) {
    List<String> fileLines = new ArrayList<>();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String line = bufferedReader.readLine();

      while (line != null) {
        fileLines.add(line);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileLines;
  }

  @Override
  public void writeDataIntoFile(@NotNull String data) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String proceedToCharPositions(@NotNull String modelString, @NotNull List<String> dataFromFile) {
    StringBuilder toFile = new StringBuilder();
    List<String> lettersWithCoordinates = new ArrayList<>();

    for (int k = 0; k < modelString.length(); k++) {
      for (int i = 1; i < dataFromFile.size(); i++) {
        StringBuilder coordinates = new StringBuilder();
        String charAtCurrentPosition = String.valueOf(modelString.charAt(k));

        if (dataFromFile.get(i).contains(charAtCurrentPosition)) {
          coordinates
              .append(" ( ")
              .append(i)
              .append(", ")
              .append(dataFromFile.get(i).indexOf(charAtCurrentPosition))
              .append(" )")
              .append("\n");
          lettersWithCoordinates.add(charAtCurrentPosition + coordinates);
          break;
        }
      }
    }

    for (String item : lettersWithCoordinates) {
      toFile.append(item);
    }

    return toFile.toString();
  }
}
