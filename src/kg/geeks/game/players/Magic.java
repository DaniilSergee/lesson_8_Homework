package kg.geeks.game.players;

public class Magic extends Hero {
    private int damagePoints;
    public Magic(int health, int damage, int damagePoints, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.damagePoints = damagePoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 1; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 ){
                heroes[i].setDamage(heroes[i].getDamage() + this.damagePoints);
            }
        }
    }
}
