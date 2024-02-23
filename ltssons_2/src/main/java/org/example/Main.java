package org.example;

import org.example.animal.CreateAnimalService;
import org.example.animal.CreateAnimalServiceImpl;

public class Main {

    public static void main(String[] args) {
        //при попытке вызова createAnimalService.createAnimal()
        //вызывается ПЕРЕОПРЕДЕЛЁННЫЙ createAnimalServiceImpl.createAnimal(), а не дефолтный (как по заданию)
        //видимо это хитрость в задании)))
        CreateAnimalService createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimal();

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        createAnimalServiceImpl.createAnimal(2);
        createAnimalServiceImpl.createAnimal();
    }
}