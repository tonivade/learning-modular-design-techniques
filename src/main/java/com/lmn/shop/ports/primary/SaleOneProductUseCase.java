package com.lmn.shop.ports.primary;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.ports.secondary.Display;
import com.lmn.shop.ports.secondary.ProductRepository;

public class SaleOneProductUseCase
{
  private Display display;
  private ProductRepository products;

  public SaleOneProductUseCase(Display display, ProductRepository products)
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
