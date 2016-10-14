package com.lmn.shop.ports.secondary;

import com.lmn.shop.domain.Barcode;

public interface BarcodeReader
{
  Barcode read();
}
