package org.example.concurrent;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.Callable;

public class FactorialTask implements Callable<BigInteger> {

    private final List<Integer> array;

    public FactorialTask(List<Integer> array) {
        this.array = array;
    }

    @Override
    public BigInteger call() {
        BigInteger endValue = BigInteger.valueOf(1);

        for(Integer value : array) {
            endValue = BigInteger.valueOf(value).multiply(endValue);
        }

        return endValue;
    }
}
