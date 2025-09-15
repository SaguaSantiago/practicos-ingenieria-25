import java.util.List;

import interfaces.OutputStrategy;

public class ConsoleOutput implements OutputStrategy{
    @Override
    public void export(List<Integer> primos){
        System.out.println("Primos:");
        for(Integer p : primos) System.out.println("* " + p);
        System.out.println("------------");
    }
}
