package com.lmn.shop.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.secondary.ProductRepository;

public abstract class ProductRepositoryContract
{
  private final SimpleEntry<Barcode, Price> entry = new SimpleEntry<>(new Barcode("11111"), Price.euros(100));

  @Test
  public void productFound() throws Exception
  {
    ProductRepository productRepository = createProductRepository(entry);

    Optional<Price> findPrice = productRepository.findPrice(new Barcode("11111"));

    assertThat(findPrice.get(), equalTo(Price.euros(100)));
  }

  @Test
  public void productNotFound() throws Exception
  {
    ProductRepository productRepository = createProductRepository(entry);

    Optional<Price> findPrice = productRepository.findPrice(new Barcode("::not found::"));

    assertThat(findPrice.isPresent(), equalTo(false));
  }

  protected abstract ProductRepository createProductRepository(Map.Entry<Barcode, Price> ... entries);
}
