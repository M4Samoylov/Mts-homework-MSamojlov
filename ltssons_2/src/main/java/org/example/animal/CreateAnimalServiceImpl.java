package org.example.animal;

import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimal(int N) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i >= 0 && i <= 1) {
                animals.add(new Cat("Пушистые" + i, "Моська", 2.9, "злой"));
            } else if (i >= 2 && i <= 3) {
                animals.add(new Wolf("Серые" + i, "ГигаВолк", 3.4, "агрессивный"));
            }
            else if (i >= 4 && i <= 5) {
                animals.add(new Shark("Лысая" + i, "Магаладон", 5.2, "Зубастый"));
            }
            else if (i >= 6 && i <= 7) {
                animals.add(new Lisa("Лисы" + i, "красивые", 5.1, "Хитрый"));
            }
            else if (i >= 8 && i <= 9) {
                animals.add(new Dog("Четвероногие" + i, "Мопс", 8.2, "Добряк"));
            }
        }
        animals.forEach(System.out::println);
    }

    @Override
    public void createAnimal() {
        List<Animal> animals = new ArrayList<>();
        int i = 0;
        do {
            if (i >= 0 && i <= 1) {
                animals.add(new Cat("Пушистые" + i, "Моська", 2.9, "злой"));
            } else if (i >= 2 && i <= 3) {
                animals.add(new Wolf("Серые" + i, "ГигаВолк", 3.4, "агрессивный"));
            }
            else if (i >= 4 && i <= 5) {
                animals.add(new Shark("Лысая" + i, "Магаладон", 5.2, "Зубастый"));
            }
            else if (i >= 6 && i <= 7) {
                animals.add(new Lisa("Лисы" + i, "красивые", 5.1, "Хитрый"));
            }
            else if (i >= 8 && i <= 9) {
                animals.add(new Dog("Четвероногие" + i, "Мопс", 8.2, "Добряк"));
            }
            i++;
        } while (i < 10);
        animals.forEach(System.out::println);
    }
}