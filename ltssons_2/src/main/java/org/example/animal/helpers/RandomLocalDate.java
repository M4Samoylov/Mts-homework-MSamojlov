package org.example.animal.helpers;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLocalDate {

    long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
    long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();

    public LocalDate getRandomDate() {
        return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay));
    }
}