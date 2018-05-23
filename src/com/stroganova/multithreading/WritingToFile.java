package com.stroganova.multithreading;

import java.io.*;
import java.util.ArrayList;

// Каждые 15 секунд содержимое листа должно сбрасываться в файл другим потоком.
public class WritingToFile implements Runnable {
    private ArrayList<String> list;

    WritingToFile(ArrayList<String> list) {
        this.list = list;
    }

    private void write() {
        File file = new File("dataFromConsole.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String str : list) {
                writer.write(str);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while writing from console: ", e);
        }
    }

    @Override
    public void run() {
        write();
    }
}
