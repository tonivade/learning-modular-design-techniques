package com.lmn.shop.infrastructure.entry;

import java.util.HashMap;
import java.util.Map;

import com.lmn.shop.domain.Barcode;
import com.lmn.shop.domain.Price;
import com.lmn.shop.domain.ports.primary.SaleMultipleProductsUseCase;
import com.lmn.shop.infrastructure.repository.ConsoleDisplay;
import com.lmn.shop.infrastructure.repository.InMemoryProductRepository;
import com.lmn.shop.infrastructure.repository.ScannerBarcodeReader;

public class PointOfSale
{
  @SuppressWarnings("serial")
  private static final Map<Barcode, Price> products = new HashMap<Barcode, Price>(){{
    put(new Barcode("11111"), Price.euros(100));
    put(new Barcode("22222"), Price.euros(200));
    put(new Barcode("33333"), Price.euros(300));
  }};

  public static void main(String[] args)
  {
    System.out.println("START");

    SaleMultipleProductsUseCase useCase =
        new SaleMultipleProductsUseCase(
            new ScannerBarcodeReader(System.in),
            new ConsoleDisplay(),
            new InMemoryProductRepository(products));

    useCase.execute();

    System.out.println("BYE");
  }
}
