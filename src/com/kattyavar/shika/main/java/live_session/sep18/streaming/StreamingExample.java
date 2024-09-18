package com.kattyavar.shika.main.java.live_session.sep18.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingExample {

  static void oldWayToIterate() {
    List<Person> list = new ArrayList<>();
    list.add(new Person("P1", 11));
    list.add(new Person("P2", 12));
    list.add(new Person("P3", 13));
    list.add(new Person("P4", 14));

    //Advance for loop ...
    for (Person obj : list) {
      obj.setAge(obj.getAge() + 5);
      obj.setName("Hello" + obj.getName());
      System.out.println(obj);
    }

    System.out.println("Using the normal for loop ...");

    //I can do this with normal for loop ..
    int size = list.size();
    for (int index = 0; index < size; index++) {
      Person obj = list.get(index);
      obj.setAge(obj.getAge() + 5);
      obj.setName("Hello" + obj.getName());
      System.out.println(obj);

      list.add(new Person("This should not allowed", 12));

    }

  }

  //
  static void printInputData() {

    //In normal way

    List<Product> list = getProductData();

    List<Product> result = new ArrayList<>();
    for (int index = 0; index < list.size(); index++) {
      if (list.get(index).getPrice() >= 1000) {
        result.add(list.get(index));
      }
    }

    //finally print the result ..
    System.out.println("Result " + result);

    System.out.println("Now let do the same thing using stream");

    getProductData()
      .stream()
      .filter(p -> p.getPrice() >= 1000)
      .forEach(x -> System.out.println("Product name : " + x.getName()));
  }

  static void mapExample() {
    getProductData()
      .stream()
      .filter(product -> product.getPrice() >= 1000)
      .map(product -> product.getPrice())
      .forEach(pName -> System.out.println("Product name " + pName));
  }

  static void lazyExample() {
    System.out.println("Let see the lazy example...");
    Stream<String> streamVariable = getProductData()
      .stream()
      .filter(product -> product.getPrice() >= 1000)
      .map(product -> product.getName());


    List<String> collect = streamVariable
      .collect(Collectors.toList());

    Stream<String> streamVariable2 = getProductData()
      .stream()
      .filter(product -> product.getPrice() >= 1000)
      .map(product -> product.getName());

    List<String> anotherList = streamVariable2
      .collect(Collectors.toList());


    System.out.println("Let print the data.." + collect);

  }


  static void distinctExample() {
    List<String> list = List.of("Patil", "Prasad", "Amol", "Prasad", "Patil");

    System.out.println("Original list " + list);
    list
      .stream()
      .distinct()
      .forEach(name -> System.out.println(name));


    //let have look in case of custom objects..
    List<Person> personList = List.of(
      new Person("p1", 11),
      new Person("p1", 11),
      new Person("p2", 12)
    );


    System.out.println("Original list of persons " + personList);


    Optional<Person> optionalData = Optional.of(null); // if you give null as input it will throw error..
    Optional<Person> optionalData2 = Optional.ofNullable(null); // in this case even if you pass null still its okie.it wont throw error.

    Optional<Person> min = personList
      .stream()
      .distinct()
      .min((person1, person2) -> person1.getAge().compareTo(person2.getAge()));

  }

  public static void main(String[] args) {
    //System.out.println("Initial data " + getProductData());
    //printInputData();
    //mapExample();
    //lazyExample();
    //distinctExample();


    //Below code will not get executed...
    Stream<Product> productStream = getProductData()
      .stream()
      .filter(p -> p.getPrice() > 300);


    List<Product> result = new ArrayList<>();


    List<Product> r1 = productStream
      .parallel()
      .toList();


  }


  static List<Product> getProductData() {

    List<Review> reviewForLaptop = List.of(
      new Review("Person 1", 5, "Excellent laptop"),
      new Review("Person 2", 4, "Very good, but a bit expensive"),
      new Review("Person 3", 4, "Very good, but a bit expensive")
    );

    List<Review> reviewForSmartPhone = List.of(
      new Review("Person 1", 3, "Average phone"),
      new Review("Person 2", 4, "Good value for the price.."),
      new Review("Person 3", 2, "Not working...")
    );

    List<Review> reviewForTablet = List.of(
      new Review("Person 4", 3, "Average Tablet"),
      new Review("Person 5", 4, "Good value for the price..")
    );
    return List.of(
      new Product("Laptop", 1200.00, reviewForLaptop),
      new Product("Smartphone", 800.00, reviewForSmartPhone),
      new Product("Tablet", 300.00, reviewForTablet)
    );
  }


}


class Product {
  private String name;
  private double price;
  private List<Review> reviews;

  public Product(String name, double price, List<Review> reviews) {
    this.name = name;
    this.price = price;
    this.reviews = reviews;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public String toString() {
    return "Product{" +
      "name='" + name + '\'' +
      ", price=" + price +
      ", reviews=" + reviews +
      '}';
  }
}


class Review {
  private String reviewerName;
  private int rating;
  private String comment;

  public Review(String reviewerName, int rating, String comment) {
    this.reviewerName = reviewerName;
    this.rating = rating;
    this.comment = comment;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public void setReviewerName(String reviewerName) {
    this.reviewerName = reviewerName;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "Review{" +
      "reviewerName='" + reviewerName + '\'' +
      ", rating=" + rating +
      ", comment='" + comment + '\'' +
      '}';
  }
}


class Person {
  private String name;
  private Integer age;

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(age, person.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}