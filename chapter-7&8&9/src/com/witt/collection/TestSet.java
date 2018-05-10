package com.witt.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {

    public static void main(String[] args) {

        func1();
    }

    /**
     *
     * 无序 != 随机
     * 不可重复
     * */

    public static void func1() {
        Set set = new HashSet();

        set.add('a');
        set.add(1);
        set.add("喜欢");
        set.add(null);
        set.add(1);

        System.out.println(set.size());

        System.out.println(set);

        Set set1 = new LinkedHashSet();

    }
}
