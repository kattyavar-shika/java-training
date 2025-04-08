package com.kattyavar.shika.main.java.live_session.apr2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExample {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    //adding

    list.add("v1");
    list.add("v2");
    list.add("v3");


    System.out.println(list);


  }
}


class Test implements Collection<String> {

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<String> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] ts) {
    return null;
  }

  @Override
  public boolean add(String s) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> collection) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends String> collection) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    return false;
  }

  @Override
  public void clear() {

  }
}


class MyCollections<T> {

  String[] arr = new String[10];

  void add() {

  }

  void remove() {

  }

  void Serarch() {

  }
}