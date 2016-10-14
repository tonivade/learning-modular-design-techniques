package com.lmn.shop.domain;

public class Price
{
  private final int value;
  private final String currency;

  public Price(int value, String currency)
  {
    this.value = value;
    this.currency = currency;
  }

  public Price plus(Price other)
  {
     return new Price(this.value + other.value, this.currency);
  }

  public static Price euros(int value)
  {
    return new Price(value, "EUR");
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((currency == null) ? 0 : currency.hashCode());
    result = prime * result + value;
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
    if (value != other.value)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Price [" + currency + " " + (value / 100) + "]";
  }
}
