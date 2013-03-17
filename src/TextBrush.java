

import java.awt.event.MouseEvent;

/**
 * 
 * @author Jonathan Wexler and Violeta Soued
 * BrushStyle TextBrush: draws with String
 *
 */
public class TextBrush extends BrushStyle {
    String s;

    /**
     * Default constructor
     */
    public TextBrush() {
        this.s = "";
        name = "text";
    }

    /**
     * Creates a TextBrush to draw with the given String
     * @param string
     */
    public TextBrush(String s) {
        this.s = s;
        name = "text";
    }
    
    /**
     * Sets drawing String
     * @param string
     */
    public void setText(String s) {
        this.s = s;
    }

    public void paint(MouseEvent e, int x, int y) {
        e.getComponent().getGraphics().drawString(s, x, y);
    }
}
