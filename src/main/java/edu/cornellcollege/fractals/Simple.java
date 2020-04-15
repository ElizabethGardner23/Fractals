package edu.cornellcollege.fractals;

import java.awt.Container;
import javax.swing.JFrame;

/**
 * The Simple class creates a window where the Mandelbrot set can be modeled.
 * Code from Professor Tabak.
 * 
 * @author Elizabeth Gardner
 * @version 14 April 2020
 */
public class Simple extends JFrame {
    
    private static final int SIMPLE_WIDTH = 500;
    private static final int SIMPLE_HEIGHT = 500;
    private static final String SIMPLE_TITLE = "Modeling the Mandelbrot Set";
    
    /**
     * The Simple constructor creates a window on the screen.
     */
    public Simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        
        this.setVisible(true);
    } // Simple()
    
    /**
     * The main method executes the constructor.
     * @param args 
     */
    public static void main(String[] args) {
        Simple simple = new Simple();
    } // main(String[])
} // Simple