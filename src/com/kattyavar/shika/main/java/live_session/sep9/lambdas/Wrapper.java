package com.kattyavar.shika.main.java.live_session.sep9.lambdas;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Wrapper {


  static void wrapperExample1() {
    Consumer<String> consumer = s -> System.out.println("I am patill... and input is..." + s);

    acceptTheInput("Amol ", wrapper(s -> System.out.println("I am patill... and input is..." + s)));
    List<Integer> list = List.of(1, 2, 3, 6, 7, 9);

    BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;


    int dividBy = 0;
    for (Integer number : list) {

      System.out.println("Item =" + number + ", Divide by =" + dividBy + ", Result =" + appyOperation(number, dividBy, divide));
    }


  }

  public static void main(String[] args) {

    Function<Integer, Integer> addToNumber5 = (n) -> n + 5;
    Function<Integer, Integer> addToNumber3 = (n) -> n * 3;

    Function<Integer, Integer> identity = Function.identity();

    System.out.println("identity result ===> " + identity.apply(10));

    System.out.println(addToNumber5.andThen(addToNumber3).andThen(addToNumber5).apply(10));


    List<Integer> list = List.of(1, 10, 20, 5, 6, 15);


    Predicate<Integer> abc = x -> x > 20;

    abc.test(20);

    list
      .stream()
      .filter(abc)
      .count();


  }

  static BiFunction<Integer, Integer, Integer> intWrapper(BiFunction<Integer, Integer, Integer> biFunction) {
    return (a, b) -> {
      try {
        biFunction.apply(a, b);
      } catch (ArithmeticException e) {
        System.out.println(" we have error");
      }
      return 0;
    };
  }

  static Integer appyOperation(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction) {
    return biFunction.apply(a, b);
  }

  static Consumer<String> wrapper(Consumer<String> consumer) {
    return (String s) -> {

      consumer.accept(s);
    };
  }


  static void acceptTheInput(String input, Consumer<String> consumer) {
    consumer.accept(input);
  }


}
