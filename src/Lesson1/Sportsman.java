package Lesson1;

import java.util.Random;

public class Sportsman implements Competitor {
    private static Random rand = new Random();

    private String name;
    private Sex sex;

    private int maxRunDistance;
    private int maxJumpHeigth;
    private int maxSwimDistance;

    private boolean active;

    Sportsman(String name, Sex sex) {
        this.sex = sex;
        this.name = name;
        this.maxRunDistance = rand.nextInt(1) == 1 ? 5000 + rand.nextInt(500) : 5000 - rand.nextInt(500);
        this.maxSwimDistance = rand.nextInt(1) == 1 ? 140 + rand.nextInt(50) : 140 - rand.nextInt(50);
        this.maxJumpHeigth = rand.nextInt(1) == 1 ? 5 + rand.nextInt(1) : 5 - rand.nextInt(2);
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.printf("%s %s с кроссом!\n", name, sex == Sex.MALE ? "справился" : "справилась");
        } else {
            System.out.printf("%s не %s с кроссом!\n", name, sex == Sex.MALE ? "справился" : "справилась");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.printf("%s %s с заплывом!\n", name, sex == Sex.MALE ? "справился" : "справилась");
        } else {
            System.out.printf("%s не %s с заплывом!\n", name, sex == Sex.MALE ? "справился" : "справилась");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeigth) {
            System.out.printf("%s %s с высотой!\n", name, sex == Sex.MALE ? "справился" : "справилась");
        } else {
            System.out.printf("%s не %s с высотой!\n", name, sex == Sex.MALE ? "справился" : "справилась");
            active = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        if(!isOnDistance()) {
            System.out.printf("%s %s с дистанции\n", name, sex == Sex.MALE ? "сошёл" : "сошла");
        } else {
            System.out.printf("%s может пробежать %d метров, может проплыть %d метров, может преодолеть высоту %d метров.\n",
                    name,
                    maxRunDistance,
                    maxSwimDistance,
                    maxJumpHeigth);
        }
    }

}
