package com.demo.collection.system;

public class SystemDemo {
    public static <T> T[] arrayCopy(T[] elementData, int index) {
        int newSize = elementData.length;
        T[] newArray = (T[]) new Object[newSize];
        for(int i = 0; i < newSize ; i++) {
            if (i != index) {
                newArray[i] = elementData[i];
            } else {
                newArray[i+1] = elementData[i];
            }
        }
        return newArray;
    }

    public static Object[] fastRemove(int index, Object[] elementData) {
        int newSize = elementData.length - 1;
        Object[] newObj = new Object[newSize];
        for(int i = 0; i < newSize; i++) {
            if(i != index) {
                newObj[i] = elementData[i];
            } else {
                newObj[i] = elementData[i+1];
            }
        }
        return newObj;
    }

    public static Object[] fastRemoveFromRange(Object[] elementData, int fromIndex, int toIndex) {
        Object[] newArray = new Object[elementData.length - (toIndex - fromIndex) + 1];
        for (int i = 0, j= 0; i < elementData.length; i++) {
            if(!(i >= fromIndex && i <= toIndex)) {
                newArray[j++] = elementData[i];
            }
        }
        return newArray;
    }
}
