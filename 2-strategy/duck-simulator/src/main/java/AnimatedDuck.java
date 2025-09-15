public class AnimatedDuck extends Duck {
    public String name;
    public AnimatedDuck(String name){
        this.name = name;
        this.quackBehavior = new NamedQuack(name);
        this.flyBehavior = new FlyNoWay(); 
    }

    @Override
    void display() {
        System.out.println("i'm a Animated Duck");
    }
}
