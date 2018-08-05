package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileUtilMethods {
  List<String> readDataFromFile(@NotNull File file) throws IOException;
  void writeDataIntoFile(@NotNull String data) throws IOException;
}
