import interfaces.CalculateStrategy;
import interfaces.InputStrategy;
import interfaces.OutputStrategy;

public class Calculator extends CalculadoraPrimos {
    public Calculator(){
        this.cb = new LSCalculator();
    }
    public Calculator(CalculateStrategy cb, OutputStrategy os, InputStrategy is){
        this.cb = cb;
        this.os = os;
        this.is = is;
    }
}
