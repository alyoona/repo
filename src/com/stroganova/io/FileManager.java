package com.stroganova.io;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static int calculateFiles(String somePath) {
        int result = 0;
        File parentFolder = new File(somePath);
        for (File folder : parentFolder.listFiles()) {
            if (folder.isFile()) {
                result++;
            } else {
                result += calculateFiles(folder.getAbsolutePath());
            }
        }
        return result;
    }

    public static int calculateDirs(String somePath) {
        int result = 0;
        File parentFolder = new File(somePath);
        for (File folder : parentFolder.listFiles()) {
            if (folder.isDirectory()) {
                result++;
                result += calculateDirs(folder.getAbsolutePath());
            }
        }
        return result;
    }

    public static void copy(String from, String to) {
        File folderFrom = new File(from);
        File folderTo = new File(to);
        folderTo.mkdir();
        for (File folder : folderFrom.listFiles()) {
            String nextPathTo = to + "\\" + folder.getName();
            if (folder.isFile()) {
                try {
                    new File(nextPathTo).createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException("error during creating new file: " + nextPathTo, e);
                }
            } else {
                String nextPathFrom = folder.getAbsolutePath();
                copy(nextPathFrom, nextPathTo);
            }
        }
    }

    public static void move(String from, String to) {
        copy(from, to);
        remove(from);
    }

    public static void remove(String pathToRemove) {
        File currentFolder = new File(pathToRemove);
        if (currentFolder.isDirectory()) {
            for (File folder : currentFolder.listFiles()) {
                remove(folder.getAbsolutePath());
            }
        }
        currentFolder.delete();
    }
}

