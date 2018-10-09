package Lesson2;

import static java.lang.Integer.valueOf;

public class MainClass {

    public static void main(String[] args) {

        String[][] stringArray = new String[][] {
                {"5", "g", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };

        try {
            System.out.println("Сумма элементов массива равна " + transformAndSum(stringArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e + " " + e.getMessage());
        }


    }

    private static int transformAndSum (String[][] in) throws MyArraySizeException, MyArrayDataException {
        int arrDim = 4;
        int sum = 0;

        if (in.length != 4) {
            throw new MyArraySizeException(String.format("Размерность массива должна быть %d*%d.", arrDim, arrDim));
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i].length != 4) {
                throw new MyArraySizeException(String.format("Размерность массива должна быть %d*%d.", arrDim, arrDim));
            }
        }


        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                try {
                    sum += valueOf(in[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится нечисло %s.", i, j, in[i][j]));
                }
            }
        }


        return sum;
    }
}

class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Ошибка размерности массива.";
    }
}

class MyArrayDataException extends RuntimeException {
    MyArrayDataException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Невозможно найти сумму элементов массива.";
    }
}
