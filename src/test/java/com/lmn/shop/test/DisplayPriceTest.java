package com.lmn.shop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmn.shop.BarcodeReader;
import com.lmn.shop.Display;
import com.lmn.shop.DisplayPriceUseCase;
import com.lmn.shop.Price;

public class DisplayPriceTest
{
  private BarcodeReader reader = mock(BarcodeReader.class);
  private Display display = mock(Display.class);

  private DisplayPriceUseCase useCase = new DisplayPriceUseCase(reader, display);

  @Test
  public void productExists()
  {
    when(reader.read()).thenReturn("barcode");

    useCase.execute();

    verify(display).printPrice(new Price(20.0));
  }

  @Test(expected = RuntimeException.class)
  public void unknownProduct()
  {
    when(reader.read()).thenReturn("unknown");

    useCase.execute();
  }
}
