package Lesson1;

public class Water extends Obstacle {
    private int length;

    Water(int length) {
        this.length = length;
    }

    @Override
    void doIt(Competitor competitor) {
        competitor.swim(length);
    }

    @Override
    void info() {
        System.out.printf("Длина бассейна %d метров\n", length);
    }
}