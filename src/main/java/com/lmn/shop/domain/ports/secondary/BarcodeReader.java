package com.lmn.shop.domain.ports.secondary;

import com.lmn.shop.domain.Barcode;

public interface BarcodeReader
{
  Barcode read();
}
