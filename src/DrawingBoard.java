
/*
 * Jonathan Wexler and Violeta Soued
 * BrushWhatever Application
 * 12/14/12
 * Final Project
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Jonathan Wexler and Violeta Soued DrawingBoard Applet: uses
 *         BrushStyle objects to draw
 * 
 */
@SuppressWarnings("serial")
public class DrawingBoard extends Applet implements KeyListener, MouseListener,
MouseMotionListener {

    int width, height;
    String s = "";
    TextField textbox;
    BrushStyle brush;
    Toolkit toolkit;
    BrushSet brushSet;
    TextArea instruct;

    /**
     * Initializes the Applet to set the screen size as the console's screen
     * dimensions. Sets up the text box for user input.
     */
    public void init() {
        // arranges applet size and color background
        setDrawingBoard();

        textbox = new TextField("Enter text here!");
        textbox.addKeyListener(new MyKeyListener());
        instruct = new TextArea(
                "\t\t\t\tFor information type '\'. To remove this message type 'esc'.",
                20, 160);

        add(textbox);
        textbox.setLocation(0, 0);
        instruct.setEditable(false);
        add(instruct);
        brushSet = new BrushSet();
        brush = brushSet.get("default");

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // reads console input in textbox. determines what brush to use based on
    // user input.
    private class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent k) {
            if (k.getKeyChar() == (KeyEvent.VK_ENTER)) {
                String text = textbox.getText();
                if (!text.startsWith("#")) {
                    if (text.length() > 4
                            && (text.substring(text.length() - 4)
                                    .equalsIgnoreCase(".jpg") || text
                                    .substring(text.length() - 4)
                                    .equalsIgnoreCase(".png"))) {
                        brush = brushSet.get("image");
                        ((ImageBrush) brush).setImage(text);
                    } else if (text.equalsIgnoreCase("defaultbrush")) {
                        brush = brushSet.get("default");
                    } else if (text.equalsIgnoreCase("pointbrush")) {
                        brush = brushSet.get("point");
                    } else if (text.equalsIgnoreCase("!")) {
                        System.out.println("SOME");
                        text = "eraser.png";
                        brush = brushSet.get("image");
                        ((ImageBrush) brush).setImage(text);
                    }else {
                        brush = brushSet.get("text");
                        ((TextBrush) brush).setText(text);
                    }

                } else {
                    s = text;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent k) {
        }

        @Override
        public void keyTyped(KeyEvent k) {
        }
    }

    // Sets up the drawing board, arranges the applet to fit screen size, and
    // defines width and height.
    private void setDrawingBoard() {
        toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim);
        width = getSize().width;
        height = getSize().height;
        setBackground(Color.white);
    }

    // called when shape is specified by the user.
    private void shape(MouseEvent e) {
        if (s.equalsIgnoreCase("#spiral")) {
            brush.spiral(e);
        } else if (s.equalsIgnoreCase("#random")) {
            brush.random(e);
        } else if (s.equalsIgnoreCase("#square")) {
            brush.square(e);
        } else if (s.equalsIgnoreCase("#triangle")) {
            brush.triangle(e);
        } else if (s.equalsIgnoreCase("#normal")) {
            brush.paint(e);
        }

    }

    // called when mouse is dragged, allows for brush to paint continuously.
    @Override
    public void mouseDragged(MouseEvent e) {
        brush.paint(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    // called when the mouse is clicked. calls for current brush to draw, and
    // then calls desired shape.
    @Override
    public void mouseClicked(MouseEvent e) {
        brush.paint(e);
        shape(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // called when the mouse is pressed and calls for current brush to draw.
    @Override
    public void mousePressed(MouseEvent e) {
        brush.paint(e);
    }

    // called when mouse is released. Once released, if using a point
    // brush, erases track of previous point brush.
    @Override
    public void mouseReleased(MouseEvent e) {
        if (brush.name.equals("point")) {
            ((PointBrush) brush).clear();

        }
    }

    // Keeps track of pressed keys. When the enter key is pressed, the program
    // loads the text input from console. When the escape key is pressed, it
    // removes the information label from the drawingboard.
    @Override
    public void keyPressed(KeyEvent k) {
        if (k.getKeyChar() == (KeyEvent.VK_ENTER)) {
            textbox.getKeyListeners()[0].keyPressed(k);
        } else if (k.getKeyChar() == KeyEvent.VK_ESCAPE) {
            instruct.setVisible(false);
        } else if (k.getKeyChar() == KeyEvent.VK_BACK_SLASH) {
            // instruct.setVisible(false);
            // instruct.setText("Hello");
            instruct.repaint();
            instruct.setText("\t\t\t\tWelcome to BrushWhatever!\n"
                    + "\t\t\t\tHere you may choose from a selection of brushes available in \n"
                    + "\t\t\t\tyour brushset. For instance, you are currently using the 'def- \n"
                    + "\t\t\t\tault' brush. \n"
                    + "\t\t\t\tYou may also select from pointbrush, imagebrush, and textbrush.\n"
                    + "\t\t\t\tTo access the pointbrush, type 'pointbrush' in the textbox and \n"
                    + "\t\t\t\thit 'enter' \n"
                    + "\t\t\t\tTo access the textbrush, just type any text or integer in the \n"
                    + "\t\t\t\ttextbox and hit 'enter' \n"
                    + "\t\t\t\tTo access the imagebrush, just type the name of an image file \n"
                    + "\t\t\t\tending in .jpg or .png and hit enter \n"
                    + "\t\t\t\tOnce you have the brush you want, you can begin drawing with \n"
                    + "\t\t\t\tthat brush. Type #normal to remove shapes. Space bar clears!\n\n"
                    + ""
                    + "\t\t\t\tHere are a few more perks: You can type #triangle, #spiral, \n"
                    + "\t\t\t\t#square, and #random in the textbox at anytime to apply a tr- \n"
                    + "\t\t\t\tiangle, spiral, square, or random arrangement of points on your\n"
                    + "\t\t\t\tdrawing board, respectively, with any brush from your brushset. \n\n"
                    + ""
                    + "\t\t\t\tRemember to have fun! [hit 'esc' to remove this message]");
        }
    }

    @Override
    public void keyReleased(KeyEvent k) {
    }

    // keeps track of key pressed, if the space key is pressed, the drawingboard
    // is reset
    @Override
    public void keyTyped(KeyEvent k) {
        if (k.getKeyChar() == KeyEvent.VK_SPACE) {
            repaint();
            k.consume();
        }
    }

}
