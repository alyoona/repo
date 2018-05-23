package com.stroganova.multithreading;

// Приложение должно считывать ввод пользователя с клавиатуры и записывать все в ArrayList<String>.
// Каждые 15 секунд содержимое листа должно сбрасываться в файл другим потоком.


import java.util.ArrayList;

public class TestReadWriteConsole {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        ReadConsole readConsole = new ReadConsole(list);
        WritingToFile writingToFile = new WritingToFile();

        Thread threadReadConsole = new Thread(readConsole);
        threadReadConsole.start();
    }
}
