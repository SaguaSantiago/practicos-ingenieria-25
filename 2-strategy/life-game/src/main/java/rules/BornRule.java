package rules;

import java.util.LinkedList;
import java.util.List;

import cell.Cell;
import cell.state.Alive;

public class BornRule implements RuleBehavior{
    static final String DEFAULT_CELLS_TO_BORN = "2";
    List<Integer> cellsToBorn;

    public BornRule (String cellsToBorn){
        this.cellsToBorn = new LinkedList<>();
        List<String> strings = List.of(cellsToBorn.split(""));
        for(String numberString : strings){
            int number = Integer.parseInt(numberString);
            this.cellsToBorn.add(number);
        }
    }

    public BornRule(){
        this(DEFAULT_CELLS_TO_BORN);
    }
    
    @Override
    public boolean canApply(int neighbors){
        return cellsToBorn.contains(neighbors);
    }

    @Override
    public void apply(Cell cell){
        if(!cell.isAlive()) cell.setState(new Alive());
    }
}
