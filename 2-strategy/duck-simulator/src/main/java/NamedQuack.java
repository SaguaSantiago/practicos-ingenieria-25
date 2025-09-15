public class NamedQuack implements QuackBehavior {
    private String name;
    public NamedQuack(String name) {
        this.name = name;
    }
    public void quack () {
        System.out.println("Hola soy "+ name + " y como soy una caricatura puedo hablar. QUACK.");
    }
}
