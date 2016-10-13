package com.lmn.shop;

public interface ProductRepository
{
  Price findPrice(String barcode);
}
