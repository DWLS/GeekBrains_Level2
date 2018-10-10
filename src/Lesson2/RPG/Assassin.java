package Lesson2.RPG;

import java.util.Random;

class Assassin extends Hero {

    private int criticalHit;
    private Random critHit = new Random();

    Assassin(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(this.health <= 0) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
            } else {
                int currentDamage = damage + critHit.nextInt(20);
                System.out.printf("%s(%d) наносит %d урона %s(%d)\n", this.name, this.getHealth(), currentDamage, hero.name, hero.getHealth());
                hero.causeDamage(currentDamage);
            }
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
