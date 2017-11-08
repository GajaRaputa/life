package ui;

import java.awt.Color;
import javax.swing.JPanel;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class GridPanel extends JPanel {
    public GridPanel(Grid grid) {
        this.grid = grid;
        setUp();
    }

    private void setUp() {
        this.setBackground(Color.darkGray);
    }
    
    private Grid grid;
}
