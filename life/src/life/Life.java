package life;

import ui.MainWindow;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class Life {

    public static void main(String[] args) {
        Grid grid = new Grid();
        
        System.out.println("---");
        System.out.println(grid.getGrid());
        System.out.println("---"); 
        
        MainWindow mainWindow = new MainWindow(grid);         
    }
    
}
