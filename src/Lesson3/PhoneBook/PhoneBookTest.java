package Lesson3.PhoneBook;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */

import java.util.HashMap;
import java.util.Map;

public class PhoneBookTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        PhoneBook pb = new PhoneBook(map);
        pb.addRecord("9005568589", "Иванов");
        pb.addRecord("9005568592", "Петров");
        pb.addRecord("9005568593", "Сидоров");
        pb.addRecord("9005568594", "Соловьёв");
        pb.addRecord("9005568595", "Петров");
        pb.addRecord("9005568599", "Зверев");
        pb.addRecord("9005568685", "Сергеев");
        pb.addRecord("9005568966", "Петров");
        pb.addRecord("9005568485", "Шутов");
        pb.addRecord("9005568789", "Иванов");

        pb.print();

        System.out.println("Поиск по фамилии Иванов: " + pb.getNumber("Иванов"));
        System.out.println("Поиск по фамилии Петров: " + pb.getNumber("Петров"));
        System.out.println("Поиск по фамилии Чичиков: " + pb.getNumber("Чичиков"));
    }

}