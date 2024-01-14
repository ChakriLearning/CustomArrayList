package com.demo.collection.iterator;

public interface IteratorDemo<T> {
    boolean hasNext();
    T next();
    boolean remove();
}
