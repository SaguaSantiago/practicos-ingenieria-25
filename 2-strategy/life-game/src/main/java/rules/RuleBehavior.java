package rules;

import cell.Cell;

public interface RuleBehavior {
    public void apply(Cell cell);
    public boolean canApply(int neighbors);
}
