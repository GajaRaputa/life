package ui;

import java.awt.BorderLayout;
import javax.swing.*;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class MainWindow extends JFrame {
    public MainWindow(Grid grid) {
        this.grid = grid;
        
        menuBar = new MenuBar(this.grid);
        buttonsPanel = new ButtonsPanel(this.grid);
        gridPanel = new GridPanel(this.grid);
        
        setUp();
    }
    
    private void setUp() {
        this.setTitle("John Conway's Game of Life [BETA]");
        this.setSize(800, 600);
        
        this.setJMenuBar(menuBar);
        
        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private MenuBar menuBar;
    private ButtonsPanel buttonsPanel;
    private GridPanel gridPanel;
    
    private Grid grid;
}
