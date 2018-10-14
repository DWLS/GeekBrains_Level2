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
            /* 1. ===============================
               // в map помещаем ключ s и, если ключ встречается впервые, значением устанавливаем 1.
               // Если ключ уже есть в map, то увеличиваем значение на 1 - имитируем счётчик слов
             */
            // map.put(s, (map.containsKey(s)) ? map.get(s) + 1 : 1);

            /* 2. ===============================
               // если не использовать проверку map.containsKey(), то форма добавления в map: map.put(s, map.get(s) + 1) - первое добавление может вызвать NullPointerException
               // вызов вначале putIfAbsent() решает эту проблему - вносим 0, чтобы там не оказалось null,
               // а второй строчкой уже увеличиваем на 1 и далее...
               // теперь точно известно, что операция будет выполнена без возможного выброса исключения
             */
            // map.putIfAbsent(s, 0);
            // map.put(s, map.get(s) + 1);

            /* 3. ===============================
               // можно использовать метод getOrDefault(), также решающий проблему с NullPointerException:
               // если ключа нет в map, то возвращаем ((defaultValue: 0) + 1) = 1, если ключ уже есть, возвращаем ((значение) + 1)
             */
               map.put(s, map.getOrDefault(s, 0) + 1);

            /* 4. ===============================
               // мeтод merge() принимает ключ, значение и функцию, которая объединяет заданное значение и уже существующее в map, если таковое имеется.
               // Если в map под заданным ключом значения нет, то кладет туда указанное значение.
             */
            // map.merge(s, 1, (a, b) -> a + b /*Integer::sum*/);


        }
        /* 5. ===============================
           // используя всю силу Java8
         */
           // als.forEach(s -> map.merge(s, 1, Integer::sum);

        return map;
    }

}
