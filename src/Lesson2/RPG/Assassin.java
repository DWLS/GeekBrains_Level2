package Lesson2.RPG;

import java.util.Random;

public class Assassin extends Hero {

    private int criticalHit;
    private Random critHit = new Random();

    public Assassin(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    public String hit(Hero hero) {
        if (hero != this) {
            if (this.health <= 0) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
                return String.format("%s погиб и бить не может!\n", this.name);
            } else {
                int currentDamage = damage + critHit.nextInt(20);
                int heroHealth = hero.getHealth();
                hero.causeDamage(currentDamage);
                System.out.printf("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), currentDamage, hero.name, heroHealth, hero.getHealth());
                return String.format("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), currentDamage, hero.name, heroHealth, hero.getHealth());
            }
        }

        return "";
    }

    @Override
    public String healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
        return "Убийцы не умеют лечить!";
    }
}
