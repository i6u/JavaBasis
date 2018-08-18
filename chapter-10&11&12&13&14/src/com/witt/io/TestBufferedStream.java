package com.witt.io;

import java.io.*;

public class TestBufferedStream {
    public static void main(String[] args) {
        File file = new File("./chapter-10/file/a.txt");
        File file1 = new File("./chapter-10/file/bb1.txt");

        //fun1FileStream(file, file1);
        fun2FileStream(file, file1);
    }

    public static void fun1FileStream(File file, File file1) {

        FileInputStream in = null;
        FileOutputStream out = null;

        BufferedInputStream bIn = null;
        BufferedOutputStream bOut = null;

        try {
            bIn = new BufferedInputStream(new FileInputStream(file));
            bOut = new BufferedOutputStream(new FileOutputStream(file1));

            byte[] bytes = new byte[128];
            int len;

            while ((len = bIn.read(bytes)) != -1) {
                bOut.write(bytes, 0, len);
            }
            bOut.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bOut != null) bOut.close();
                if (bIn != null) bIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void fun2FileStream(File file, File file1) {
        FileReader reader = null;
        FileWriter writer = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedWriter = new BufferedWriter(new FileWriter(file1));

            //char[] chars = new char[128];
            //int len;
            //while ((len = bufferedReader.read(chars)) != -1) {
            //    bufferedWriter.write(chars, 0, len);
            //}

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
