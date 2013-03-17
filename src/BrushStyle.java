

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;

/**
 * @author Jonathan Wexler and Violeta Soued BrushStyle abstract class: defines
 *         a brush style that is usable in any component for which a mouse
 *         listener is applicable.
 */
public abstract class BrushStyle {
    String name;
    Vector<Point> drawingPoints;

    /**
     * Paints on the coordinates of the MouseEvent
     * 
     * @param mouseevent
     */
    public void paint(MouseEvent e) {
        paint(e, e.getX(), e.getY());
    }

    /**
     * Paints on specific coordinates x and y
     * 
     * @param mouseevent
     * @param x
     * @param y
     */
    public abstract void paint(MouseEvent e, int x, int y);

    /**
     * Paints a triangle starting at the coordinates of the MouseEvent
     * 
     * @param mouseevent
     */
    public void triangle(MouseEvent e) {
        // draw triangle starting at x,y
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 30; j++) {
                // first side, draw line with slope -4/5
                if (i == 0) {
                    x += 4;
                    y += 5;
                    // second side, horizontal line
                } else if (i == 1) {
                    x -= 8;
                    // third side, draw line with slope 4/5
                } else {
                    x += 4;
                    y -= 5;
                }
                paint(e, x, y);
            }
        }
    }

    /**
     * Paints a spiral starting at the coordinates of the MouseEvent
     * 
     * @param mouseevent
     */
    public void spiral(MouseEvent e) {
        // draw spiral staring at x1,y1, the coordinates of the mouse click.
        int x1 = e.getX();
        int y1 = e.getY();
        int x2, y2;
        // layers equals 5 rotations, and positions are points along the
        // rotation
        int layers = 5;
        int positions = 30;
        for (int i = 1; i <= layers * positions; ++i) {
            double angle = 2 * Math.PI * i / (double) positions;
            double radius = i / (double) positions
                    * e.getComponent().getWidth() / 4 / (layers + 1);
            x2 = e.getX() + (int) (radius * Math.cos(angle));
            y2 = e.getY() + -(int) (radius * Math.sin(angle));
            paint(e, x1, y1);
            x1 = x2;
            y1 = y2;
        }
    }

    /**
     * Paints a square starting at the coordinates of the MouseEvent
     * 
     * @param mouseevent
     */
    public void square(MouseEvent e) {
        // draw square starting at x,y, the coordinates of the mouse click.
        int x = e.getX();
        int y = e.getY();
        // loops through three sides of the square and draws points in
        // appropriate directions
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 30; j++) {
                if (i < 2) {
                    x += 5 * (i % 2);
                    y += 5 * ((i + 1) % 2);
                } else {
                    x -= 5 * (i % 2);
                    y -= 5 * ((i + 1) % 2);
                }
                paint(e, x, y);
            }
        }
    }

    /**
     * Paints at random coordinates
     * 
     * @param mouseevent
     */
    public void random(MouseEvent e) {
        // draw at pseudo random coordinates
        Random rand = new Random();
        for (int i = 0; i <= 20; i++) {
            paint(e, rand.nextInt(e.getComponent().getWidth()),
                    rand.nextInt(e.getComponent().getHeight()));
        }
    }

    /**
     * Generates a fractal of shapes. Yet to be implemented. Coming soon.
     * 
     * @param e
     */
    public void fractal(MouseEvent e) {

    }

}
