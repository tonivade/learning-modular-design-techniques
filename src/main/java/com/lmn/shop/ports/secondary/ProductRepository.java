package com.lmn.shop.ports.secondary;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;

public interface ProductRepository
{
  Price findPrice(Barcode barcode);
}
