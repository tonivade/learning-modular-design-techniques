package com.lmn.shop.domain;

public class Price
{
  private double value;

  public Price(double value)
  {
    this.value = value;
  }

  public double getValue()
  {
    return value;
  }

  @Override
  public String toString()
  {
    return "Price [value=" + value + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    long temp = Double.doubleToLongBits(value);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Price other = (Price) obj;
    if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
      return false;
    return true;
  }
}
