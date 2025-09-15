import cell.Cell;
import cell.color.Blue;
import cell.color.Red;
import cell.state.Alive;
import cell.state.Death;
import rules.RuleBehavior;

public class Controller {
    private RuleBehavior born;
    private RuleBehavior death;  
    private Board currentBoard;  
    public  Controller(RuleBehavior bornRule, RuleBehavior deathRule){
        this.born = bornRule;
        this.death = deathRule;
        this.currentBoard = new Board();
        currentBoard.initBoard();
    }

    public void tick() {
        Board newBoard = new Board(currentBoard.size);
        for(int row=0; row<newBoard.size; row++){
            for(int col=0; col<newBoard.size; col++){
                Cell current = currentBoard.getCell(row, col);
                Cell newCell = new Cell(current.x, current.y);
                int currentAliveNeighbors = currentBoard.neighborsAlivesOf(current);
                if(born.canApply(currentAliveNeighbors)) {
                    newCell.setState(new Alive());
                    newCell.setColor(new Blue());
                    newBoard.setCell(newCell);
                } else if(death.canApply(currentAliveNeighbors)){
                    newCell.setState(new Death());
                    newCell.setColor(new Red());
                    newBoard.setCell(newCell);
                }
            }
        }

        currentBoard = newBoard;
    }

    public void print() {
        for(int row=0; row<currentBoard.size; row++){
            for(int col=0; col<currentBoard.size; col++){
                Cell current = currentBoard.getCell(row, col);
                current.print();
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }
}
