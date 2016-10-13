package com.lmn.shop;

public class DisplayPriceUseCase
{
  private BarcodeReader reader;
  private Display display;
  private ProductRepository products;

  public DisplayPriceUseCase(BarcodeReader reader, Display display, ProductRepository products)
  {
    this.reader = reader;
    this.display = display;
    this.products = products;
  }

  public void execute()
  {
    Barcode barcode = reader.read();
    Price price = getPrice(barcode);
    display.printPrice(price);
  }

  private Price getPrice(Barcode barcode)
  {
    Price price = products.findPrice(barcode);
    if (price == null)
    {
      throw new RuntimeException();
    }
    return price;
  }
}
