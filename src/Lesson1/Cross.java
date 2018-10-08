package Lesson1;

public class Cross extends Obstacle {
    private int length;

    Cross(int length) {
        this.length = length;
    }

    @Override
    void doIt(Competitor competitor) {
        competitor.run(length);
    }

    @Override
    void info() {
        System.out.printf("Длина беговой дистанции %d метров\n", length);
    }
}