package Lesson2.RPG;

public class Doctor extends Hero {

    public Doctor(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    public String hit(Hero hero) {
        System.out.printf("Лекарь %s не может атаковать!\n", this.name);
        return String.format("Лекарь %s не может атаковать!\n", this.name);
    }

    @Override
    public String healing(Hero hero) {
        if (!this.isAlive) {
            System.out.printf("%s погиб и лечить не может!\n", this.name);
            return String.format("%s погиб и лечить не может!\n", this.name);
        } else {
            int heroHealth = hero.getHealth();
            hero.addHealth(addHeal);
            System.out.printf("%s(%d) вылечил %d единиц %s(%d -> %d)\n", this.name, this.health, this.addHeal, hero.name, heroHealth, hero.getHealth());
            return String.format("%s(%d) вылечил %d единиц %s(%d -> %d)\n", this.name, this.health, this.addHeal, hero.name, heroHealth, hero.getHealth());
        }
    }
}
