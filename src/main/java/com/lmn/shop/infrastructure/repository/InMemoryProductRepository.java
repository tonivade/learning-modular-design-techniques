package com.lmn.shop.infrastructure.repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.secondary.ProductRepository;

public class InMemoryProductRepository implements ProductRepository
{
  private Map<Barcode, Price> products;

  public InMemoryProductRepository(Map<Barcode, Price> products)
  {
    this.products = Objects.requireNonNull(products);
  }

  @Override
  public Optional<Price> findPrice(Barcode barcode)
  {
    return Optional.ofNullable(products.get(barcode));
  }
}
