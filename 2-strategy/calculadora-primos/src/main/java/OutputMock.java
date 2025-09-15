import java.util.List;

import interfaces.OutputStrategy;

public class OutputMock implements OutputStrategy {
    boolean invoked;
    private String output;
    @Override
    public void export(List<Integer> primos){
        invoked = true;
        this.output = primos.toString();
    }

    public String getOutput (){
        return output;
    }

    public Boolean isInvoked (){
        return invoked;
    }
}
