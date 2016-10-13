package com.lmn.shop.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.lmn.shop.DisplayPriceUseCase;
import com.lmn.shop.Price;

public class DisplayPriceTest
{

  @Test
  public void test() throws Exception
  {
    DisplayPriceUseCase useCase = new DisplayPriceUseCase();

    Price price = useCase.execute("barcode");

    assertThat(price.getValue(), equalTo(20.0));
  }

}
