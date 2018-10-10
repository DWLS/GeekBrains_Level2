package Lesson2.RPG;

class Doctor extends Hero {

    Doctor(int health, String name, int damage, int addHeal) {
        super(health,
                name,
                damage,
                addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.printf("Доктор %s не может бить!\n", this.name);
    }

    @Override
    void healing(Hero hero) {
        if (this.health <= 0) {
            System.out.printf("%s погиб и лечить не может\n", this.name);
        } else {
            hero.addHealth(addHeal);
            System.out.printf("%s(%d) вылечил %d единиц %s(%d)\n", this.name, this.getHealth(), this.addHeal, hero.name, hero.getHealth());
        }

    }
}
