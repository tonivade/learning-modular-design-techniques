package com.lmn.shop.ports.secondary;

import java.util.Optional;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;

public interface ProductRepository
{
  Optional<Price> findPrice(Barcode barcode);
}
