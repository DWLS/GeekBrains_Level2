package Lesson2.RPG;

import java.util.Random;

public class Assassin extends Hero {

    private Random critHit = new Random();

    public Assassin(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    public String hit(Hero hero) {
        if (hero != this) {
            if (!isAlive) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
                return String.format("%s погиб и бить не может!\n", this.name);
            } else {
                int currentDamage = damage + critHit.nextInt(20);
                int heroHealth = hero.getHealth();
                hero.causeDamage(currentDamage);
                if (hero.getHealth() <= 0) {
                    hero.isAlive = false;
                }
                System.out.printf("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), currentDamage, hero.name, heroHealth, hero.getHealth());
                return String.format("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), currentDamage, hero.name, heroHealth, hero.getHealth());
            }
        } else {
            return String.format("%s не может атаковать сам себя!\n", this.name);
        }
    }

    @Override
    public String healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
        return "Убийцы не умеют лечить!";
    }
}
