package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class GridPanel extends JPanel implements MouseListener{
    public GridPanel(Grid grid) {
        this.grid = grid;
        setUp();
    }

    private void setUp() {
        this.addMouseListener(this);
        addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int heightOfRow = this.getHeight() / grid.getHeight();
        int widthOfCol = this.getWidth() / grid.getWidth();
        String states = grid.getGrid();
        
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                boolean state = (states.startsWith("1") ? true : false);
                states = states.substring(1);
                
                if (state) {
                    g.setColor(Color.yellow);
                    g.fillRect(j * widthOfCol,
                            i * heightOfRow,
                            widthOfCol,
                            heightOfRow);
                }
                else {
                    g.setColor(Color.black);
                    g.drawRect(j * widthOfCol,
                            i * heightOfRow,
                            widthOfCol,
                            heightOfRow);
                }
            }
        }
    }
      
    private Grid grid;

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        
        int heightOfRow = this.getHeight() / grid.getHeight();
        int widthOfCol = this.getWidth() / grid.getWidth();
        
        int x = p.x / heightOfRow;
        int y = p.y / widthOfCol;
        
        grid.switchCell(x, y);
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
