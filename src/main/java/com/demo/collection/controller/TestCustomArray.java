package com.demo.collection.controller;

import com.demo.collection.customarray.CustomArrayList;

import java.util.ArrayList;

public class TestCustomArray {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        //list.removeRange(3,5);
       // list.add(2,"newTwo");
       // list.add(34);
      //  list.remove(2);
       // list.clear();
     //   System.out.println(list.get(2));
        System.out.println(list.print());
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList
    }
}
