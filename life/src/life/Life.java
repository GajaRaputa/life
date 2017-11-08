package life;

import ui.MainWindow;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class Life {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        
        Grid g = new Grid();
        
        System.out.println(g.getGrid());
        System.out.println("---");
        g.nextState();
        System.out.println(g.getGrid());
        System.out.println("---");
        g.nextState();
        System.out.println(g.getGrid());      
               
    }
    
}
