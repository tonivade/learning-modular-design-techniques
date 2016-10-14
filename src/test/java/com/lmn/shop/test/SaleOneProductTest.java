package com.lmn.shop.test;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.SaleOneProductUseCase;
import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.Display;
import com.lmn.shop.ports.ProductRepository;

public class SaleOneProductTest
{
  private Display display = mock(Display.class);
  private ProductRepository products = mock(ProductRepository.class);

  private SaleOneProductUseCase useCase = new SaleOneProductUseCase(display, products);

  @Test
  public void productExists()
  {
    String value = "01203002230";
    Price price = new Price(20.0, "EUR");
    when(products.findPrice(new Barcode(value))).thenReturn(price);

    useCase.execute(new Barcode(value));

    verify(display).printPrice(price);
  }

  @Test
  public void unknownProduct()
  {
    String value = "0102023233332";
    doThrow(RuntimeException.class).when(products).findPrice(new Barcode(value));

    useCase.execute(new Barcode(value));

    verify(display).unknownProduct(new Barcode(value));
  }
}
