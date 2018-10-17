package Lesson4;

/*
Необходимо рассчитать Индекс Массы Тела (Body Mass Index = BMI). Определяется она как вес делённый на рост в квадрате:

BMI = вес / рост^2
Здесь вес берется в килограммах, а рост в метрах.

На основании этого показателя выделяют четыре категории:

Underweight     -           BMI < 18.5      (недостаточная масса)
Normal weight   -   18.5 <= BMI < 25.0      (норма)
Overweight      -   25.0 <= BMI < 30.0      (избыточная масса)
Obesity         -   30.0 <= BMI             (ожирение)
Например, если я вешу 80 кг а мой рост 173 см то можно вычислить:

BMI = 80 / (1.73)^2 = 26.7
т.е. присутствует избыточный вес.

вес в килограммах и рост в метрах.
Ответ должен содержать одно из слов under, normal, over, obese, через пробел.
 */

public class RegexBMIMain {
    public static void main(String[] args) {
        String data =
                "118 2.05\n" +
                "106 1.77\n" +
                "87 1.83\n" +
                "45 1.12\n" +
                "70 1.87\n" +
                "54 1.57\n" +
                "105 1.76\n" +
                "50 1.96\n" +
                "114 1.76\n" +
                "72 2.45\n" +
                "53 2.10\n" +
                "66 2.25\n" +
                "54 1.50\n" +
                "95 1.62\n" +
                "86 1.72\n" +
                "62 1.57\n" +
                "65 2.24\n" +
                "72 1.43\n" +
                "93 2.01\n" +
                "109 3.01\n" +
                "106 2.97\n" +
                "77 1.69\n" +
                "114 2.09\n" +
                "98 1.72\n" +
                "85 2.46\n" +
                "113\n" +
                "53 1.77\n" +
                "106 2.30";

        calcBMIFromData(data);

    }

    private static void calcBMIFromData (String s) {
        for (String aS1 : s.split("\n")) {
            System.out.println(BMI(aS1.split("\\s+")));
        }
    }

    private static String BMI(String[] s) {
        double bmi;

        if (s.length < 2) {
            try {
                throw new InsufficientDataException("Недостаточно данных для расчётов!");
            } catch (InsufficientDataException e) {
                return e.getMessage();
            }
        }

        double weight = Double.valueOf(s[0]);
        double height = Double.valueOf(s[1]);

        bmi = weight / Math.pow(height, 2);
        String info = weight + " " + height;

        if (bmi < 18.5) {
            return info + " under";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            return info + " normal";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            return info + " over";
        } else {
            return info + " obese";
        }
    }
}
