package Lesson1;

public class Team {
    private String teamName;
    private Competitor[] competitors;

    Team(String teamName) {
        this.teamName = teamName;
        this.competitors = new Competitor[]{
                new Sportsman("Bob", Sex.MALE),
                new Sportsman("John", Sex.MALE),
                new Sportsman("Meggy", Sex.FEMALE),
                new Sportsman("Alice", Sex.FEMALE)};
    }

    Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    Competitor[] getCompetitors() {
        return competitors;
    }

    void info() {
        System.out.printf("\nКоманада %s\n", teamName);
        System.out.println("---------------------------------------------------------");
        for (Competitor c :
                competitors) {
            c.info();
        }
        System.out.println("---------------------------------------------------------");

    }

    void showResults(Obstacle... obstacles) {
        for (Competitor c: competitors) {
            for (Obstacle o :
                    obstacles) {
                o.doIt(c);
                if(!c.isOnDistance()) {
                    break;
                }
            }
        }
    }

}
