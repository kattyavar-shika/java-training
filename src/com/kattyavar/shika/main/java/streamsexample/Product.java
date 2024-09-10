package com.kattyavar.shika.main.java.streamsexample;

import java.util.List;

public class Product {
  private String name;
  private double price;
  private List<Review> reviews;

  public Product(String name, double price, List<Review> reviews) {
    this.name = name;
    this.price = price;
    this.reviews = reviews;
  }


  static List<Product> getProducts() {

    List<Review> reviewForLaptop = List.of(
      new Review("Person 1", 5, "Excellent laptop"),
      new Review("Person 2", 4, "Very good, but a bit expensive")
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