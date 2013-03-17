

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * 
 * @author Jonathan Wexler and Violeta Soued
 * Default prush paints with '.'
 *
 */
public class DefaultBrush extends BrushStyle {
    Vector<Point> drawingPoints;

    /**
     * Constructs a new DefaultBrush
     */
    public DefaultBrush() {
        name = "default";
    }

    @Override
    public void paint(MouseEvent e, int x, int y) {
        e.getComponent().getGraphics().drawString(".", x, y);
    }
}
