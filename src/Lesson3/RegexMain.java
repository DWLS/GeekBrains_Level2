package Lesson3;

import java.util.Scanner;

/* Необходимо из консоли считать пароль и проверить валидность,
результат будет true или false

Требования:
1. Пароль должен быть не менее 8ми символов.
2. В пароле должно быть число
3. В пароле должна быть хотя бы 1 строчная буква
4. В пароле должна быть хотя бы 1 заглавная буква
*/

public class RegexMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login, password;

        System.out.println("Придумайте логин:");
        login = sc.nextLine();
        do {
            System.out.println("Придумайте пароль (от 8 до 14 символов, минимум одна цифра, одна большая и одна маленькая буквы латиницы и [@#]):");
            password = sc.nextLine();
        } while (!isPassValid(password));

        System.out.println(login + " " + password);

    }

    private static boolean isPassValid(String pass) {
        // проверку на цифры и символы можно объединить в одни [] но так, кмк, нагляднее
        String patternSymbols = "(" +
                "(?=.*[0-9])" +     // цифры от 0 до 9
                "(?=.*[a-z])" +     // латиница от a до z
                "(?=.*[A-Z])" +     // латиница от A до Z
                "(?=.*[@#])" +      // один из символов @ или #
                "(?=\\S+$)" +       // отсутствие пробельных символов
                ".{8,16}" +         // длиной от 8 до 16 символов
                ")";
        // данная проверка избыточна, но другого способа указать пользователю на неверную длину пароля пока не нашёл
        if (pass.length() < 8 || pass.length() > 14) {
            System.out.println("Пароль не соответствует требованиям к длине!");
            return false;
        }
        if (!pass.matches(patternSymbols)) {
            System.out.println("Пароль не соответствует требованиям к наличию символов!");
            return false;
        }

        return true;
    }
}
