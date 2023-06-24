package kg.geeks.game.players;

public class Witcher extends Hero{

    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.SECOND_CHANCE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (Math.random()*10<4 && boss.getFirstBloodNumber() > -1){
            heroes[boss.getFirstBloodNumber()].setHealth(250);
            System.out.println("Witcher and " + heroes[boss.getFirstBloodNumber()].getName() + " were changed");
            this.setHealth(0);

        }
    }
}
