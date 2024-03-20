package org.example.animal;

import org.example.animal.helpers.LocalDateFormatter;

import java.time.LocalDate;
import java.time.Period;

/**
 * Абстрактный класс параметров сущности Animal
 * @autor Самойлов Максим
 * @version 1.1
 */
public abstract class AbstractAnimal implements Animal {

    protected String breed; //порода
    protected String name; // имя
    protected Double cost; //цена в магазине
    protected String character; //характер
    protected LocalDate birthDate; //дата рождения

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return breed + " | " +
                name + " | " +
                cost + " | " +
                character + " | " +
                LocalDateFormatter.localDateToStringFormat(birthDate, "dd-MM-yyyy") + "\n";
    }
}