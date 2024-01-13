package com.demo.collection.arraysupport;

import com.demo.collection.exception.InvalidInputException;

public class ArraySupportDemo {

    public static <T> T[] copyOf(T[] original, int newCapcity) {
        T[] newArray = (T[]) new Object[newCapcity];
        for(int i = 0; i < original.length ; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    public static int newLength(int oldCapacity, int minGrowth, int prefGrowth) {
        return oldCapacity + Math.max(minGrowth, prefGrowth);
    }

    public static void checkIndex(int index, int size) {
        if(index < 0 || index >= size) {
            throw new InvalidInputException("Index is Not in Range");
        }
    }
}
