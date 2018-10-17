package Lesson4;

class WrongDataException extends Exception {
    WrongDataException() {
        super("Нечисловые данные");
    }
}
