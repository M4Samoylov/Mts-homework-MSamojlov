package org.example.concurrent;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class HWConcurrent1 {

    /**
     * Параллельная сортировка массива:
     * Разделите массив на части и отсортируйте каждую часть в отдельном потоке.
     * Затем объедините отсортированные части в один отсортированный массив.
     */
    public static void main(String[] args) {
        int listSize = 100;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            list.add(new Random().nextInt(100));
        }

        int threadNum = 4;
        int chunkSize = listSize / threadNum;

        ExecutorService exec = newFixedThreadPool(threadNum);
        Future<List<Integer>>[] futures = new Future[threadNum];

        for (int i = 0; i < threadNum; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;

            List<Integer> subArray = list.subList(startIndex, endIndex);
            futures[i] = exec.submit(new SortTask(subArray));
        }

        List<Integer> endArray = new ArrayList<>();

        for (Future<List<Integer>> future : futures) {
            try {
                endArray.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}