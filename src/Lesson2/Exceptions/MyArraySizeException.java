package Lesson2.Exceptions;

class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Ошибка размерности массива.";
    }
}
