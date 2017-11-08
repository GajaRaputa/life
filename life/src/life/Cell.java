package life;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class Cell {
    public Cell() {
        state = false;
    }
    
    public boolean getState() {
        return state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    
    public boolean nextState(int numOfNbrs) {
        if(state)  {
            if(numOfNbrs < 2 || numOfNbrs > 3)
                return false;
        }
        else {
            if(numOfNbrs == 3)
                return true;
        }
        
        return state;
    }
    
    private boolean state;
}
