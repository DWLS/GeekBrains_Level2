package Lesson3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.
 */

import java.util.*;

public class UniqueWordsMain {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("струна");
        al.add("приют");
        al.add("принц");
        al.add("струна");
        al.add("ртуть");
        al.add("лицо");
        al.add("строгий");
        al.add("струна");
        al.add("отступать");
        al.add("японец");
        al.add("струна");
        al.add("колун");
        al.add("гнев");
        al.add("струна");
        al.add("колун");
        al.add("колун");
        al.add("негатив");
        al.add("престол");
        al.add("японец");
        al.add("престол");
        System.out.printf("В исходном списке всего %d слов:\n", al.size());
        System.out.println(al);
        Map<String, Integer> map = countUniqueWords(al);
        System.out.printf("В исходном списке %d уникальных слов:\n", map.size());
        for (String s:
             map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }

    private static Map<String, Integer> countUniqueWords (ArrayList<String> als) {
        Map<String, Integer> map = new HashMap<>();
        for (String s :
                als) {
            map.put(s, (map.containsKey(s)) ? map.get(s) + 1 : 1);
        }
        return map;
    }

}
