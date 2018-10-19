package Lesson2.RPG;

public class Warrior extends Hero {

    public Warrior(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    public String hit(Hero hero) {
        if (hero != this) {
            if (!isAlive) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
                return String.format("%s погиб и бить не может!\n", this.name);
            } else {
            int heroHealth = hero.getHealth();
            hero.causeDamage(damage);
            if (hero.getHealth() <= 0) {
                hero.isAlive = false;
            }
            System.out.printf("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), damage, hero.name, heroHealth, hero.getHealth());
            return String.format("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), damage, hero.name, heroHealth, hero.getHealth());
            }
        } else {
            return String.format("%s не может атаковать сам себя!\n", this.name);
        }
    }

    @Override
    public String healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
        return "Воины не умеют лечить!";
    }
}
