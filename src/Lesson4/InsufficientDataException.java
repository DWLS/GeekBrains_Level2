package Lesson4;

import java.io.IOException;

public class InsufficientDataException extends IOException {
    InsufficientDataException(String s) {
        super(s);
    }
}
