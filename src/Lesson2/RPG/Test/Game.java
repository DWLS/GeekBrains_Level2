package Lesson2.RPG.Test;

import Lesson2.RPG.Assassin;
import Lesson2.RPG.Doctor;
import Lesson2.RPG.Hero;
import Lesson2.RPG.Warrior;

import java.util.Random;

class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        Random randomHit = new Random();
        int round = 20;

        Hero[] team1 = new Hero[] {
                new Warrior(250, "Тигрил", 50, 0),
                new Assassin(150, "Акали", 70, 0),
                new Doctor(120, "Жанна", 0, 70)
        };


        Hero[] team2 = new Hero[] {
                new Warrior(240, "Минотавр", 60, 0),
                new Assassin(160, "Джинкс", 60, 0),
                new Doctor(110, "Зои", 0, 80)
        };

        for (int j = 0; j < round; j++) {
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    System.out.print("Ход игрока первой команды: ");
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(3)]); // доктор может лечить в том числе и себя
                    } else {
                        team1[i].hit(team2[randomHit.nextInt(3)]);
                    }
                } else {
                    System.out.print("Ход игрока второй команды: ");
                    if(team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(3)]); // доктор может лечить в том числе и себя
                    } else {
                        team2[i].hit(team1[randomHit.nextInt(3)]);
                    }
                }
            }
        }

        System.out.println("__________________");
        System.out.println("| ИТОГИ СРАЖЕНИЯ |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }
}
