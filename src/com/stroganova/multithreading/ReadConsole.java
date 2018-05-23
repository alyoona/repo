package com.stroganova.multithreading;

import java.io.*;
import java.util.*;

public class ReadConsole implements Runnable {

    private ArrayList<String> list;

    ReadConsole(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    private void readToList() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();
                list.add(line);
                list.add("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading from console: ", e);
        }
    }

    @Override
    public void run() {
        readToList();
    }
}
