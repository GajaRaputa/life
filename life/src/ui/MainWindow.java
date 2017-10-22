package ui;

import javax.swing.*;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        setUp();
    }
    
    private void setUp() {
        this.setTitle("John Conway's Game of Life [BETA]");
        this.setSize(800, 600);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
