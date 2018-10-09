package Lesson2.Enums;

/*
Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заданному текущему дню.

 Возвращает кол-во оставшихся рабочих часов до конца
 недели по заданному текущему дню. Считается, что
 текущий рабочий день ещё не начался, и рабочие часы за него
 должны учитываться.
 */

public class DayOfWeekMain {

    public static void main(String[] args) {
        for (DayOfWeek dof :
                DayOfWeek.values()) {
            System.out.print(dof.getRusDayOfWeek() + " - ");
            getWorkingHours(dof);
        }
    }

    private static void getWorkingHours(DayOfWeek dof) {
        int workHoursPerWeek = 40;
        int workHoursPerDay = 8;

        if (dof != DayOfWeek.SATURDAY && dof != DayOfWeek.SUNDAY) {
            int workingHours = workHoursPerWeek - (dof.ordinal() * workHoursPerDay);

            String wordEnd = workingHours % 10 == 1 ? "": workingHours % 10 >= 2 && workingHours % 10 <= 4 ? "а" : workingHours % 10 >= 5 && workingHours < 20 ? "ов" : "ов";
            System.out.printf("Осталось отработать %d час%s.\n", workingHours, wordEnd);
        } else {
            System.out.print("Выходные!!! Отдыхаем!!!\n");
         }

    }
}