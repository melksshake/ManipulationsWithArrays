package com.melkonyan.manipulationswitharrays;

import java.util.Scanner;

public class SpiralOutput {
  public static void main(String[] args) {
    String input;
    int size;

    do {
      System.out.print("Please, enter an 'n' (must be a digit)\n");
      Scanner scanner = new Scanner(System.in);
      input = scanner.nextLine();
    } while (!input.matches("[0-9]+"));

    size = 2 * Integer.parseInt(input) - 1;

    SnailPrint snailPrint = new SnailPrint(size);
    snailPrint.initArray();
    snailPrint.printArray();
    snailPrint.printSpiral();
  }
}
