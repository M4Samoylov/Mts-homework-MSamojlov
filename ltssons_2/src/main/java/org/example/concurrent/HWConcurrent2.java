package org.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HWConcurrent2 {

    /**
     * Потокобезопасный счетчик:
     * Создайте класс счетчика, который можно увеличивать из нескольких потоков без использования синхронизации.
     * Используйте атомарные операции или классы из пакета java.util.concurrent.atomic.
     */
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    count.incrementAndGet();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread:threads) {
            thread.join();
        }

        System.out.println("Count: " + count.get());
    }
}