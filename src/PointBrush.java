

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * 
 * @author Jonathan Wexler and Violeta Soued
 * PointBrush BrushStyle draws with a continuous line
 *
 */
public class PointBrush extends BrushStyle {
    Vector<Point> drawingPoints;
    Point lastpoint;

    /**
     * Constructs a new PointBrush
     */
    //Starts the pointbrush with an empty track of points drawn
    public PointBrush() {
        lastpoint = null;
        drawingPoints = new Vector<Point>();
        name = "point";
    }

    @Override
    public void paint(MouseEvent e, int x, int y) {
        //if starting new track of points
        if (lastpoint == null) {
            drawingPoints.clear();
        }
        //add the current point to the vector of points
        //point after that up until the current point
        drawingPoints.addElement(new Point(x, y));
        for (int j = 1; j < drawingPoints.size(); ++j) {
            Point A = drawingPoints.elementAt(j - 1);
            Point B = drawingPoints.elementAt(j);
            e.getComponent().getGraphics().drawLine(A.x, A.y, B.x, B.y);
        }
        //record last point drawn
        lastpoint = new Point(x, y);

    }

    //Overriden to clear the path of the brush
    public void triangle(MouseEvent e) {
        super.triangle(e);
        clear();
    }

    //Overriden to clear the path of the brush
    public void spiral(MouseEvent e) {
        super.spiral(e);
        clear();
    }

    //Overriden to clear the path of the brush
    public void square(MouseEvent e) {
        super.square(e);
        clear();
    }

    //Overriden to clear the path of the brush
    public void random(MouseEvent e) {
        super.random(e);
        clear();
    }

    //Overriden to clear the path of the brush
    public void fractal(MouseEvent e) {
        super.fractal(e);
        clear();
    }
    
    public void clear(){
        lastpoint = null;
    }

}
