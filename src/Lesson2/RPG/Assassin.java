package Lesson2.RPG;

import java.util.Random;

class Assassin extends Hero {

    private int cricitalHit;

    Assassin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        Random random = new Random();
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
