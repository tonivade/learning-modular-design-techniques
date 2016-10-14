package com.lmn.shop.ports.primary;

import java.util.Optional;

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
    Price total = new Price(0, "EUR");
    while (true) {
      Barcode barcode = reader.read();
      if (barcode == null)
      {
        break;
      }
      total = sell(total, barcode);
    }

    display.printTotal(total);
  }

  private Price sell(Price total, Barcode barcode)
  {
    Optional<Price> findPrice = products.findPrice(barcode);
    if (findPrice.isPresent())
    {
      display.printPrice(findPrice.get());
      total = total.plus(findPrice.get());
    }
    else
    {
      display.unknownProduct(barcode);
    }
    return total;
  }
}
