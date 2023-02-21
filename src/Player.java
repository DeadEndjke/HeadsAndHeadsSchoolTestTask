public class Player extends Creature {

    private int maxHp;
    private int healCount;

    public Player(int hp, int attack, int armor, int minDamage, int maxDamage) {
        super(hp, attack, armor, minDamage, maxDamage);
        this.maxHp = hp;
        this.healCount = 3;
    }
    private void heal(){
        this.setHp(this.getHp() + maxHp/2);
        System.out.println("/////////");
        System.out.println("healed!!");
        System.out.println("/////////");
    }


    @Override
    public void attack(Creature enemy){
        if (this.getHp() < maxHp/2 & healCount > 0) {
            heal();
        }
        super.attack(enemy);
    }
}
