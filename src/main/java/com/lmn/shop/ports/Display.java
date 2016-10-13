package com.lmn.shop.ports;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;

public interface Display
{
  void printPrice(Price price);

  void unknownProduct(Barcode barcode);
}
