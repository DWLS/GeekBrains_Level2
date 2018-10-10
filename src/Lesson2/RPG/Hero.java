package Lesson2.RPG;

abstract class Hero {

    int health;
    String name;
    int damage;
    int addHeal;

    Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        /*if(health <= 0) {
            System.out.printf("%s уже мёртвый!\n", this.name);
        } else {*/
        if (health > 0) {
            health -= damage;
        }

        //}

    }

    public int getDamage() {
        return damage;
    }

    int getHealth() {
        if (health <= 0) {
            return 0;
        } else {
            return health;
        }

    }

    void addHealth(int heal) {
        health += heal;
    }

    void info() {
        System.out.println(name + " " + (health <= 0 ? "Герой мёртв" : health) + " " + damage);
    }
}
