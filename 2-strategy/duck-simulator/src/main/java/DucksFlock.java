import java.util.ArrayList;
import java.util.List;

public class DucksFlock extends Duck {
        private List<Duck> flock;
        
        public DucksFlock () {
            flock = new ArrayList<>();
        }

        public DucksFlock (List<Duck> flock){
            this.flock = flock;
        }

        public void display (){
            for(Duck duck : flock){
                duck.display();
            }
        }

        @Override
        public void performFly () {
            for(Duck duck : flock){
                duck.performFly();
            }
        }

        @Override
        public void performQuack () {
            for(Duck duck : flock){
                duck.performQuack();
            }
        }

        @Override
        public void swim () {
            for(Duck duck : flock){
                duck.swim();
            }
        }

        @Override
        public void setQuackBehavior (QuackBehavior qb){
            for(Duck duck : flock){
                duck.setQuackBehavior(qb);
            }
        }

        @Override
        public void setFlyBehavior (FlyBehavior fb){
            for(Duck duck : flock){
                duck.setFlyBehavior(fb);
            }
        }

        public void addDuck (Duck d){
            flock.add(d);
        }

        public void deleteDuck (int i){
            flock.remove(i);
        }
}
