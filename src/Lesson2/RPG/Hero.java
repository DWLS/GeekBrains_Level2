package Lesson2.RPG;

public abstract class Hero {

    int maxHealth;
    int health;
    String name;
    int damage;
    int addHeal;
    boolean isAlive;

    public Hero(int maxHealth, String name, int damage, int addHeal) {
        this.maxHealth = maxHealth; // максимальный уровень здоровья у героя
        this.health = maxHealth;    // текущий уровень здоровья у героя, в начале боя равен максимальному уровню здоровья
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
        this.isAlive = true;
    }

    public abstract String hit(Hero hero);

    public abstract String healing(Hero hero);

    void causeDamage(int damage) {
        if (health > 0) {
            health -= damage;
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        if (health <= 0) {
            return 0;
        } else {
            return health;
        }
    }

    public void addHealth(int heal) {
        if ((health + heal) > maxHealth) {      // если произведённое лечение превышает уровень максимального здоровья
            health = maxHealth;                 // уровень здоровья героя делаем максимальным - просто произошёл "оверхил"
        } else {
            health += heal;
        }
    }

    public String info() {
        System.out.println(name + " " + (!isAlive ? "Герой мёртв" : health) + " " + damage + " " + addHeal);
        return name + " " + (!isAlive ? "Герой мёртв" : health) + " " + damage + " " + addHeal;
    }
}
