package com.witt.io;

import java.io.File;
import java.io.IOException;

public class TestFile {

    /**
     *
     * 对文件 & 文件夹一些操作，不能操作文件内容
     *
     * 获取路径，获取名称，检查文件是否存在，检查权限，检查类型，创建文件&文件夹，多级目录操作
     * */

    public static void main(String[] args) {
        //fun1();
        fun2();
    }

    public static void fun1() {
        File file = new File("/Users/witt/Practice/java/JavaBasis/chapter-10/file/a.txt");
        File file1 = new File("/Users/witt/Practice/java/JavaBasis/chapter-10/file/b.txt");
        File files = new File("/Users/witt/Practice/java/JavaBasis/chapter-10/file");

        //file1.renameTo(file);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.canExecute());

        System.out.println(files.getName());
        System.out.println(files.getPath());
        System.out.println(files.getAbsoluteFile());
        System.out.println(files.getAbsolutePath());
        System.out.println(files.getParent());
        System.out.println(files.getParentFile());
        System.out.println(files.exists());
    }

    public static void fun2() {
        try {
            File file = new File("/Users/witt/Practice/java/JavaBasis/chapter-10/file/c.txt");
            File files = new File("/Users/witt/Practice/java/JavaBasis/chapter-10/file/tmp/a/b/c/d/c.txt");

            if (!file.exists()) {
                System.out.println(file.createNewFile());
            }


            File parent = files.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
                System.out.println(files.createNewFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
