package edu.cornellcollege.fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

/**
 * The SimpleBitMap class draws a portion of the Mandelbrot set in the panel.
 * 
 * @author Elizabeth Gardner
 * @version 13 April 2020
 */
public class SimpleBitMap extends JPanel {

    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private static final int THRESHOLD = 50;
    private final BufferedImage image;

    private static final double U_MIN = 0.75;
    private static final double U_MAX = 1.25;
    private static final double V_MIN = -0.75;
    private static final double V_MAX = 0.25;
    private static final int X_MIN = 0;
    private static final int X_MAX = 499;
    private static final int Y_MIN = 0;
    private static final int Y_MAX = 499;

    public SimpleBitMap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } // SimpleBitMap()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH,
                ((double) h) / BITMAP_HEIGHT);

        WritableRaster raster = this.image.getRaster();

        int[] black = {0, 0, 0};
        int[] yellow = {255, 255, 0};

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                for (int row = 0; row < HEIGHT; row++) {
                    for (int column = 0; column < WIDTH; column++) {

                        // Create z with components (0.0, 0.0)            
                        Complex z = new Complex(0, 0);

                        // Create c with components map(row, column)
                        double u = U_MIN + (U_MAX - U_MIN) * (x - X_MIN) / (X_MAX - X_MIN);
                        double v = V_MIN + (V_MAX - V_MIN) * (y - Y_MIN) / (Y_MAX - Y_MIN);

                        Complex c = new Complex(u, v);

                        int count = 0;
                        while (z.magnitude() < 2.0 && count < THRESHOLD) {
                            z = z.multiplyComplex(z);
                            z = z.addComplex(c);
                            count++;
                        } // while

                        // use count to assign a color to the pixel
                        // at (row, column)
                        int[] color = {150, count, 150};
                        raster.setPixel(x, y, color);

                    } // for
                } // for
            } // for
        } // for

        g2d.drawImage(image, scale, this);

    } // paintComponent(Graphics)
} // SimpleBitMap
