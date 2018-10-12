package Lesson2.RPG;

class Warrior extends Hero {

    Warrior(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(this.health <= 0) {
                System.out.printf("%s погиб и бить не может!\n", this.name);
            } else {
                hero.causeDamage(damage);
                System.out.printf("%s(%d) наносит %d урона %s(%d)\n", this.name, this.getHealth(), damage, hero.name, hero.getHealth());

            }

        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
    }
}
