package com.lmn.shop.infrastructure.repository;

import java.io.InputStream;
import java.util.Scanner;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.ports.secondary.BarcodeReader;

public class ScannerBarcodeReader implements BarcodeReader
{
  private Scanner scanner;

  public ScannerBarcodeReader(InputStream in)
  {
    this.scanner = new Scanner(in);
  }

  @Override
  public Barcode read()
  {
    String line = scanner.nextLine();
    return line != null && !line.isEmpty() ? new Barcode(line) : null;
  }
}
