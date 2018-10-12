package Lesson3;

import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login, password;

        System.out.println("Придумайте логин:");
        login = sc.nextLine();
        do {
            System.out.println("Придумайте пароль:");
            password = sc.nextLine();
        } while (!isPassValidRegex(password));

        System.out.println(login + " " + password);

    }

    private static boolean isPassValid(String pass) {
        /*if (pass.length() < 8) return false;
        if (pass != )*/
        return true;
    }

    private static boolean isPassValidRegex(String pass) {
        String patternSymbols = "(" +
                "(?=.*[0-9])" +     // должен содержать минимум одну цифру
                "(?=.*[a-z])" +     // должен содержать минимум одну букву латиницы в нижнем регистре
                "(?=.*[A-Z])" +     // должен срдержать минимум одну букву латиницы в верхнеи регистре
                "." +               // любое совпадение с предыдущими условиями
                "{8,14}" +          // длина от 8 до 14 символов
                ")";
        Pattern pat = Pattern.compile(patternSymbols);
        Matcher match = pat.matcher(pass);

        return match.matches();
    }
}
