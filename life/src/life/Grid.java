package life;

/**
 *
 * @author Gaja Raputa, Agnieszka Wójtowicz
 */
public class Grid {
    public Grid() {
        this.height = 12;
        this.width = 17;
        
        this.grid = new Cell[this.height][this.width];     
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                this.grid[i][j] = new Cell();
        
        this.tempGrid = new Cell[this.height][this.width];     
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++) {
                this.tempGrid[i][j] = new Cell();
            }
        
        this.grid[3][1].setState(true);
        this.grid[3][2].setState(true);
        this.grid[3][3].setState(true);
        this.grid[2][3].setState(true);
        this.grid[1][2].setState(true);
    }
    
    public void switchCell(int x, int y) {
        grid[x][y].setState(!grid[x][y].getState());
    }
    
    public void nextState()
    {
        for (int i = 1; i < this.height - 1; i++) {
            for (int j = 1; j < this.width - 1; j++)
                this.tempGrid[i][j].setState(this.grid[i][j].nextState(countNbrs(i, j)));
        }
        
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                this.grid[i][j].setState(this.tempGrid[i][j].getState());
    }
    
    public String getGrid() {
        String retGrid = new String();
        
        for (int i = 1; i < this.height - 1; i++) {
            for (int j = 1; j < this.width - 1; j++)
                retGrid += (grid[i][j].getState() ? "1" : "0");
            retGrid += "\n";
        }
        
        return retGrid;
    }
    
    private int countNbrs(int x, int y) {
        int n = 0;
        
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (grid[i][j].getState())
                    n++;
            }
        }
        
        n -= (grid[x][y].getState() ? 1 : 0);
        
        return n;
    }
    
    private Cell[][] grid;
    private Cell[][] tempGrid;
    private int height;
    private int width;
}
