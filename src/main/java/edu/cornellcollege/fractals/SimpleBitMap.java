package edu.cornellcollege.fractals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

/**
 * The SimpleBitMap class draws a portion of the Mandelbrot set or a Julia set
 * in the panel made in the Simple class. Based on code from Professor Tabak.
 *
 * @author Elizabeth Gardner
 * @version 14 April 2020
 */
public class SimpleBitMap extends JPanel {

    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private static final int THRESHOLD = 50;
    private BufferedImage image;

    /**
     * The SimpleBitMap constructor establishes the values of some parameters.
     */
    public SimpleBitMap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } // SimpleBitMap()

    /**
     * The paintComponent method models a designated portion of the Mandelbrot
     * set or a Julia set on the screen.
     *
     * @param g a 2D graphic
     */
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

        int[][] palatte = new int[64][3];

        Color startColor = Color.PINK;
        int r0 = startColor.getRed();
        int g0 = startColor.getGreen();
        int b0 = startColor.getBlue();
//        int a0 = 255;
        
//        Color midColor = Color.YELLOW;
//        int r2 = midColor.getRed();
//        int g2 = midColor.getGreen();
//        int b2 = midColor.getBlue();

        Color endColor = Color.GREEN;
        int r1 = endColor.getRed();
        int g1 = endColor.getGreen();
        int b1 = endColor.getBlue();

        for (int i = 0; i < 64; i++) {
            double fraction = ((double) i) / 63;
            int red = (int) (fraction * r0 + fraction * r1);
            int green = (int) (fraction * g0 + fraction * g1);
            int blue = (int) (fraction * b0 + fraction * b1);
            
//            int red = (int) r0;
//            int green = (int) g0;
//            int blue = (int) b0;
//            int alpha = (int) (a0 - i);

            palatte[i][0] = red;
            palatte[i][1] = green;
            palatte[i][2] = blue;
//            palatte[i][3] = alpha;
            
//            palatte[i][0] = (int) (100 + (156 * Math.random()));
//            palatte[i][1] = (int) (100 + (156 * Math.random()));
//            palatte[i][2] = (int) (100 + (156 * Math.random()));
        } // for

        int[] dimGray = {105, 105, 105};

        double uMin = -1;
        double uMax = 1;
        double vMin = -1.5;
        double vMax = 1.5;
        double xMin = 0;
        double xMax = BITMAP_WIDTH - 1;
        double yMin = 0;
        double yMax = BITMAP_HEIGHT - 1;

        for (int row = 0; row < BITMAP_HEIGHT; row++) {
            double y = row;
            for (int column = 0; column < BITMAP_WIDTH; column++) {
                double x = column;

                double u = uMin + (uMax - uMin) * (x - xMin) / (xMax - xMin);
                double v = vMin + (vMax - vMin) * (y - yMin) / (yMax - yMin);
                
                // Create z with components (0.0, 0.0)            
                Complex z = new Complex(u, v);

                // Create c with components map(row, column)
                Complex c = new Complex(0.3141, 0.5926);

                int count = 0;
                while (z.magnitudeSquared() < 4.0 && count < 64) {
                    z = z.multiplyComplex(z);
                    z = z.addComplex(c);
                    count++;
                } // while

                // use count to assign a color to the pixel
                // at (row, column)
                if (count == 64) {
                    raster.setPixel(row, column, dimGray);
                } // if
                else {
                    raster.setPixel(row, column, palatte[count]);
                } // else
            } // for
        } // for

        g2d.drawImage(image, scale, this);

    } // paintComponent(Graphics)
} // SimpleBitMap