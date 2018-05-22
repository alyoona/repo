package com.stroganova.multithreading;

// Написать класс Timer которій оперирует двумя параметрами : имя и количество секунд до конца.
// Каждую секунду віводит в консоль информацию о текущем состоянии таймера -> имя + количество секунд до финиша.
// По прошествии времени відает мессадж о конце работы. Таймер должен работать асинхронно.
// Протестировать  приложение с 2-3 таймерами запущенніми параллельно.

public class Timer implements Runnable {
    private String timerName;
    private int seconds;

    Timer(String timerName, int seconds) {
        this.timerName = timerName;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < seconds; i++) {
            int countSecondsToEnd = seconds - 1 - i;
            System.out.println("To finish of " + timerName + " " + countSecondsToEnd + " " + "seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
