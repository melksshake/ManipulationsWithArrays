package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.IOException;

public interface FileUtilMethods {
  String readDataFromFile(@NotNull File file) throws IOException;
  void writeDataIntoFile(@NotNull String data) throws IOException;
}
