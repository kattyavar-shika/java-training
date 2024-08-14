package com.kattyavar.shika.main.java.generics.whyweneed;

public abstract class BaseBuilder<T extends BaseBuilder<T>> {
  private String baseProperty;

  public T setBaseProperty(String baseProperty) {
    this.baseProperty = baseProperty;
    return self();
  }

  protected abstract T self();

  public abstract Product build();

  protected String getBaseProperty() {
    return baseProperty;
  }

}

class Product {
  private String pName1;
  private String pName2;

  public Product(String pName1, String pName2) {
    this.pName1 = pName1;
    this.pName2 = pName2;
  }

  @Override
  public String toString() {
    return "Product{" +
      "pName1='" + pName1 + '\'' +
      ", pName2='" + pName2 + '\'' +
      '}';
  }
}

class ConcreteBuilder extends BaseBuilder<ConcreteBuilder> {

  private String name;

  @Override
  protected ConcreteBuilder self() {
    return this;
  }

  public ConcreteBuilder addNewProperty(String propertyName) {
    this.name = propertyName;
    return this;
  }

  @Override
  public Product build() {
    return new Product(getBaseProperty(), name);
  }
}

/**
 * you can use this in following way ..
 *    ConcreteBuilder builder = new ConcreteBuilder();
 *
 *     builder
 *       .setBaseProperty("test") // here you have ConcreteBuilder...due to this changing is possible
 *       .addNewProperty("anotherProperty") // here you have ConcreteBuilder object
 *       .build(); // Here you will product object at the time of build
 */