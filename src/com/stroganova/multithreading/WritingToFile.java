package com.stroganova.multithreading;

import java.io.*;
import java.util.ArrayList;

public class WritingToFile implements Runnable {
    private ArrayList<String> list;

    WritingToFile(ArrayList<String> list) {
        this.list = list;
    }

    private void write() {
        File file = new File("dataFromConsole.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String str : list) {
                writer.write(str);
            }
            list.clear();
        } catch (IOException e) {
            throw new RuntimeException("Error while writing from console: ", e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("time is over,it will be write to file");
            write();
            System.out.println("Done.");
        }
    }
}
