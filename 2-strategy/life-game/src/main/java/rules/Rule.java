package rules;

import cell.Cell;

public abstract class Rule {
    private RuleBehavior rb;
    
    public boolean canApply(int neighbors){
        return rb.canApply(neighbors);
    };

    public void apply(Cell cell){
        rb.apply(cell);
    };
}
