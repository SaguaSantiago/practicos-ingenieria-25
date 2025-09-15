import java.util.ArrayList;
import java.util.List;

import interfaces.CalculateStrategy;

public class LSCalculator implements CalculateStrategy {
    
    public List<Integer> calculate(int n){
        List<Integer> res = new ArrayList<>();
        for (int i = 2 ; i <= n; i++){
            if (!checkPrimo(i)) continue;
            res.add(i);
        }
        return res;
    }

    private boolean checkPrimo(int n){
        for (int j = 2 ; j < n ; j++){
                if (n % j == 0) return false;
        }
        return true;
    }
}
