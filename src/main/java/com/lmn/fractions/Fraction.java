package com.lmn.fractions;

public class Fraction
{
  public static final Fraction ONE = fraction(1);
  public static final Fraction ZERO = fraction(0, 1);

  private final int numerator;
  private final int denominator;

  public Fraction(int numerator, int denominator)
  {
    this.numerator = numerator;
    this.denominator = denominator;
    check();
  }

  public Fraction plus(Fraction other)
  {
    return new Fraction(calculateNumerator(other), calculateDenominator(other)).reduce();
  }

  public Fraction reduce()
  {
    int gcm = greaterCommonDenominator(this.numerator, this.denominator);
    return new Fraction(this.numerator / gcm, this.denominator / gcm);
  }

  public static Fraction fraction(int numerator)
  {
    return new Fraction(numerator, 1);
  }

  public static Fraction fraction(int numerator, int denominator)
  {
    return new Fraction(numerator, denominator);
  }

  private int calculateDenominator(Fraction other)
  {
    return this.denominator * other.denominator;
  }

  private int calculateNumerator(Fraction other)
  {
    return (this.numerator * other.denominator) + (other.numerator * this.denominator);
  }

  private static int greaterCommonDenominator(int a, int b)
  {
    return b == 0 ? a : greaterCommonDenominator(b, a % b); // Not bad for one line of code :)
  }

  private void check()
  {
    if (this.denominator <= 0)
    {
      throw new IllegalArgumentException("invalid value: " + this);
    }
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + denominator;
    result = prime * result + numerator;
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Fraction other = (Fraction) obj;
    if (denominator != other.denominator)
      return false;
    if (numerator != other.numerator)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return String.format("[%d / %d]", numerator, denominator);
  }
}
