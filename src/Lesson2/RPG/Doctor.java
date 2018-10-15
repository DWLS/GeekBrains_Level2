package Lesson2.RPG;

class Doctor extends Hero {

    Doctor(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    String hit(Hero hero) {
        System.out.printf("Лекарь %s не может бить!\n", this.name);
        return String.format("Лекарь %s не может бить!\n", this.name);
    }

    @Override
    String healing(Hero hero) {
        if (this.health <= 0) {
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
