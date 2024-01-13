package com.demo.collection.customarray;

public interface CustomList<T> {
    int size();
    boolean isEmpty();
    boolean add(T e);
    T get(int index);
    T set(int index, T e);
    boolean add(int index, T e);
}
