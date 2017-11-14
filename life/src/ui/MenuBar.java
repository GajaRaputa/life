package ui;

import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import life.Grid;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class MenuBar extends JMenuBar {
    public MenuBar(Grid grid, JPanel gridPanel)
    {
        this.grid = grid;
        this.gridPanel = gridPanel;
        
        menuOptions = new JMenu("Options");
        menuItemSave = new JMenuItem("Save");
        menuItemLoad = new JMenuItem("Load");
        
        menuHelp = new JMenu("Help");
        menuItemHelp = new JMenuItem("Help");
        menuItemAbout = new JMenuItem("About");
        
        setUp();
    }

    private void setUp() {
        setUpMenuOptions();
        this.add(menuOptions);
        
        setUpMenuHelp();
        this.add(menuHelp);
        
        this.setVisible(true);
    }
    
    private void setUpMenuOptions() {
        menuOptions.add(menuItemSave);
        menuOptions.add(menuItemLoad);
    }
    
    private void setUpMenuHelp() {
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(frame,
                "Lorem ipsum...",
                "Help",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(frame,
                "Created by:\nGaja Raputa\nAgnieszka Wojtowicz",
                "About",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        menuHelp.add(menuItemHelp);
        menuHelp.add(menuItemAbout);
    }
    
    private JMenu menuOptions;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    
    private JMenu menuHelp;
    private JMenuItem menuItemHelp;
    private JMenuItem menuItemAbout;
    
    private Grid grid;
    private JPanel gridPanel;
}
