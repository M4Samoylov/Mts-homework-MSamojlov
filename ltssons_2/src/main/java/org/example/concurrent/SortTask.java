package org.example.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class SortTask implements Callable<List<Integer>> {

    private final List<Integer> array;

    public SortTask(List<Integer> array) {
        this.array = array;
    }

    @Override
    public List<Integer> call() {
        Collections.sort(array);
        return array;
    }
}
