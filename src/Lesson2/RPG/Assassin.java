package Lesson2.RPG;

import java.util.Random;

class Assassin extends Hero {

    private Random critHit = new Random();

    Assassin(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(this.health <= 0) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
            } else {
                int currentDamage = damage + critHit.nextInt(20);   // уровень убийцы на каждом ходу равен "базовый уровень + случайный критический урон"
                hero.causeDamage(currentDamage);
                System.out.printf("%s(%d) наносит %d урона %s(%d)\n", this.name, this.getHealth(), currentDamage, hero.name, hero.getHealth());

            }
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
