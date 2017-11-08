package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class ButtonsPanel extends JPanel{
    public ButtonsPanel(Grid grid) {
        this.grid = grid;
        
        controlPanel = new JPanel();
        
        startButton = new JButton("START");
        stopButton = new JButton("STOP");
        clearButton = new JButton("CLEAR");
        
        speedSlider = new JSlider(0, 10, 3);
        
        setUp();
    }

    private void setUp() {
        this.setLayout(new BorderLayout());
        
        setUpControlPanel();
        this.add(controlPanel, BorderLayout.WEST);
        this.add(speedSlider, BorderLayout.EAST);
    }
    
    private void setUpControlPanel() {
        startButton.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grid.nextState();
                System.out.println(grid.getGrid());
                System.out.println("---");
            }
        });
        
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(clearButton); 
    }
    
    private JPanel controlPanel;
    
    private JButton startButton;
    private JButton stopButton;
    private JButton clearButton;
    
    private JSlider speedSlider;
    
    private Grid grid;
}
