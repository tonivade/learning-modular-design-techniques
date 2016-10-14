package com.lmn.shop.domain;

public class Price
{
  private double value;
  private String currency;

  public Price(double value, String currency)
  {
    this.value = value;
    this.currency = currency;
  }

  @Override
  public String toString()
  {
    return "Price [" + currency + " " + value + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((currency == null) ? 0 : currency.hashCode());
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
    if (currency == null)
    {
      if (other.currency != null)
        return false;
    }
    else if (!currency.equals(other.currency))
      return false;
    if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
      return false;
    return true;
  }

  public Price plus(Price other)
  {
     return new Price(this.value + other.value, this.currency);
  }

}
