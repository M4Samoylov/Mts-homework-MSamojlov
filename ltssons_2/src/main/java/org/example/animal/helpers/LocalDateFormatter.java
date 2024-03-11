package org.example.animal.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс для приведения LocalDate к формату dd-mm-yyyy
 * @autor Самойлов Максим
 * @version 1.1
 */
public class LocalDateFormatter {

    /**
     * Функция для приведения LocalDate (yyyy-MM-dd) к формату передаваемому параметром String format.
     * Возвращает строку
     */
    public static String localDateToStringFormat(LocalDate localDate, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(formatter);
    }
}