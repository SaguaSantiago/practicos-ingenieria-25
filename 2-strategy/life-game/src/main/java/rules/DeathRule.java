package rules;

import java.util.LinkedList;
import java.util.List;

import cell.Cell;
import cell.state.Death;

public class DeathRule implements RuleBehavior {
    static final String DEFAULT_CELLS_TO_DEATH = "3";
    List<Integer> cellsToDeath;

    public DeathRule (String cellsToDeath){
        this.cellsToDeath = new LinkedList<>();
        List<String> strings = List.of(cellsToDeath.split(""));
        for(String numberString : strings){
            int number = Integer.parseInt(numberString);
            this.cellsToDeath.add(number);
        }
    }

    public DeathRule(){
        this(DEFAULT_CELLS_TO_DEATH);
    }
    
    @Override
    public boolean canApply(int neighbors){
        return cellsToDeath.contains(neighbors);
    }

    @Override
    public void apply(Cell cell){
        if(cell.isAlive()) cell.setState(new Death());
    }

}
