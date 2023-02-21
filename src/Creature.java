
public class Creature {
    private int hp;
    private int attack;

    private int armor;
    private int minDamage;
    private int maxDamage;

    public Creature(int hp, int attack, int armor, int minDamage, int maxDamage) {
        if(attackAndArmorCheck(attack, armor) & hpCheck(hp) & damageCheck(minDamage, maxDamage)){
            this.hp = hp;
            this.attack = attack;
            this.armor = armor;
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }else{
            System.out.println("incorrect values " + this.getClass().getSimpleName());
        }

    }

    public static boolean attackAndArmorCheck(int attack, int armor){
        return attack >= 1 & attack <= 20 & armor >= 1 & armor <= 20;
    }

    public static boolean hpCheck(int hp){
        return hp >= 0;
    }

    public static boolean damageCheck(int min, int max){
        return min < max & min >= 0;
    }

    public int checkModify(Creature enemy){
        return this.attack-enemy.getArmor() + 1;
    }

    public boolean isAttackSuccess(int modify){
        boolean success = false;

        for(int i = 0; i < modify; ++i){
            int cube = (int)((Math.random() * (6)) + 1);
            if(cube > 4){
                System.out.println("attack " + this.getClass().getSimpleName()  + " success");
                return true;
            }

        }
        System.out.println("attack " + this.getClass().getSimpleName()  + " not success");
        System.out.println();
        return success;
    }

    public void attack(Creature enemy){
        if(isAttackSuccess(checkModify(enemy))){
            int damageDone = (int)(Math.random() * (this.maxDamage - this.minDamage)) + this.minDamage;
            enemy.takeDamage(damageDone);
            System.out.println("enemy " + enemy.getClass().getSimpleName() + " take " + damageDone + " damage");
            System.out.println(this.getClass().getSimpleName() + " hp: = " + this.hp);
            System.out.println(enemy.getClass().getSimpleName() + " hp: = " + enemy.getHp());
            System.out.println();
        }
    }

    public int getArmor() {
        return armor;
    }

    public void takeDamage(int damage){
        this.hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
