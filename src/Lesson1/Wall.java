package Lesson1;

public class Wall extends Obstacle {
    private int heigth;

    Wall(int heigth) {
        this.heigth = heigth;
    }

    @Override
    void doIt(Competitor competitor) {
        competitor.jump(heigth);
    }

    @Override
    void info() {
        System.out.printf("Высота стены %d метров\n", heigth);
    }
}