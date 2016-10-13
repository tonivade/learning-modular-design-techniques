package com.lmn.fractions.test;

import static com.lmn.fractions.Fraction.ONE;
import static com.lmn.fractions.Fraction.ZERO;
import static com.lmn.fractions.Fraction.fraction;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.lmn.fractions.Fraction;

public class AddFractionsTest
{
  @Test
  public void zeroPlusZero()
  {
    assertThat(ZERO.plus(ZERO), equalTo(ZERO));
  }

  @Test
  public void oneHalfPlusOneHalf()
  {
    Fraction oneHalf =  fraction(1, 2);

    assertThat(oneHalf.plus(oneHalf), equalTo(ONE));
  }

  @Test
  public void oneIsOne()
  {
    Fraction oneAlso = fraction(2, 2);

    assertThat(oneAlso.reduce(), equalTo(ONE));
  }

  @Test
  public void oneHavePlusOneThird()
  {
    Fraction oneHalf = fraction(1, 2);
    Fraction oneThird = fraction(1, 3);
    Fraction fiveOverSix = fraction(5, 6);

    assertThat(oneHalf.plus(oneThird), equalTo(fiveOverSix));
  }

  @Test
  public void oneHalfPlusZero()
  {
    Fraction oneHalf = fraction(1, 2);

    assertThat(oneHalf.plus(ZERO), equalTo(oneHalf));
  }

  @Test
  public void zeroPlusOneHalf()
  {
    Fraction oneHalf = fraction(1, 2);

    assertThat(ZERO.plus(oneHalf), equalTo(oneHalf));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidFraction()
  {
    fraction(1, 0);
  }
}
