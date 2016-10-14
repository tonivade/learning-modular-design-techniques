package com.lmn.shop.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.secondary.ProductRepository;

public abstract class ProductRepositoryContract
{
  @Test
  public void productFound() throws Exception
  {
    ProductRepository productRepository = createProductRepository();

    Optional<Price> findPrice = productRepository.findPrice(new Barcode("11111"));

    assertThat(findPrice.get(), equalTo(Price.euros(100)));
  }

  @Test
  public void productNotFound() throws Exception
  {
    ProductRepository productRepository = createProductRepository();

    Optional<Price> findPrice = productRepository.findPrice(new Barcode("::not found::"));

    assertThat(findPrice.isPresent(), equalTo(false));
  }

  protected abstract ProductRepository createProductRepository();
}
