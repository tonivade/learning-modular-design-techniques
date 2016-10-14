package com.lmn.shop.domain.ports.primary;

import java.util.Optional;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.secondary.Display;
import com.lmn.shop.domain.ports.secondary.ProductRepository;

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
    Optional<Price> findPrice = products.findPrice(barcode);
    if (findPrice.isPresent())
    {
      display.printPrice(findPrice.get());
    }
    else
    {
      display.unknownProduct(barcode);
    }
  }
}
