package com.stroganova.io;

import java.io.File;

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
        File fileTo = new File(to);
        fileTo.mkdir();
        File[] list = fileFrom.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                String currentPathFrom = from + list[i].getPath();
                String currentPathTo = to + list[i].getPath();
                File copied = new File(currentPathTo);
                copied.mkdir();
                copy(currentPathFrom, currentPathTo);
            }
        }


    }

}
