package com.lmn.shop.test;

import java.util.HashMap;
import java.util.Map;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.infrastructure.repository.InMemoryProductRepository;

public class InMemoryProductRepositoryTest extends ProductRepositoryContract
{
  protected InMemoryProductRepository createProductRepository(Map.Entry<Barcode, Price> ... entries)
  {
    Map<Barcode, Price> products = new HashMap<>();
    for (Map.Entry<Barcode, Price> entry : entries)
    {
      products.put(entry.getKey(), entry.getValue());
    }
    return new InMemoryProductRepository(products);
  }
}
