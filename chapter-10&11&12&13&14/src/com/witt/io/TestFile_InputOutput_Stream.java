package com.witt.io;

import java.io.*;

public class TestFile_InputOutput_Stream {

    /**
     * 对文件内容进行操作
     * <p>
     * 流的分类
     * 输入流、输出流
     * 字节流、字符流
     * 节点流，处理流
     * <p>
     * 基类              节点流（文件流）
     * <p>
     * InputStream      FileInputStream
     * OutputStream     FileOutputStream
     * Reader           FileReader
     * Writer           FileWriter
     */
    public static void main(String[] args) {
        File file = new File("./chapter-10/file/a.txt");
        File file1 = new File("./chapter-10/file/d.txt");

        //fun1FileInputStream();
        //fun2FileInputStream(file1);
        //funFileOutputStream(file1);

        funFileInput2FileOutput(file, file1);
    }

    /**
     * FileInputStream
     */

    public static void fun1FileInputStream(File file) {
        FileInputStream in = null;
        try {

            in = new FileInputStream(file);
            int b;
            while ((b = in.read()) != -1) {
                System.out.println(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void fun2FileInputStream(File file) {

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);

            byte[] b = new byte[8];
            int len;
            while ((len = in.read(b)) != -1) {
                //System.out.println(new String(b, 0, len));
                for (int i = 0; i < len; i++) {
                    System.out.print((char) b[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    public static void funFileOutputStream(File file) {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file);
            out.write("喜欢".getBytes());
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void funFileInput2FileOutput(File first, File last) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(first);
            out = new FileOutputStream(last);

            byte[] b = new byte[64];
            int len;

            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
