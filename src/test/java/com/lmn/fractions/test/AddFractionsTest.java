package com.lmn.fractions.test;

import static com.lmn.fractions.Fraction.ONE;
import static com.lmn.fractions.Fraction.ZERO;
import static com.lmn.fractions.Fraction.fraction;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AddFractionsTest
{
  @Test
  public void zeroPlusZero()
  {
    assertThat(ZERO.plus(ZERO), equalTo(ZERO));
  }

  @Test
  public void sameDenominator()
  {
    assertThat(fraction(1, 2).plus(fraction(1, 2)), equalTo(ONE));
  }

  @Test
  public void oneIsOne()
  {
    assertThat(fraction(2, 2), equalTo(ONE));
  }

  @Test
  public void differentDenominator()
  {
    assertThat(fraction(1, 2).plus(fraction(1, 3)), equalTo(fraction(5, 6)));
  }

  @Test
  public void fractionPlusZero()
  {
    assertThat(fraction(1, 2).plus(ZERO), equalTo(fraction(1, 2)));
  }

  @Test
  public void zeroPlusFraction()
  {
    assertThat(ZERO.plus(fraction(1, 2)), equalTo(fraction(1, 2)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidFraction()
  {
    fraction(1, 0);
  }
}
