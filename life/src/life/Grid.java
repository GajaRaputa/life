package life;

/**
 *
 * @author Gaja Raputa, Agnieszka Wójtowicz
 */
public class Grid {
    public Grid() {
        height = 42;
        width = 62;
        
        grid = new Cell[height][width];     
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                grid[i][j] = new Cell();
        
        tempGrid = new Cell[height][width];     
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                tempGrid[i][j] = new Cell();
            }
    }
    
    public void switchCell(int x, int y) {
        grid[x + 1][y + 1].setState(!grid[x + 1][y + 1].getState());
    }
    
    public void nextState()
    {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++)
                tempGrid[i][j].setState(grid[i][j].nextState(countNbrs(i, j)));
        }
        
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                grid[i][j].setState(tempGrid[i][j].getState());
    }
    
    public void clearGrid() {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                grid[i][j].setState(false);
    }
    
    public String getGrid() {
        String retGrid = new String();
        
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++)
                retGrid += (grid[i][j].getState() ? "1" : "0");
        }
        
        return retGrid;
    }
    
    public void setGrid(String grid) {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                this.grid[i][j].setState(grid.startsWith("1") ? true : false);
                grid = grid.substring(1);
            }
        }
    }
    
    private int countNbrs(int x, int y) {
        int n = 0;
        
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (grid[i][j].getState())
                    n++;
            }
        }
        
        n -= (grid[x][y].getState() ? 1 : 0);
        
        return n;
    }
    
    public int getHeight()
    {
        return height - 2;
    }
    
    public int getWidth()
    {
        return width - 2;
    }
    
    private Cell[][] grid;
    private Cell[][] tempGrid;
    private int height;
    private int width;
}
