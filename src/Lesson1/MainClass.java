package Lesson1;

import static java.lang.Thread.sleep;

public class MainClass {
    public static void main(String[] args) {
        /*Competitor[] competitors = {
                new Human("Bob"),
                new Human("John"),
                new Human("Meggy"),
                new Human("Alice")};
        Obstacle[] obstacles = {
                new Cross(1500),
                new Wall(5),
                new Water(100)};*/

        //Course c = new Course(obstacles);                     // Создаем полосу препятствий с параметрами
        ObstacleCourse c = new ObstacleCourse();
        c.info();                                               // Информация о полосе препятствий
        //Team team = new Team("SuperTeam", competitors);       // Создаем команду с параметрами
        Team team = new Team("Dream Team");

        team.info();                                            // Начальная информация по участникам
        c.doIt(team);                                           // Просим команду пройти полосу
        team.showResults();                                     // Показываем результаты

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        team.info();
        c.doIt(team);
        team.showResults();

    }
}