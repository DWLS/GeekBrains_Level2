package Lesson1;

import java.util.Random;

public class Course {
    private static Random rand = new Random();

    private Obstacle[] obstacles;

    Course() {
        obstacles = new Obstacle[] {
                new Cross(rand.nextInt(1) == 1 ? 4800 + rand.nextInt(500) : 4800 - rand.nextInt(500)),
                new Water(rand.nextInt(1) == 1 ? 100 + rand.nextInt(20) : 100 - rand.nextInt(20)),
                new Wall(rand.nextInt(1) == 1 ? 5 + rand.nextInt(1) : 5 - rand.nextInt(1))};
    }

    Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    void doIt(Team team) {
        for (Obstacle o :
                obstacles) {
            for (Competitor c :
                    team.getCompetitors()) {
                if (c.isOnDistance()) {
                    o.doIt(c);
                }
            }
        }
    }

    void info() {
        for (Obstacle o :
                obstacles) {
            o.info();
        }
    }

}
