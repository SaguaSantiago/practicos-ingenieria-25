import rules.BornRule;
import rules.DeathRule;

public class Game {
    public static void main(String[] args){
        Controller gameController = new Controller(new BornRule(), new DeathRule());
        gameController.print();
        gameController.tick();
        gameController.print();
    }
}
