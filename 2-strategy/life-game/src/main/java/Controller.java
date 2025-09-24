import java.util.ArrayList;
import java.util.List;

import cell.Cell;
import cell.color.Blue;
import cell.color.Red;
import cell.state.Alive;
import cell.state.Death;
import rules.RuleBehavior;

public class Controller implements Subject{
    private RuleBehavior born;
    private RuleBehavior death;  
    private Board currentBoard;  
    private List<Observer> observers;

    public  Controller(RuleBehavior bornRule, RuleBehavior deathRule){
        this.born = bornRule;
        this.death = deathRule;
        this.currentBoard = new Board();
        currentBoard.initBoard();
        this.observers = new ArrayList<>();
    }

    public void tick() {
        if(currentBoard.isGameOver) {
            notifyObservers();
            return;
        }
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
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(currentBoard);
        }
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }
}
