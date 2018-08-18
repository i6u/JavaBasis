package com.witt.io;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author witt
 * @fileName TryWithResource
 * @date 2018/8/19 03:30
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class TryWithResource {

    public void copyFile(String inPath, String toPath) {
        try (
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File(inPath)));
                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File(toPath)))
        ) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void autoClose() {
        try (
                FileInputStream fin = new FileInputStream(new File("input.txt"));
                FileOutputStream fout = new FileOutputStream(new File("out.txt"));
                GZIPOutputStream out = new GZIPOutputStream(fout)
        ) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fin.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
