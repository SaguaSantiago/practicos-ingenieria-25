package cell;

import cell.color.ColorBehavior;
import cell.color.Red;
import cell.state.Death;
import cell.state.StateBehavior;

public class Cell {
    private StateBehavior state;
    private ColorBehavior colorBehavior;
    public int x;
    public int y; 

    public Cell (int x, int y) {
        state = new Death();
        colorBehavior = new Red();
        this.x = x;
        this.y = y;
    }

    public boolean isAlive () {
        return state.isAlive();
    }

    public void print(){
        colorBehavior.write("■");
    }

    public void setState (StateBehavior newState){
        this.state = newState;
    }

    public void setColor (ColorBehavior newColor){
        this.colorBehavior = newColor;
    }
}
