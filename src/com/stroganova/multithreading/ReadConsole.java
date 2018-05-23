package com.stroganova.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ReadConsole implements Runnable {
    private ArrayList<String> list;

    ReadConsole(ArrayList<String> list) {
        this.list = list;
    }

    private void readToList() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
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
