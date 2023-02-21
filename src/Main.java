public class Main {
    public static void main(String[] args) {
        Creature player = new Player(100, 5, 2, 1, 6 );
        Creature monster = new Monster(100, 7, 1, 1, 6 );

        fight(player, monster);

    }

    public static void fight(Creature cr1, Creature cr2){
        while (cr1.getHp() > 0 & cr2.getHp() > 0) {


            if(cr1.getHp() <= 0){
                System.out.println(cr2.getClass().getSimpleName() + " Win~!");
            }else{
                cr1.attack(cr2);
            }
            if(cr2.getHp() <= 0){
                System.out.println(cr1.getClass().getSimpleName() + " Win~!");
            }else{
                cr2.attack(cr1);
            }
        }
    }


}