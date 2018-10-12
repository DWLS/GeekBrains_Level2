package Lesson2.Enums;

public enum DayOfWeek {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String rusDayOfWeek;

    DayOfWeek(String s) {
        rusDayOfWeek = s;
    }

    String getRusDayOfWeek() {
        return rusDayOfWeek;
    }
}
