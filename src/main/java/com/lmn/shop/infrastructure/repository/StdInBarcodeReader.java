package com.lmn.shop.infrastructure.repository;

import java.util.Scanner;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.ports.secondary.BarcodeReader;

public class StdInBarcodeReader implements BarcodeReader
{
  private Scanner scanner = new Scanner(System.in);

  @Override
  public Barcode read()
  {
    String line = scanner.nextLine();
    return line != null && !line.isEmpty() ? new Barcode(line) : null;
  }
}
