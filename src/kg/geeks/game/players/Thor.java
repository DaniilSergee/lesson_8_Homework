package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Thor extends Hero{

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }
    public Boolean isBossStuned() {
        if (Math.random()*10< 3 && this.getHealth()>0){
            return true;
        }else {
            return false;
        }

    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (isBossStuned()){
            boss.setDamage(0);
            System.out.println("Boss was stunned for the next Round");
        }else{
            boss.setDamage(50);
        }
    }
}
