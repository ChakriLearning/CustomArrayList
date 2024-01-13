package com.demo.collection.customarray;

import com.demo.collection.arraysupport.ArraySupportDemo;
import com.demo.collection.exception.IndexOutOfBoundException;
import com.demo.collection.exception.InvalidInputException;
import com.demo.collection.system.SystemDemo;

public class CustomArrayList<T> implements CustomList<T>{
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
        add(e,this.elementData,this.size);
        return true;
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
    public T remove(int index) {
        rangeCheckForIndex(index, size);
        T oldValue = (T)this.elementData[index];
        this.elementData = SystemDemo.fastRemove(index, this.elementData);
        this.size--;
        return oldValue;
    }

    @Override
    public void clear() {
        for(int to = this.size, i = this.size = 0; i < to; i++) {
            this.elementData[i] = null;
        }
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IndexOutOfBoundException("from index " + fromIndex + " is greater than toIndex " + toIndex);
        this.elementData = SystemDemo.fastRemoveFromRange(this.elementData, fromIndex, toIndex);
        this.size = this.size - ((toIndex - fromIndex) + 1);
    }

    @Override
    public <T> T[] print() {
        T[] array = (T[])new Object[this.size];
        for(int i = 0; i < this.size; i++) {
            array[i] = (T)this.elementData[i];
        }
        return array;
    }

    @Override
    public boolean add(int index, T e) {  //adding element's at specified index by user choice;
        rangeCheckForIndex(index, this.size);
        if (this.size == this.elementData.length) {
            this.elementData = growSize();
        }
        this.elementData = SystemDemo.arrayCopy(this.elementData,index);
        this.elementData[index] = e;
        return true;
    }

    private void rangeCheckForIndex(int index, int size) {
        if(index > size || index < 0) throw new IndexOutOfBoundException("Index : " + index + " size : " + size);

    }

    private void add(T e,Object[] elementData, int size) {
        if(size == elementData.length) {
            elementData = growSize();
        }
        elementData[size] = e;
        this.size = size + 1;
    }

    private Object[] growSize() {
        return growSize(this.size + 1);
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

}
