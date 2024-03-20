package org.example.animal.helpers;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLocalDate {

    static long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
    static long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();

    public static LocalDate getRandomDate() {
        return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay));
    }
}