package life;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class Cell {
    public Cell() {
        this.state = false;
    }
    
    public boolean getState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    
    public boolean nextState(int numOfNbrs) {
        if(this.state)  {
            if(numOfNbrs < 2 || numOfNbrs > 3)
                return false;
        }
        else {
            if(numOfNbrs == 3)
                return true;
        }
        
        return this.state;
    }
    
    private boolean state;
}
