package com.lmn.shop.domain.ports.secondary;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;

public interface Display
{
  void printPrice(Price price);

  void unknownProduct(Barcode barcode);

  void printTotal(Price price);
}
