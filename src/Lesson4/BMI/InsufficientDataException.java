package Lesson4.BMI;

import java.io.IOException;

public class InsufficientDataException extends IOException {
    InsufficientDataException(String s) {
        super(s);
    }
}
