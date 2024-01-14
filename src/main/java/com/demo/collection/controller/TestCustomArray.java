package com.demo.collection.controller;

import com.demo.collection.customarray.CustomArrayList;
import com.demo.collection.iterator.IteratorDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class TestCustomArray {
    public static <T> void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        System.out.println(list.size());
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        list.removeRange(3,5);
        IteratorDemo<String> itr = list.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            if(str.equals("one")) itr.remove();
            System.out.println(str);
        }
//        list.removeRange(3,5);
//        list.add(2,"newTwo");
//        list.add(34);
//        list.remove(2);
//        list.clear();
       System.out.println(list.size());
//        System.out.println(list.print());
//        ArrayList<String> arrayList = new ArrayList<>();
//        Iterator<String> it = arrayList.iterator();
    }
}
