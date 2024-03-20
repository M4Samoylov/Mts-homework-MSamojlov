package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Класс сервиса для HW-6
 *
 * @version 1.1
 * @autor Самойлов Максим
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    /**
     * Функция для формирования Map животных рождённых в високосный год.
     *
     * @return Map<String, LocalDate>
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        return animals.stream()
                .filter(p -> p.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(
                        s -> s.getClass().getSimpleName() + " " + s.getName(),
                        AbstractAnimal::getBirthDate));
    }

    /**
     * Функция для формирования Map содержащим животных возраст которых > N.
     * Если нет подходящих под условие животных -> в Map будет содержать самое старое животное
     *
     * @return Map<AbstractAnimal, Integer>
     */
    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, int N) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        Map<AbstractAnimal, Integer> result;

        result = animals.stream()
                .filter(p -> p.getAge() > N)
                .collect(Collectors.toMap(s -> s, AbstractAnimal::getAge));

        if (result.isEmpty()) {
            AbstractAnimal oldAgeAnimal = animals.stream()
                    .max(Comparator.comparing(AbstractAnimal::getAge))
                    .get();
            result.put(oldAgeAnimal, oldAgeAnimal.getAge());
        }

        return result;
    }

    /**
     * Функция для формирования Map содержащим перечисления ключ - Тип животного, значение - количество List дубликатов.
     *
     * @return Map<String, List<AbstractAnimal>>
     */
    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        return animals.stream()
                .collect(groupingBy(p -> p.getClass().getSimpleName()));
    }

    /**
     * Функция для подсчёта среднего возраста всех животных из списка.
     *
     * @return double
     */
    @Override
    public double findAverageAge(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        double averageAge = animals.stream()
                .mapToInt(AbstractAnimal::getAge)
                .average()
                .orElseThrow(() -> new RuntimeException("Не удалось подсчитать средний возраст"));

        System.out.println(averageAge);

        return averageAge;
    }

    /**
     * Функция возвращающая список животных возраст которых более 5 лет
     * и стоимостью больше среднего (по отношению ко всем животным).
     * @return List<AbstractAnimal>
     */
    @Override
    public List<AbstractAnimal> findOldAndExpensive(List<AbstractAnimal> animals) throws InvalidAnimalException {
        double averageCost = getAverageCost(animals);

        List<AbstractAnimal> result = animals.stream()
                .filter(p -> p.getAge() > 5 && p.getCost() > averageCost)
                .sorted(Comparator.comparing(AbstractAnimal::getBirthDate))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new RuntimeException("Нет подходящих под условия животных");
        }

        return result;
    }

    /**
     * Функция возвращающая среднюю стоимость животного (по отношению ко всем животным в списке).
     * @return double
     */
    private static double getAverageCost(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        return animals.stream()
                .mapToDouble(AbstractAnimal::getCost)
                .average()
                .orElseThrow(() -> new RuntimeException("Не удалось подсчитать среднюю стоимость животного"));
    }

    /**
     * Функция возвращает список Имён (размер списка <= 3) животных с наименьшей ценой в передаваемом списке.
     * @return List<String>
     */
    @Override
    public List<String> findMinConstAnimals(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        return animals.stream()
                .sorted(Comparator.comparing(AbstractAnimal::getCost))
                .limit(3)
                .map(AbstractAnimal::getName)
                .sorted((p1, p2) -> -p1.compareTo(p2))
                .collect(Collectors.toList());
    }
}