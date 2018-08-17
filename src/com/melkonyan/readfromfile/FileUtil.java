package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil {
  private final String fileName = "output.txt";

  public FileUtil() {
  }

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

  public void writeDataIntoFile(@NotNull String data) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeDataIntoFile(List<String> data) {
    StringBuilder toFile = new StringBuilder();
    for (String item : data) {
      toFile.append(item);
    }
    writeDataIntoFile(toFile.toString());
  }


  /*
  Если M - кол-во строк входного файла, N - кол-во сиволов в каждой строе,
  то сложность алгоритма и расход паямяти будет: О(MxN + M) = O(MxN)
   */
  public List<String> proceedToCharPositions(@NotNull String modelString, @NotNull List<String> dataFromFile) {
    List<String> lettersWithCoordinates = new ArrayList<>();
    boolean isFoundChar = false;

    for (int k = 0; k < modelString.length(); k++) {
      isFoundChar = false;
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
          isFoundChar = true;
          break;
        }

        if ((i == dataFromFile.size() - 1) && (!isFoundChar)) {
          return null;
        }
      }
    }

    return isFoundChar ? lettersWithCoordinates : null;
  }
}
