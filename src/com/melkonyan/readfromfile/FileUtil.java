package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil implements FileUtilMethods {

  public FileUtil() {
  }

  @Override
  public List<String> readDataFromFile(@NotNull File file) throws IOException {
    BufferedReader bufferedReader = null;
    List<String> fileLines = new ArrayList<>();

    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      String line = bufferedReader.readLine();

      while (line != null) {
        fileLines.add(line);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bufferedReader != null) bufferedReader.close();
    }

    return fileLines;
  }

  @Override
  public void writeDataIntoFile(@NotNull String data) throws IOException {
    String fileName = "output";
    BufferedWriter writer = null;

    try {
      writer = new BufferedWriter(new FileWriter(fileName));
      writer.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) writer.close();
    }
  }
}
