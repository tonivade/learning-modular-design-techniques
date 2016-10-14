package com.lmn.shop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.primary.SaleMultipleProductsUseCase;
import com.lmn.shop.ports.secondary.Display;
import com.lmn.shop.ports.secondary.ProductRepository;

public class SaleMultipleProductsTest
{
  private Display display = mock(Display.class);
  private ProductRepository products = mock(ProductRepository.class);

  @Test
  public void happyPath() throws Exception
  {
    SaleMultipleProductsUseCase useCase = new SaleMultipleProductsUseCase(display, products);

    useCase.execute();

    verify(display).printPrice(new Price(1.50, "EUR"));
    verify(display).printPrice(new Price(2.50, "EUR"));
    verify(display).printPrice(new Price(3.50, "EUR"));
    verify(display).printTotal(new Price(7.50, "EUR"));
  }

}
