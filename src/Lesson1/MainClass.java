package Lesson1;

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
        Course c = new Course();
        c.info();                                               // Информация о полосе препятствий
        //Team team = new Team("SuperTeam", competitors);       // Создаем команду с параметрами
        Team team = new Team("SuperTeam");
        team.info();                                            // Начальная информация по участникам
        c.doIt(team);                                           // Просим команду пройти полосу
        team.showResults();                                     // Показываем результаты
        team.info();                                            // Конечная информация по участникам
        System.out.println();
        c.doIt(team);
        team.info();
    }
}