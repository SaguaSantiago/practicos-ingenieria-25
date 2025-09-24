import java.util.Timer;
import java.util.TimerTask;

import rules.BornRule;
import rules.DeathRule;

public class Game {
    public static void main(String[] args){
        Observer gameObserver = new BoardObserver();
        Controller gameController = new Controller(new BornRule(), new DeathRule());
        gameController.attach(gameObserver);
        Timer timer = new Timer();
        TimerTask tarea = new PeriodicTick(gameController);
        // Ejecutar la tarea cada 5 segundos (5000 milisegundos)
        // después de un retraso inicial de 0 milisegundos
        timer.schedule(tarea, 0, 1000);
    }

    static private class PeriodicTick extends TimerTask {
        private Controller gameController;

        public PeriodicTick(Controller gameController) {
            this.gameController = gameController;
        }

        @Override
        public void run() {
            gameController.tick();
        }
    }
}
