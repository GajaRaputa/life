package ui;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
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
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                Component modalToComponent = null;
                
                fileChooser.setSelectedFile(new File("save.txt"));
                if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    try {
                        FileOutputStream fop = new FileOutputStream(file);
                        byte[] gridInBytes = grid.getGrid().getBytes();
                        fop.write(gridInBytes);
                        fop.flush();
                        fop.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    }                   
                }
            }
        });
        
        menuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                Component modalToComponent = null;
                
                if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
                    FileInputStream fip = null;
                    try {
                        File file = fileChooser.getSelectedFile();
                        fip = new FileInputStream(file);
                        
                        int inputState;
                        String inputGrid = "";
                        
                        while ((inputState = fip.read()) != -1) {
                            inputGrid += (char)inputState;
                        }
                        
                        grid.setGrid(inputGrid);
                        gridPanel.repaint();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fip.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    }                   
            }
        });
        
        menuOptions.add(menuItemSave);
        menuOptions.add(menuItemLoad);
    }
    
    private void setUpMenuHelp() {
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            private Component frame;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(frame,
                "Game of Life cellular automaton devised by the British mathematician John Conway",
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
