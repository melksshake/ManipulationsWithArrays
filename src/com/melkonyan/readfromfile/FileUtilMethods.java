package com.melkonyan.readfromfile;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.File;
import java.util.List;

public interface FileUtilMethods {
  List<String> readDataFromFile(@NotNull File file);
  void writeDataIntoFile(@NotNull String data);
  @Nullable String proceedToCharPositions(@NotNull String modelString, @NotNull List<String> dataFromFile);
}
