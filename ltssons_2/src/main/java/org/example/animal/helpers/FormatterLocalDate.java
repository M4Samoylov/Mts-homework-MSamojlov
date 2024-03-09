package org.example.animal.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс для приведения LocalDate к формату dd-mm-yyyy
 * @autor Самойлов Максим
 * @version 1.1
 */
public class FormatterLocalDate {

    /**
     * Функция для приведения LocalDate (yyyy-MM-dd) к формату dd-mm-yyyy.
     * Возвращает строку в формате dd-mm-yyyy
     */
    public static String localDateToString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}