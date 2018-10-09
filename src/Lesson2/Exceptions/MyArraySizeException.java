package Lesson2.Exceptions;

class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super("Ошибка размерности массива.\n" + " " + msg);
    }

}
