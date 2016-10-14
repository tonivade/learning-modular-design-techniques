package com.lmn.shop.domain;

import com.lmn.shop.ports.Display;
import com.lmn.shop.ports.ProductRepository;

public class DisplayPriceUseCase
{
  private Display display;
  private ProductRepository products;

  public DisplayPriceUseCase(Display display, ProductRepository products)
  {
    this.display = display;
    this.products = products;
  }

  public void execute(Barcode barcode)
  {
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
