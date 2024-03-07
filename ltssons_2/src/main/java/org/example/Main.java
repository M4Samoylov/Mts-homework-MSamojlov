package org.example;

import org.example.animal.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        CreateAnimalService createAnimalServiceCycleWhile = new CreateAnimalService() {
            @Override
            public void createAnimal() {
                CreateAnimalService.super.createAnimal();
            }
        };

        //createAnimal() cycle while
        createAnimalServiceCycleWhile.createAnimal();
        //createAnimal() cycle do-while
        createAnimalServiceImpl.createAnimal();
        //createAnimal() cycle for
        createAnimalServiceImpl.createAnimal(3);
    }
}