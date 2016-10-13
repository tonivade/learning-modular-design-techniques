package com.lmn.shop.test;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.DisplayPriceUseCase;
import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.BarcodeReader;
import com.lmn.shop.ports.Display;
import com.lmn.shop.ports.ProductRepository;

public class DisplayPriceTest
{
  private BarcodeReader reader = mock(BarcodeReader.class);
  private Display display = mock(Display.class);
  private ProductRepository products = mock(ProductRepository.class);

  private DisplayPriceUseCase useCase = new DisplayPriceUseCase(reader, display, products);

  @Test
  public void productExists()
  {
    String value = "01203002230";
    when(reader.read()).thenReturn(new Barcode(value));
    Price price = new Price(20.0, "EUR");
    when(products.findPrice(new Barcode(value))).thenReturn(price);

    useCase.execute();

    verify(display).printPrice(price);
  }

  @Test
  public void unknownProduct()
  {
    String value = "0102023233332";
    when(reader.read()).thenReturn(new Barcode(value));
    doThrow(RuntimeException.class).when(products).findPrice(new Barcode(value));

    useCase.execute();

    verify(display).unknownProduct(new Barcode(value));
  }
}
