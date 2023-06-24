package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;
    private int firstBloodNumber = -1;
    private int counter = 0;


    public int getFirstBloodNumber() {
        return firstBloodNumber;
    }

    public int getCounter() {
        return counter;
    }

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence() {

        SuperAbility[] allDifferentAbilities = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(allDifferentAbilities.length); // 0,1,2,3
        this.defence = allDifferentAbilities[randomIndex];
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk) {
                    if (this.defence != heroes[i].getAbility()) {
                        int blocked = (RPG_Game.random.nextInt(5) + 2) * 5; //2,3,4,5
                        heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - blocked));
                        ((Berserk) heroes[i]).setBlockedDamage(blocked);
                    } else {
                        ((Berserk) heroes[i]).setBlockedDamage(0);
                        heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                    }
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
            if (heroes[i].getHealth() <= 0 && counter ==0) {
                counter =1;
                firstBloodNumber =i;
                System.out.println("First Blood is " + heroes[i].getName() );
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " DEFENCE: " + this.defence;
    }
}
