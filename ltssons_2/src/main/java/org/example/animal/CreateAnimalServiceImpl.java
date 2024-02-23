package org.example.animal;

import java.util.Random;

/**
 * Класс сервиса для создания Животных (do-while/for цикл)
 * @autor Самойлов Максим
 * @version 1.1
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания животных циклом for
     * Выводит в консоль породу/имя/цену/характер животного
     */
    public void createAnimal(int N) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Shark shark = new Shark();
        Random rand = new Random();

        System.out.println("--------START");
        for (int i = 0; i < N; i++) {
            switch (i) {
                case 0:
                case 1:
                    cat.setBreed(cat.breed[rand.nextInt(cat.breed.length)]);
                    cat.setName(cat.name[rand.nextInt(cat.name.length)]);
                    cat.setCost(cat.cost[rand.nextInt(cat.cost.length)]);
                    cat.setCharacter(cat.character[rand.nextInt(cat.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(cat.getBreed() + " | ");
                    System.out.print(cat.getName() + " | ");
                    System.out.print(cat.getCost() + " | ");
                    System.out.println(cat.getCharacter());
                    break;
                case 2:
                case 3:
                    wolf.setBreed(wolf.breed[rand.nextInt(wolf.breed.length)]);
                    wolf.setName(wolf.name[rand.nextInt(wolf.name.length)]);
                    wolf.setCost(wolf.cost[rand.nextInt(wolf.cost.length)]);
                    wolf.setCharacter(wolf.character[rand.nextInt(wolf.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(wolf.getBreed() + " | ");
                    System.out.print(wolf.getName() + " | ");
                    System.out.print(wolf.getCost() + " | ");
                    System.out.println(wolf.getCharacter());
                    break;
                case 4:
                case 5:
                    shark.setBreed(shark.breed[rand.nextInt(shark.breed.length)]);
                    shark.setName(shark.name[rand.nextInt(shark.name.length)]);
                    shark.setCost(shark.cost[rand.nextInt(shark.cost.length)]);
                    shark.setCharacter(shark.character[rand.nextInt(shark.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(shark.getBreed() + " | ");
                    System.out.print(shark.getName() + " | ");
                    System.out.print(shark.getCost() + " | ");
                    System.out.println(shark.getCharacter());
                    break;
                case 6:
                case 7:
                    fox.setBreed(fox.breed[rand.nextInt(fox.breed.length)]);
                    fox.setName(fox.name[rand.nextInt(fox.name.length)]);
                    fox.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    fox.setCharacter(fox.character[rand.nextInt(fox.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(fox.getBreed() + " | ");
                    System.out.print(fox.getName() + " | ");
                    System.out.print(fox.getCost() + " | ");
                    System.out.println(fox.getCharacter());
                    break;
                case 8:
                case 9:
                    dog.setBreed(dog.breed[rand.nextInt(dog.breed.length)]);
                    dog.setName(dog.name[rand.nextInt(dog.name.length)]);
                    dog.setCost(dog.cost[rand.nextInt(dog.cost.length)]);
                    dog.setCharacter(dog.character[rand.nextInt(dog.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(dog.getBreed() + " | ");
                    System.out.print(dog.getName() + " | ");
                    System.out.print(dog.getCost() + " | ");
                    System.out.println(dog.getCharacter());
                    break;
                default:
                    System.out.println("Ошибка, передано число не входящее в промежуток от 0 до 9");
            }
        }
        System.out.println("--------END");
    }

    /**
     * Функция создания животных циклом do-while
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

        System.out.println("--------START");
        do {
            switch (i) {
                case 0:
                case 1:
                    cat.setBreed(cat.breed[rand.nextInt(cat.breed.length)]);
                    cat.setName(cat.name[rand.nextInt(cat.name.length)]);
                    cat.setCost(cat.cost[rand.nextInt(cat.cost.length)]);
                    cat.setCharacter(cat.character[rand.nextInt(cat.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(cat.getBreed() + " | ");
                    System.out.print(cat.getName() + " | ");
                    System.out.print(cat.getCost() + " | ");
                    System.out.println(cat.getCharacter());
                    break;
                case 2:
                case 3:
                    wolf.setBreed(wolf.breed[rand.nextInt(wolf.breed.length)]);
                    wolf.setName(wolf.name[rand.nextInt(wolf.name.length)]);
                    wolf.setCost(wolf.cost[rand.nextInt(wolf.cost.length)]);
                    wolf.setCharacter(wolf.character[rand.nextInt(wolf.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(wolf.getBreed() + " | ");
                    System.out.print(wolf.getName() + " | ");
                    System.out.print(wolf.getCost() + " | ");
                    System.out.println(wolf.getCharacter());
                    break;
                case 4:
                case 5:
                    shark.setBreed(shark.breed[rand.nextInt(shark.breed.length)]);
                    shark.setName(shark.name[rand.nextInt(shark.name.length)]);
                    shark.setCost(shark.cost[rand.nextInt(shark.cost.length)]);
                    shark.setCharacter(shark.character[rand.nextInt(shark.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(shark.getBreed() + " | ");
                    System.out.print(shark.getName() + " | ");
                    System.out.print(shark.getCost() + " | ");
                    System.out.println(shark.getCharacter());
                    break;
                case 6:
                case 7:
                    fox.setBreed(fox.breed[rand.nextInt(fox.breed.length)]);
                    fox.setName(fox.name[rand.nextInt(fox.name.length)]);
                    fox.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    fox.setCharacter(fox.character[rand.nextInt(fox.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(fox.getBreed() + " | ");
                    System.out.print(fox.getName() + " | ");
                    System.out.print(fox.getCost() + " | ");
                    System.out.println(fox.getCharacter());
                    break;
                case 8:
                case 9:
                    dog.setBreed(dog.breed[rand.nextInt(dog.breed.length)]);
                    dog.setName(dog.name[rand.nextInt(dog.name.length)]);
                    dog.setCost(dog.cost[rand.nextInt(dog.cost.length)]);
                    dog.setCharacter(dog.character[rand.nextInt(dog.character.length)]);

                    System.out.print(i + " | ");
                    System.out.print(dog.getBreed() + " | ");
                    System.out.print(dog.getName() + " | ");
                    System.out.print(dog.getCost() + " | ");
                    System.out.println(dog.getCharacter());
                    break;
            }
            i++;
        } while (i < 10);
        System.out.println("--------END");
    }
}