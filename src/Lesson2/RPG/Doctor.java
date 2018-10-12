package Lesson2.RPG;

class Doctor extends Hero {

    Doctor(int maxHealth, String name, int damage, int addHeal) {
        super(maxHealth, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.printf("Доктор %s не может бить!\n", this.name);
    }

    @Override
    void healing(Hero hero) {
        if (this.health <= 0) {
            System.out.printf("%s погиб и лечить не может!\n", this.name);
        } else {
            int currentHealth = this.health;            // если доктор лечит сам себя, то сначала показываем, сколько у него было здоровья, а потом - сколько стало
            hero.addHealth(addHeal);
            System.out.printf("%s(%d) вылечил %d единиц %s(%d)\n", this.name, currentHealth, this.addHeal, hero.name, hero.getHealth());
        }

    }
}
