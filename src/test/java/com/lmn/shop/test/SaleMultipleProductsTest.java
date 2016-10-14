package com.lmn.shop.test;

import static com.lmn.shop.domain.Price.euros;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.ports.primary.SaleMultipleProductsUseCase;
import com.lmn.shop.domain.ports.secondary.BarcodeReader;
import com.lmn.shop.domain.ports.secondary.Display;
import com.lmn.shop.domain.ports.secondary.ProductRepository;

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
    when(products.findPrice(new Barcode("11111"))).thenReturn(Optional.of(euros(150)));
    when(products.findPrice(new Barcode("22222"))).thenReturn(Optional.of(euros(250)));
    when(products.findPrice(new Barcode("33333"))).thenReturn(Optional.of(euros(350)));

    useCase.execute();

    verify(display).printPrice(euros(150));
    verify(display).printPrice(euros(250));
    verify(display).printPrice(euros(350));
    verify(display).printTotal(euros(750));
  }

  @Test
  public void sellMultipleProductsButOneNotExists() throws Exception
  {
    when(reader.read())
        .thenReturn(new Barcode("11111"))
        .thenReturn(new Barcode("22222"))
        .thenReturn(new Barcode("33333"))
        .thenReturn(null);
    when(products.findPrice(new Barcode("11111"))).thenReturn(Optional.of(euros(150)));
    when(products.findPrice(new Barcode("22222"))).thenReturn(Optional.empty());
    when(products.findPrice(new Barcode("33333"))).thenReturn(Optional.of(euros(350)));

    useCase.execute();

    verify(display).printPrice(euros(150));
    verify(display).unknownProduct(new Barcode("22222"));
    verify(display).printPrice(euros(350));
    verify(display).printTotal(euros(500));
  }

  @Test
  public void sellOneProduct() throws Exception
  {
    when(reader.read())
      .thenReturn(new Barcode("11111"))
      .thenReturn(null);
    when(products.findPrice(new Barcode("11111"))).thenReturn(Optional.of(euros(150)));

    useCase.execute();

    verify(display).printPrice(euros(150));
    verify(display).printTotal(euros(150));
  }
}
