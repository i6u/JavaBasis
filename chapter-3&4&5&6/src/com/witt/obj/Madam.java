package com.witt.obj;

public class Madam extends Person{

    protected final void baby() {
        System.out.println("have a baby...");
    }

    @Override
    protected void learning() {
        System.out.println("madam learning...");
    }
}
