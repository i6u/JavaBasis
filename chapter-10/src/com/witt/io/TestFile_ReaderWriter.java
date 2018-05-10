package com.witt.io;

import java.io.*;

public class TestFile_ReaderWriter {

    public static void main(String[] args) {

        File file = new File("./chapter-10/file/aa.txt");
        File file1 = new File("./chapter-10/file/bb.txt");

        funFileReaderWriter(file, file1);

    }

    public static void funFileReaderWriter(File first, File laster) {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(first);
            writer = new FileWriter(laster);

            char[] c = new char[128];
            int len;

            while ((len = reader.read(c)) != -1) {
                writer.write(c, 0, len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
