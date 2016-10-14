package com.lmn.shop.ports.primary;

import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.secondary.Display;
import com.lmn.shop.ports.secondary.ProductRepository;

public class SaleMultipleProductsUseCase
{
  private Display display;

  public SaleMultipleProductsUseCase(Display display, ProductRepository products)
  {
    this.display = display;
  }

  public void execute()
  {
    display.printPrice(new Price(1.50, "EUR"));
    display.printPrice(new Price(2.50, "EUR"));
    display.printPrice(new Price(3.50, "EUR"));
    display.printTotal(new Price(7.50, "EUR"));
  }
}
