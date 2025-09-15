import java.util.ArrayList;
import java.util.List;

import interfaces.CalculateStrategy;

public class LSOptimized implements CalculateStrategy {
    public List<Integer> calculate(int n){
        List<Integer> aux = generateList(n);
        List<Integer> res = generateList(n);
        for (Integer i : aux){
            for (int j = 2*i ; j <= n ; j += i){
                res.remove((Integer) j);
            }
        }
        return res;
    }

    private List<Integer> generateList(int n){
        List<Integer> res = new ArrayList<>();
        for (int i = 2 ; i <= n ; i++){
            res.add(i);
        }
        return res;
    }
}
