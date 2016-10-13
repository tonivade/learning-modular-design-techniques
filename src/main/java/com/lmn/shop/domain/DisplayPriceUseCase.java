package com.lmn.shop.domain;

import com.lmn.shop.ports.BarcodeReader;
import com.lmn.shop.ports.Display;
import com.lmn.shop.ports.ProductRepository;

public class DisplayPriceUseCase
{
  private BarcodeReader reader;
  private Display display;
  private ProductRepository products;

  public DisplayPriceUseCase(BarcodeReader reader, Display display, ProductRepository products)
  {
    this.reader = reader;
    this.display = display;
    this.products = products;
  }

  public void execute()
  {
    Barcode barcode = reader.read();
    try
    {
      display.printPrice(products.findPrice(barcode));
    }
    catch (RuntimeException e)
    {
      display.unknownProduct(barcode);
    }
  }
}
