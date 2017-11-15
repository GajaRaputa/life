package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class ButtonsPanel extends JPanel{
    public ButtonsPanel(Grid grid, JPanel gridPanel) {
        this.grid = grid;
        this.gridPanel = gridPanel;
        
        controlPanel = new JPanel();
        
        startButton = new JButton("START");
        stopButton = new JButton("STOP");
        clearButton = new JButton("CLEAR");
        
        speedSlider = new JSlider(0, 9, 3);
        
        started = false;
        speed = 900 - (speedSlider.getValue() * 100);
        
        setUp();
    }

    private void setUp() {
        this.setLayout(new BorderLayout());
        
        setUpControlPanel();
        this.add(controlPanel, BorderLayout.WEST);
        
        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                JSlider slider = (JSlider) evt.getSource();
                if (!slider.getValueIsAdjusting()) {
                    speed = 900 - (speedSlider.getValue() * 100);
                }
            }
        });
        this.add(speedSlider, BorderLayout.EAST);
        
        exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
           public void run() {
               if (started) {          
                    grid.nextState();
                    gridPanel.repaint();
               }
           }
       }, 0, 100, TimeUnit.MILLISECONDS);
    }
    
    private void setUpControlPanel() {
        startButton.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                started = true;
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });
        
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                started = false;
                stopButton.setEnabled(false);
                startButton.setEnabled(true);
            }
        });
        
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grid.clearGrid();
                gridPanel.repaint();
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
    private JPanel gridPanel;
    
    ScheduledThreadPoolExecutor exec; 
    boolean started;
    int speed;
}
