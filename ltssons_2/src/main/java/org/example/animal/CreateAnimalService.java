package org.example.animal;

import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {

    default void createAnimal(){
        List<Animal> animals = new ArrayList<>();
        int i = 0;
        while (i <= 10) {
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
        }
        animals.forEach(System.out::println);
    }
}