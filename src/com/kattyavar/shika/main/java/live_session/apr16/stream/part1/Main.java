package com.kattyavar.shika.main.java.live_session.apr16.stream.part1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pear", "orange", "melon", "a", "b", "c", "d");

    Map<Integer, List<String>> groupedByLength = fruits.stream()
      .collect(Collectors.groupingBy(String::length));

    System.out.println(groupedByLength);
  }
}
