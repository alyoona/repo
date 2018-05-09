package com.stroganova.io;

import java.io.File;
import java.util.Iterator;

public class FileManager {

    public static int calculateFiles(String somePath) {

        int result = 0;
        File file = new File(somePath);
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                result++;

            } else {
                result += calculateFiles(list[i].getAbsolutePath());
            }
        }
        return result;
    }

    public static int calculateDirs(String somePath) {
        int result = 0;
        File file = new File(somePath);
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                result++;
                result += calculateDirs(list[i].getAbsolutePath());
            }
        }
        return result;
    }

    public static void copy(String from, String to) {
        File fileFrom = new File(from);
        File fileTo = new File(from);
        File[] list = fileFrom.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                String pathTo = fileTo + list[i].getPath();
                new File(pathTo);

            }
        }


    }

}
