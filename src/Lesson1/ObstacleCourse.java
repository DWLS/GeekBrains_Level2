package Lesson1;

import java.util.Random;

public class ObstacleCourse {
    private static Random rand = new Random();

    private Obstacle[] obstacles;

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    ObstacleCourse() {
        obstacles = new Obstacle[] {
                new Cross(rand.nextInt(1) == 1 ? 4800 + rand.nextInt(500) : 4800 - rand.nextInt(500)),
                new Water(rand.nextInt(1) == 1 ? 110 + rand.nextInt(20) : 110 - rand.nextInt(20)),
                new Wall(rand.nextInt(1) == 1 ? 5 + rand.nextInt(1) : 5 - rand.nextInt(1))};
    }

    ObstacleCourse(Obstacle... obstacles) {
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
        System.out.println("ПОЛОСА ПРЕПЯТСТВИЙ");
        System.out.println("---------------------------------------------------------");
        for (Obstacle o :
                obstacles) {
            o.info();
        }
        System.out.println("---------------------------------------------------------");
    }

}