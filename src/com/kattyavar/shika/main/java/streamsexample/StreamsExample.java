package com.kattyavar.shika.main.java.streamsexample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kattyavar.shika.main.java.streamsexample.Product.getProducts;

public class StreamsExample {

  static void displayAllProductName() {
    getProducts().stream().forEach(x -> System.out.println(x.getName()));

  }

  static void productRatingHigherThan4() {
    // Find all products with a rating of 4 or higher:

    //If you are using java 8 to java 15 : use       .collect(Collectors.toList())
    // java 16 onwards use toList();
    getProducts().stream().filter(p -> p.getReviews().stream().anyMatch(r -> r.getRating() >= 4))
      //.collect(Collectors.toList())  // if you are using java 8 to java 15 then use this
      //.toList() // java 16 onwards use this..
      .toList().forEach(System.out::println);

  }

  static void getAverageRatingForEachProduct() {
    //Get the average rating of reviews for each product:
    Map<String, Double> collect = getProducts().stream().collect(Collectors.toMap(p -> p.getName(), p -> p.getReviews().stream().mapToInt(r -> r.getRating()).average().orElse(0.0)));

    System.out.println("find out the Average rating by product " + collect);
  }

  static void findTheProductWithHigherPrice() {
    //Find the product with the highest price:
    Optional<Product> max = getProducts().stream()
      //.max(Comparator.comparing(x -> x.getPrice())); // we can write same as using method ref..
      .max(Comparator.comparing(Product::getPrice));

    max.ifPresent(x -> System.out.println(" Higher product information = " + x));

  }

  static void listAllProductWithTherePrice() {
    // List all products with their prices:
    List<String> list = getProducts().stream().map(p -> p.getName() + ": $" + p.getPrice()).toList();

    System.out.println(" Product with List => " + list);

  }

  static void countTheNumberOfReviewByProduct() {

    Map<String, Integer> collect = getProducts().stream().collect(Collectors.toMap(p -> p.getName(), p -> p.getReviews().size()));

    System.out.println("Product with three review count " + collect);

  }

  static void getAllReviewMoreThan3Rating() {
    //Get all reviews with a rating of 3 or higher:

    List<Review> list = getProducts().stream().flatMap(p -> p.getReviews().stream()).filter(r -> r.getRating() >= 3).toList();

    System.out.println("Result = " + list);

  }

  static void findAveragePriceOfProduct() {
    //Find the average price of products:

    double average = getProducts().stream()
      //.mapToDouble(p -> p.getPrice()) // as this same line of code can be written as method ref
      .mapToDouble(Product::getPrice).average().orElse(0.0);

    System.out.println("Result = >" + average);

  }

  static void getAllUserNameWhoHasGivenRatingMoreThan5() {
    //List all reviewers who have given a rating of 5:

    List<String> list = getProducts().stream().flatMap(p -> p.getReviews().stream()).map(r -> r.getReviewerName()).distinct().toList();

    System.out.println("Result " + list);
  }

  static void listAllProductHavingReviewsContainPrice() {

    //List all products that have reviews containing the word "price":

    List<Product> price = getProducts().stream().filter(p -> p.getReviews().stream().anyMatch(r -> r.getComment().toLowerCase().contains("price"))).toList();

    System.out.println("Result " + price);
  }

  static void sortAllProductByPrice() {

    List<Product> list = getProducts()
      .stream()
      //.sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))  // Same can be written as method reff
      .sorted(Comparator.comparingDouble(Product::getPrice))
      .toList();

    System.out.println("Result " + list);

    //lets sort by reverse order

    list = getProducts()
      .stream()
      .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
      //.toList();  // from java 16 we can use toList or you need to use     .collect(Collectors.toList());
      .toList();

    System.out.println("Reversed Result " + list);

    //let sort using parallelStream


  }

  static void parallelStreamOptions() {
    List<Product> list = getProducts()
      .parallelStream()  // It creates a parallel stream from the beginning. The entire stream pipeline will execute in parallel.
      .sorted(Comparator.comparingDouble(Product::getPrice))
      .toList();
    System.out.println("Result using parallelStream " + list);

    //let have look at other options

    list = getProducts()
      .stream() // It starts with a sequential stream
      .parallel()  // It starts with a sequential stream and then explicitly makes it parallel. This is useful if you need to switch a specific stream from sequential to parallel within a larger pipeline.
      .sorted(Comparator.comparingDouble(Product::getPrice))
      .toList();
    System.out.println("Result using parallelStream " + list);


    //let say after some point of time you would like to disable parallel off and start using sequential then use sequential

    /***
     * If you want to perform some operations in parallel and then switch to sequential processing,
     * you can use .sequential() after you’ve done parallel operations.
     * javaNote that .sequential() should be used before the terminal operation if you want to revert to sequential processing.
     */
    List<String> productPriceList = getProducts()
      .stream() // Start with a sequential stream
      .parallel() // Convert to parallel stream
      .sorted(Comparator.comparingDouble(Product::getPrice)) // Perform parallel sorting
      .sequential() // Convert back to sequential stream
      .map(product -> {
        // Perform some additional sequential operations here
        // For example, just as a placeholder:
        return product.getName() + " :" + product.getPrice();
      })
      .toList(); // Collect results into a list

    System.out.println("Result " + productPriceList);

  }

  static void handleNullListWithOutIfElse() {
    //java 9 onwards..

    //List<Product> list = Arrays.asList(new Product("p1", 10, null));
    List<Product> list = Arrays.asList(new Product("p1", 10, null));

    System.out.println(" product list " + list.stream()
      .map(x -> x.getName())
      .toList());


    //Let assume we have list as null;

    list = null;

    //list.stream() this will throw error.

    System.out.println("Input is null = " + Stream.ofNullable(list)
      .flatMap(Collection::stream)
      .peek(x -> System.out.println("In side the peek..."))
      .map(x -> x.getName())
      .collect(Collectors.toList()));

    // or same can written as below..

    System.out.println((list != null ? list.stream() : Stream.<Product>empty())
      .peek(x -> System.out.println("In side the peek..."))
      .map(x -> x.getName())
      .collect(Collectors.toList()));


    //or you can use generic method..


    System.out.println(getStream(list)
      .peek(x -> System.out.println("In side the peek..."))
      .map(x -> x.getName())
      .collect(Collectors.toList()));


  }

  static <T> Stream<T> getStream(List<T> list) {
    return list != null ? list.stream() : Stream.empty();
  }

  public static void main(String[] args) {
    //displayAllProductName();
    //productRatingHigherThan4();
    //getAverageRatingForEachProduct();
    //findTheProductWithHigherPrice();
    //listAllProductWithTherePrice();
    //countTheNumberOfReviewByProduct();
    //getAllReviewMoreThan3Rating();
    //parallelStreamOptions();
    handleNullListWithOutIfElse();
  }
}


