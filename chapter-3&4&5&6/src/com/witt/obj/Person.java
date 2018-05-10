package com.witt.obj;

import java.util.Objects;

public class Person {

    private String name;
    private String uid;

    private void eat() {
        System.out.println("eat...");
    }

    protected void learning() {
        System.out.println("learning...");
    }

    public void run() {
        System.out.println("ordinary people run...");
    }

    public void run(boolean ord) {
        System.out.println("athletes run...");
    }


}
