import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cell.Cell;
import cell.state.Alive;
import cell.state.StateBehavior;

public class Board {
    static final int INITIAL_SIZE = 40;
    Cell[][] gameBoard;
    int size;
    
    public Board (int size){
        if(size<=0) throw new IllegalArgumentException("size must be greater than 0");
        gameBoard = new Cell[size][size];
        this.size = size;

        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++){
                gameBoard[row][col] = new Cell(row, col);
            }
        }
    }

    public Board (){
        this(INITIAL_SIZE);
    }

    public void initBoard(int cellsAlives) {
        Random rand = new Random();
        Set<Integer> xUsed = new HashSet<>();
        Set<Integer> yUsed = new HashSet<>();
        for(int i=1; i<=cellsAlives; i++){
            
            int row = rand.nextInt(0, size);
            int col = rand.nextInt(0, size);
            if(xUsed.contains(row) || yUsed.contains(col)){
                i--;
                continue;
            }
            xUsed.add(row);
            yUsed.add(col);
            gameBoard[row][col].setState(new Alive());
        }
    }

    public void initBoard(){
        int DEFAULT_INITIAL_ALIVES = size/2;
        initBoard(DEFAULT_INITIAL_ALIVES);
    }

    public int neighborsAlivesOf (Cell cell){
        List<Cell> cellNeighbors = neighbors(cell);
        int count = 0;
        for(Cell neighbor : cellNeighbors){
            if(neighbor.isAlive()) count++;
        }
        return count;
    }

    public List<Cell> neighbors(Cell cell) {
        List<Cell> res = new LinkedList<>();
        int leftLimit = cell.x-1;
        int rightLimit = cell.x+1;
        int topLimit = cell.y+1;
        int bottomLimit = cell.y-1;
        for(int row=leftLimit; row<=rightLimit; row++){
            if(row<0 || row>=size) continue;
            for(int col=bottomLimit; col<=topLimit; col++){
                if(col<0 || col>=size) continue;
                if (row == cell.x && col == cell.y) continue;
                Cell neighbor = gameBoard[row][col];
                res.add(neighbor);
            } 
        }
        return res;
    }

    public void setCellState(int x, int y, StateBehavior newState){
        Cell cellToSet = gameBoard[x][y];
        cellToSet.setState(newState);
    }

    public void setCell(Cell cell){
        gameBoard[cell.x][cell.y] = cell;
    }

    public Cell getCell(int x, int y){
        return gameBoard[x][y];
    }
}
