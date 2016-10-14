package com.lmn.shop.test;

import java.util.HashMap;
import java.util.Map;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.infrastructure.repository.InMemoryProductRepository;

public class InMemoryProductRepositoryTest extends ProductRepositoryContract
{
  @SuppressWarnings("serial")
  private final Map<Barcode, Price> products = new HashMap<Barcode, Price>(){{
    put(new Barcode("11111"), Price.euros(100));
    put(new Barcode("22222"), Price.euros(200));
    put(new Barcode("33333"), Price.euros(300));
  }};

  protected InMemoryProductRepository createProductRepository()
  {
    return new InMemoryProductRepository(products);
  }
}
