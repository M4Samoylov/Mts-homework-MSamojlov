package org.example.concurrent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class HWConcurrent4 {

    /**
     * Параллельное вычисление факториала:
     * Разделите вычисление факториала на несколько частей и вычислите каждую часть в отдельном потоке.
     * Затем объедините результаты.
     */
    public static void main(String[] args) {
        int value = 10;
        int threadNum = 2;
        int chunkSize = value / threadNum;

        ArrayList<Integer> listValue = new ArrayList<>();

        for (int i = 1; i <= value; i++) {
            listValue.add(i);
        }

        ExecutorService exec = newFixedThreadPool(threadNum);
        Future<BigInteger>[] futures = new Future[threadNum];

        for (int i = 0; i < threadNum; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;

            List<Integer> subArray = listValue.subList(startIndex, endIndex);
            futures[i] = exec.submit(new FactorialTask(subArray));
        }

        BigInteger endValue = BigInteger.valueOf(1);

        for (Future<BigInteger> future : futures) {
            try {
                endValue = endValue.multiply(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}