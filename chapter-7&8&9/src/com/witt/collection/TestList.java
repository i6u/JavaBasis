package com.witt.collection;

import java.util.*;

public class TestList {
    /**
     * list 有序可重复
     */
    public static void main(String[] args) {
        funcLinkedList();
    }

    // linkedList 允许 null，线程不安全
    public static void funcLinkedList() {
        List list = new LinkedList();
        list.add("a");
        list.add("");
        list.add(null);
        list.add(1);
        list.add('a');

        ListIterator iterator = list.listIterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        List list1 = Collections.synchronizedList(new LinkedList());
    }

    // arrayList
    public static void funcArrayList() {

    }

    //
    public static void funcVector() {

    }

    //
    public static void funcStack() {

    }

}
