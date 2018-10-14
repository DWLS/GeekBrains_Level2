package Lesson3;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private static final String COUNTRY_CODE_RU = "+7";
    public static void main(String[] args) {
        // ключом будет номер телефона, т.к. он не может повторяться, а значением будут фамилии, т.к. возможны однофамильцы
        Map<String, String> phoneBook = new TreeMap<>();
        add(phoneBook, "9005568589", "Ivanov");
        add(phoneBook, "9005568592", "Petrov");
        add(phoneBook, "9005568593", "Sidorov");
        add(phoneBook, "9005568594", "Solov'yov");
        add(phoneBook, "9005568595", "Petrov");
        add(phoneBook, "9005568599", "Zverev");
        add(phoneBook, "9005568685", "Sergeev");
        add(phoneBook, "9005568966", "Ivanchenko");
        add(phoneBook, "9005568485", "Shutov");
        add(phoneBook, "9005568789", "Ivanov");
        for (String s :
                phoneBook.keySet()) {
            System.out.println(phoneBook.get(s) + " " + s);
        }

        get(phoneBook, "Ivanov");

    }

    private static void add(Map<String, String> hm, String phoneNumber, String surname) {
        hm.put(COUNTRY_CODE_RU + phoneNumber, surname);
    }

    static ArrayList<String> get(Map<String, String> map, String surname) {
        return new ArrayList<>();
    }
}
