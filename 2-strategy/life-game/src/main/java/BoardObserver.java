import cell.Cell;

public class BoardObserver implements Observer {
    @Override
    public void update(Board board) {
        print(board);
    }

    private void print(Board currentBoard) {
        if(currentBoard.isGameOver) {
            System.out.println("Game Over");
            return;
        }
        
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
} 
