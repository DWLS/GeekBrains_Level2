package Lesson2.Exceptions;

class MyArrayDataException extends RuntimeException {
    MyArrayDataException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Невозможно найти сумму элементов массива.";
    }
}
