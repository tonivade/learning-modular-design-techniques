package com.lmn.shop;

import java.util.HashMap;
import java.util.Map;

public class DisplayPriceUseCase
{
  private BarcodeReader reader;
  private Display display;

  private Map<String, Price> products = new HashMap<String, Price>(){{
    put("barcode", new Price(20.0));
  }};

  public DisplayPriceUseCase(BarcodeReader reader, Display display)
  {
    this.reader = reader;
    this.display = display;
  }

  public void execute()
  {
    String barcode = reader.read();
    Price price = getPrice(barcode);
    display.printPrice(price);
  }

  private Price getPrice(String barcode)
  {
    Price price = products.get(barcode);
    if (price == null)
    {
      throw new RuntimeException();
    }
    return price;
  }
}
