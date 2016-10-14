package com.lmn.shop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.ports.primary.SaleMultipleProductsUseCase;
import com.lmn.shop.ports.secondary.BarcodeReader;
import com.lmn.shop.ports.secondary.Display;
import com.lmn.shop.ports.secondary.ProductRepository;

public class SaleMultipleProductsTest
{
  private Display display = mock(Display.class);
  private ProductRepository products = mock(ProductRepository.class);
  private BarcodeReader reader = mock(BarcodeReader.class);

  private SaleMultipleProductsUseCase useCase = new SaleMultipleProductsUseCase(reader, display, products);

  @Test
  public void sellMultipleProducts() throws Exception
  {
    when(reader.read()).thenReturn(new Barcode("11111"), new Barcode("22222"), new Barcode("33333"), null);
    when(products.findPrice(new Barcode("11111"))).thenReturn(new Price(150, "EUR"));
    when(products.findPrice(new Barcode("22222"))).thenReturn(new Price(250, "EUR"));
    when(products.findPrice(new Barcode("33333"))).thenReturn(new Price(350, "EUR"));

    useCase.execute();

    verify(display).printPrice(new Price(150, "EUR"));
    verify(display).printPrice(new Price(250, "EUR"));
    verify(display).printPrice(new Price(350, "EUR"));
    verify(display).printTotal(new Price(750, "EUR"));
  }

  @Test
  public void sellMultipleProductsButOneNotExists() throws Exception
  {
    when(reader.read())
        .thenReturn(new Barcode("11111"))
        .thenReturn(new Barcode("22222"))
        .thenReturn(new Barcode("33333"))
        .thenReturn(null);
    when(products.findPrice(new Barcode("11111"))).thenReturn(new Price(150, "EUR"));
    when(products.findPrice(new Barcode("22222"))).thenThrow(RuntimeException.class);
    when(products.findPrice(new Barcode("33333"))).thenReturn(new Price(350, "EUR"));

    useCase.execute();

    verify(display).printPrice(new Price(150, "EUR"));
    verify(display).unknownProduct(new Barcode("22222"));
    verify(display).printPrice(new Price(350, "EUR"));
    verify(display).printTotal(new Price(500, "EUR"));
  }

  @Test
  public void sellOneProduct() throws Exception
  {
    when(reader.read())
      .thenReturn(new Barcode("11111"))
      .thenReturn(null);
    when(products.findPrice(new Barcode("11111"))).thenReturn(new Price(150, "EUR"));

    useCase.execute();

    verify(display).printPrice(new Price(150, "EUR"));
    verify(display).printTotal(new Price(150, "EUR"));
  }
}
