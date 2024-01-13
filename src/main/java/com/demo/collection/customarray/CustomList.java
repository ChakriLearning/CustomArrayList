package com.demo.collection.customarray;

public interface CustomList<T> {
    int size();
    boolean isEmpty();
    boolean add(T e);
    boolean add(int index, T e);
    T get(int index);
    T set(int index, T e);
    T remove(int index);
    void clear();
    void removeRange(int fromIndex, int toIndex);
    <T2> T2[] print();
}
