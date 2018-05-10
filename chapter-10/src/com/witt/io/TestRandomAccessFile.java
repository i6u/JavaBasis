package com.witt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

    public static void main(String[] args) {
        File file = new File("./chapter-10/file/aa.txt");
        File file1 = new File("./chapter-10/file/ab.txt");
        File file2 = new File("./chapter-10/file/b.txt");
        //fun1(file, file1);
        fun2(file2);
    }


    public static void fun1(File file, File file1) {
        RandomAccessFile raf1 = null, raf2 = null;
        try {
            raf1 = new RandomAccessFile(file, "r");
            raf2 = new RandomAccessFile(file1, "rw");

            byte[] b = new byte[8];
            int len;

            while ((len = raf1.read(b)) != -1) {
                raf2.write(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (raf1 != null) raf1.close();
                if (raf2 != null) raf2.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    public static void fun2(File file) {

        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(file, "rw");

            raf.seek(3);
            StringBuffer sb = new StringBuffer();

            byte[] bytes = new byte[8];
            int len;

            while ((len = raf.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }

            raf.seek(3);
            raf.write("xy".getBytes());
            raf.write(sb.toString().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
