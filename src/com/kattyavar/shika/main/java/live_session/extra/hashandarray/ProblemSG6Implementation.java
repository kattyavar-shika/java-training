package com.kattyavar.shika.main.java.live_session.extra.hashandarray;

import java.util.*;

final class ProblemSG6Implementation {
  final Map<String, Set<Drink>> map = new HashMap<>();

  // O(1)
  public final void storeDrink(final Drink drink) {
    if (drink == null || drink.getBrand() == null || drink.getName() == null) {
      return;
    }

    Set<Drink> drinks = map.get(drink.getBrand());

    if (drinks == null) {
      drinks = new HashSet<>();
      map.put(drink.getBrand(), drinks);
    }
    drinks.add(drink);
  }

  public final List<Drink> getDrinks(final String brand) {
    if (brand == null)
      return null;

    Set<Drink> set = map.get(brand);
    if (set == null) {
      return null;
    }
    // Just to make sure outside if someone change content of array will not affect internal map.
    return new ArrayList<>(set);
  }

}
