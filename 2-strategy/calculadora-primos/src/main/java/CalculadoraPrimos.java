import java.util.List;

import interfaces.CalculateStrategy;
import interfaces.InputStrategy;
import interfaces.OutputStrategy;

public abstract class CalculadoraPrimos {
    protected CalculateStrategy cb;
    protected OutputStrategy os;
    protected InputStrategy is;

    private List<Integer> primos;

    public List<Integer> performCalculate(int n){
        List<Integer> res = cb.calculate(n);
        os.export(res);
        return res;
    }

    public List<Integer> exec(){
        int n = is.getN();
        primos = cb.calculate(n);
        os.export(primos);
        return primos;
    }

    public void setCb(CalculateStrategy cb){
        this.cb = cb;
    }

    public void setOs(OutputStrategy os){
        this.os = os;
    }

}