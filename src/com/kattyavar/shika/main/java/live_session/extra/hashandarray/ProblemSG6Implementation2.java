package com.kattyavar.shika.main.java.live_session.extra.hashandarray;

import java.util.*;

final class ProblemSG6Implementation2 {
  final Map<String, List<Drink>> map = new HashMap<>();

  // O(n) for each brand
  // Finding each branch is O(1)
  public final void storeDrink(final Drink drink) {
    if (drink == null || drink.getBrand() == null || drink.getName() == null) {
      return;
    }

    List<Drink> drinks = map.get(drink.getBrand());

    if (drinks == null) {
      drinks = new ArrayList<>();
      map.put(drink.getBrand(), drinks);
    }
    //now check if we have drink all ready exits
    if (drinks.contains(drink)) {
      return;
    }

    drinks.add(drink);
  }

  public final List<Drink> getDrinks(final String brand) {
    if (brand == null)
      return null;

    List<Drink> set = map.get(brand);
    if (set == null) {
      return null;
    }
    // Just to make sure outside if someone change content of array will not affect internal map.
    return new ArrayList<>(set);
  }

}
