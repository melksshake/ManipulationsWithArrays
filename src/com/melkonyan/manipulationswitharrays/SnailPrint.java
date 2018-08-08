package com.melkonyan.manipulationswitharrays;

import com.sun.istack.internal.NotNull;

import java.security.SecureRandom;

public final class SnailPrint implements ArrayMethods {
  private final int RANDOM_BOUND = 100;

  private int arraySize;
  private int localArray[][];

  public SnailPrint(@NotNull int arraySize) {
    this.arraySize = arraySize;
    localArray = new int[arraySize][arraySize];
  }

  @Override
  public int[][] initArrayWithResult() {
    if (localArray == null) throw new NullPointerException("Array is empty");
    return localArray;
  }

  @Override
  public void initArray() {
    SecureRandom src = new SecureRandom();

    for (int i = 0; i < arraySize; i++) {
      for (int j = 0; j < arraySize; j++) {
        int random = 1 + src.nextInt(RANDOM_BOUND);
        localArray[i][j] = random;
      }
    }
  }

  @Override
  public void printArray() {
    System.out.print("\nArray before manipulations: \n");
    for (int i = 0; i < localArray.length; i++) {
      for (int j = 0; j < localArray.length; j++) {
        System.out.print(localArray[i][j] + "[" + i + j + "] " + "\t");
      }
      System.out.println();
    }
  }

  @Override
  public void printSpiral() {
    printSpiral(localArray);
  }

  private void printSpiral(int[][] array) {
    int central = (int) Math.floor(array[0].length / 2.0);

    int iterations = central + 1; // central + 1 -> for printing last line
    int column = central;
    int row = central;

    int stepsToGoLeft = 1;
    int stepsToGoDown = 1;
    int stepsToGoRight = 2;
    int stepsToGoUp = 2;

    System.out.print("\nSnail printing: \n");
    for (int i = 1; i <= iterations; i++) {
      for (int k = 0; k < stepsToGoLeft; k++) { // going left
          System.out.print(array[row][column] + " " + "[" + row + column + "] ");
          column--;
      }

      if (row == 0 && column == -1) break; // we finished

      for (int k = 0; k < stepsToGoDown; k++) { // going down
        System.out.print(array[row][column] + " " + "[" + row + column + "] ");
        row++;
      }

      for (int k = 0; k < stepsToGoRight; k++) { // going right
        System.out.print(array[row][column] + " " + "[" + row + column + "] ");
        column++;
      }

      for (int k = 0; k < stepsToGoUp; k++) { // going up
        System.out.print(array[row][column] + " " + "[" + row + column + "] ");
        row--;
      }

      stepsToGoLeft += 2;
      stepsToGoDown += 2;
      stepsToGoRight += 2;
      stepsToGoUp += 2;
    }
    System.out.print("\nDone");
  }
}
