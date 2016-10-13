package com.lmn.shop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmn.shop.BarcodeReader;
import com.lmn.shop.Display;
import com.lmn.shop.DisplayPriceUseCase;
import com.lmn.shop.Price;
import com.lmn.shop.ProductRepository;

public class DisplayPriceTest
{
  private BarcodeReader reader = mock(BarcodeReader.class);
  private Display display = mock(Display.class);
  private ProductRepository products = mock(ProductRepository.class);

  private DisplayPriceUseCase useCase = new DisplayPriceUseCase(reader, display, products);

  @Test
  public void productExists()
  {
    when(products.findPrice("barcode")).thenReturn(new Price(20.0));
    when(reader.read()).thenReturn("barcode");

    useCase.execute();

    verify(display).printPrice(new Price(20.0));
  }

  @Test(expected = RuntimeException.class)
  public void unknownProduct()
  {
    when(reader.read()).thenReturn("barcode");

    useCase.execute();
  }
}
