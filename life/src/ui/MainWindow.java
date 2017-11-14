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
        gridPanel = new GridPanel(this.grid);
        
        menuBar = new MenuBar(this.grid, gridPanel);
        buttonsPanel = new ButtonsPanel(this.grid, gridPanel);
        
        setUp();
    }
    
    private void setUp() {
        this.setTitle("John Conway's Game of Life [BETA]");
        this.setSize(787, 609);
        this.setResizable(false);
        
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
