import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestDuck {

    @Test
    public void testMallardDuck() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test
    public void testModelDuck() {
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
    }

    @Test
    public void testModelDuckChangeFlyBehavior() {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    @Test
    public void testAnimatedDuckChangeFlyBehavior() {
        Duck model = new AnimatedDuck("Lucas");
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        model.display();
    }

    @Test
    public void testAnimatedDuckChangeQuackBehavior() {
        Duck model = new AnimatedDuck("Lucas");
        model.performQuack();
        model.setQuackBehavior(new Quack());
        model.performQuack();
        model.display();
    }

    @Test
    public void testDucksFlock (){
        List<Duck> list = new ArrayList<>();
        list.add(new AnimatedDuck("Lucas"));
        list.add(new AnimatedDuck("Santiago"));
        list.add(new AnimatedDuck("Micho"));
        list.add(new MallardDuck());
        Duck model = new DucksFlock(list);
        model.performFly();
        model.performQuack();
        model.display();
    }
}
