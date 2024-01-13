package com.demo.collection.customarray;

import com.demo.collection.arraysupport.ArraySupportDemo;
import com.demo.collection.exception.InvalidInputException;

public class CustomArrayList<T> implements CustomList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    Object[] elementData;
    private int size;
    public CustomArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];   //default capacity for no input size;
    }
    public CustomArrayList(int initialCapacity) {
        if(initialCapacity >= 0) {
            elementData = new Object[initialCapacity];   //having initial capacity;
        } else if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new InvalidInputException("Illegal Capacity : " + initialCapacity);
        }
    }

    @Override
    public boolean add(T e) {       //add method;
        add(e,elementData,size);
        return false;
    }

    @Override
    public T get(int index) {     //get method;
        ArraySupportDemo.checkIndex(index, size);  //to retrieve the specified element at specified index;
        return (T)elementData[index];
    }

    @Override
    public T set(int index, T e) {
        ArraySupportDemo.checkIndex(index,size);
        T oldValue = (T)elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    @Override
    public boolean add(int index, T e) {
        ArraySupportDemo.checkIndex(index,size);
        Object[] elementData;
        if(size == this.elementData.length) {

        }
        return true;
    }

    private void add(T e,Object[] elementData, int size) {
        if(size == elementData.length) {
            elementData = growSize();
        }
        elementData[size++] = e;
    }

    private Object[] growSize() {
        return growSize(size + 1);
    }

    private Object[] growSize(int minCapacity) {
        int oldCapacity = elementData.length;
        if(oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraySupportDemo.newLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 2);
            return ArraySupportDemo.copyOf(elementData, newCapacity);
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
