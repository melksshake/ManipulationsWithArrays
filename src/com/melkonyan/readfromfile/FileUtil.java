package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.*;

public final class FileUtil implements FileUtilMethods {

  public FileUtil() {
  }

  @Override
  public String readDataFromFile(@NotNull File file) throws IOException {
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
      if (bufferedReader != null) bufferedReader.close();
    }
//    System.out.print(fromFile);
    return fromFile;
  }

  @Override
  public void writeDataIntoFile(@NotNull String data) throws IOException {
    String str = "Hello";
    String fileName = "output";
    BufferedWriter writer = null;

    try {
      writer = new BufferedWriter(new FileWriter(fileName));
      writer.write(str);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) writer.close();
    }
  }
}
