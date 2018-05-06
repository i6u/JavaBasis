package com.witt.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) {

    }

    public static void func1() {
        try {
            FileInputStream in = new FileInputStream("index.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {

        }
    }

    public static void func2() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("index.html");
    }

    public static void func3() throws MyException {
        throw new MyException();
    }

}

class MyException extends Exception {

}
