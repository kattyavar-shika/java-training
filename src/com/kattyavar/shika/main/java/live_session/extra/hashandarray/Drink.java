package com.kattyavar.shika.main.java.live_session.extra.hashandarray;


final class Drink {
  final String brand;
  final String name;

  public Drink(final String brand, final String name) {
    this.brand = brand;
    this.name = name;
  }

  public final String getBrand() {
    return brand;
  }

  public final String getName() {
    return name;
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Drink other = (Drink) obj;
    if (brand == null) {
      if (other.brand != null) {
        return false;
      }
    } else if (!brand.equals(other.brand)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Drink [brand=" + brand + ", name=" + name + "]";
  }
}