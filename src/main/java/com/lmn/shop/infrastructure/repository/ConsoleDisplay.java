package com.lmn.shop.infrastructure.repository;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.secondary.Display;

public class ConsoleDisplay implements Display
{
  @Override
  public void printPrice(Price price)
  {
    System.out.println(price);
  }

  @Override
  public void unknownProduct(Barcode barcode)
  {
    System.out.println("Unknown product: " + barcode);
  }

  @Override
  public void printTotal(Price price)
  {
    System.out.println("Total: " + price);
  }
}
