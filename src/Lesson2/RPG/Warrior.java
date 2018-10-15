package Lesson2.RPG;

class Warrior extends Hero {

    Warrior(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    String hit(Hero hero) {
        if (hero != this) {
            if (this.health <= 0) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
                return String.format("%s погиб и бить не может!\n", this.name);
            } else {
            int heroHealth = hero.getHealth();
            hero.causeDamage(damage);
            System.out.printf("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), damage, hero.name, heroHealth, hero.getHealth());
            return String.format("%s(%d) наносит %d урона %s(%d -> %d)\n", this.name, this.getHealth(), damage, hero.name, heroHealth, hero.getHealth());
        }
    }
        return "";
    }

    @Override
    String healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
        return "Воины не умеют лечить!";
    }
}
