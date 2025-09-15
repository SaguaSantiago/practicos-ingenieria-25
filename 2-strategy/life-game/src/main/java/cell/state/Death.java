package cell.state;

public class Death implements StateBehavior {
    @Override
    public boolean isAlive(){
        return false;
    }
}
