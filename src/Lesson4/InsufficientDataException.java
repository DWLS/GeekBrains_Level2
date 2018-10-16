package Lesson4;

public class InsufficientDataException extends Exception {
    InsufficientDataException() {
        super("Недостаточно данных!");
    }
}
