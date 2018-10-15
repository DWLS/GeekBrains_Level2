package Lesson3.PhoneBook;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */

import java.util.ArrayList;
import java.util.Map;

class PhoneBook {
    // импровизированная БД на основании HashMap:
    // в качестве ключа используем номер телефона, т.к. он уникальный,
    // а значением будут фамилии т.к. возможны однофамильцы.
    // если использовать TreeMap, телефонная книга будет упорядочена по ключу, т.е. номеру телефона
    private Map<String, String> phoneBook;
    // код страны - просто для большей реалистичности
    private final String COUNTRY_CODE_RU = "+7";

    PhoneBook(Map<String, String> map) {
        phoneBook = map;
    }

    // добавляет запись с номером телефона и фамилией в импровизированную БД
    void addRecord(String phone, String surname) {
        phoneBook.put(COUNTRY_CODE_RU + phone, surname);
    }

    // удаляет запись по номеру телефона
    void delRecord(String phone) {
        phoneBook.remove(COUNTRY_CODE_RU + phone);
    }

    // выводит на печать телефонный справочник
    void print() {
        System.out.println("Телефонный справочник:");
        System.out.println("======================");
        phoneBook.forEach((key, value) -> System.out.println(value + ": " + key));
    }

    // поиск фамилии абонента по номеру телефона
    // метода нет в задании, но для полноты, кмк, он не помешает
    String getSurname(String number) {
        String result = phoneBook.get(COUNTRY_CODE_RU + number);
        if (result == null) {
            return "Абонент с таким номером не найден.";
        }
        return result;
    }

    // поиск номера телефона (или же номеров телефонов) по фамилии
    // в случае однофамильцев возвращает все телефоны под этой фамилией
    ArrayList<String> getNumber(String surname) {
        ArrayList<String> result = new ArrayList<>();
        phoneBook.forEach((key, value) -> {
            if (surname.equalsIgnoreCase(value)) {
                result.add(value + ": " + key);
            }
        });
        if (result.size() == 0) {
            result.add("Абонент с такой фамилией не найден");
        }
        return result;
    }

}