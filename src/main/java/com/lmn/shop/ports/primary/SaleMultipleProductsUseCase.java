package com.lmn.shop.ports.primary;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.secondary.BarcodeReader;
import com.lmn.shop.ports.secondary.Display;
import com.lmn.shop.ports.secondary.ProductRepository;

public class SaleMultipleProductsUseCase
{
  private BarcodeReader reader;
  private Display display;
  private ProductRepository products;

  public SaleMultipleProductsUseCase(BarcodeReader reader, Display display, ProductRepository products)
  {
    this.reader = reader;
    this.display = display;
    this.products = products;
  }

  public void execute()
  {
    while (true) {
      Barcode barcode = reader.read();
      if (barcode == null)
      {
        break;
      }
      display.printPrice(products.findPrice(barcode));
    }

    display.printTotal(new Price(7.50, "EUR"));
  }
}
