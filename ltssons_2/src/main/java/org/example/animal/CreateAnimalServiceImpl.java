package org.example.animal;

import org.example.animal.enumAnimal.*;

import java.util.Random;

/**
 * Класс сервиса для создания Животных (do-while/for цикл)
 * @autor Самойлов Максим
 * @version 1.1
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания животных циклом for.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    public void createAnimal(int N) {
        Pet pet = new Pet();
        Predator predator = new Predator();

        System.out.println("--------START createAnimal() for(i < N)");
        for (int i = 0; i < N; i++) {
            double rand = new Random().nextDouble();
            if (i % 2 == 0) {
                double start = 1;
                double end = 10;
                double result = start + (rand * (end - start));

                pet.setBreed(BreedPet.randomBreedPet());
                pet.setName(Name.randomName());
                pet.setCost(result);
                pet.setCharacter(CharacterPet.randomCharacterPet());

                System.out.print(i + " | ");
                System.out.print(pet);
            } else {
                double start = 11;
                double end = 20;
                double result = start + (rand * (end - start));

                predator.setBreed(BreedPredator.randomBreedPredator());
                predator.setName(Name.randomName());
                predator.setCost(result);
                predator.setCharacter(CharacterPredator.randomCharacterPredator());

                System.out.print(i + " | ");
                System.out.print(predator);
            }
        }
        System.out.println("--------END createAnimal() for(i < N)" + "\n");
    }

    /**
     * Функция создания животных циклом do-while.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    @Override
    public void createAnimal() {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Shark shark = new Shark();
        Random rand = new Random();
        int i = 0;

        System.out.println("--------START createAnimal() do-while(i < 10)");
        do {
            switch (i) {
                case 0:
                case 1:
                    cat.setBreed(BreedPet.randomBreedPet());
                    cat.setName(Name.randomName());
                    cat.setCost(cat.cost[rand.nextInt(cat.cost.length)]);
                    cat.setCharacter(CharacterPet.randomCharacterPet());

                    System.out.print(i + " | ");
                    System.out.print(cat);
                    break;
                case 2:
                case 3:
                    wolf.setBreed(BreedPredator.randomBreedPredator());
                    wolf.setName(Name.randomName());
                    wolf.setCost(wolf.cost[rand.nextInt(wolf.cost.length)]);
                    wolf.setCharacter(CharacterPredator.randomCharacterPredator());

                    System.out.print(i + " | ");
                    System.out.print(wolf);
                    break;
                case 4:
                case 5:
                    shark.setBreed(BreedPredator.randomBreedPredator());
                    shark.setName(Name.randomName());
                    shark.setCost(shark.cost[rand.nextInt(shark.cost.length)]);
                    shark.setCharacter(CharacterPredator.randomCharacterPredator());

                    System.out.print(i + " | ");
                    System.out.print(shark);
                    break;
                case 6:
                case 7:
                    fox.setBreed(BreedPredator.randomBreedPredator());
                    fox.setName(Name.randomName());
                    fox.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    fox.setCharacter(CharacterPredator.randomCharacterPredator());

                    System.out.print(i + " | ");
                    System.out.print(fox);
                    break;
                case 8:
                case 9:
                    dog.setBreed(BreedPet.randomBreedPet());
                    dog.setName(Name.randomName());
                    dog.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    dog.setCharacter(CharacterPet.randomCharacterPet());

                    System.out.print(i + " | ");
                    System.out.print(dog);
                    break;
            }
            i++;
        } while (i < 10);
        System.out.println("--------END createAnimal() do-while(i < 10)" + "\n");
    }
}