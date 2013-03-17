

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * 
 * @author Jonathan Wexler and Violeta Soued
 * ImageBrush draws with an Image
 *
 */
public class ImageBrush extends BrushStyle {
    String image;
    private Image picture;
    private File file;
    int width;
    int height;

    /**
     * Constructs a new ImageBrush
     */
    public ImageBrush() {
        name = "image";
    }

    /**
     * Constructs a new ImageBrush with its String filename
     * @param string
     */
    public ImageBrush(String image) {
        name = "image";
        this.image = image;
    }

    @Override
    public void paint(MouseEvent e) {
        
        Graphics2D imageDrawer = (Graphics2D) e.getComponent().getGraphics();
        imageDrawer.drawImage(picture, e.getX() - 50, e.getY()
                - (50 * height / width), null);
    }

    @Override
    public void paint(MouseEvent e, int x, int y) {

        Graphics2D imageDrawer = (Graphics2D) e.getComponent().getGraphics();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        imageDrawer.drawImage(picture, x - 50, y - (50 * height / width), null);
    }

    /**
     * Sets a new image from its String filename
     * @param string
     */

    public void setImage(String text) {
        this.image = text;
        file = new File(image);

        try {
            picture = ImageIO.read(file);
        } catch (IOException ex) {
//            e.printStackTrace();

         //   Logger.getLogger(imageTest.);
            Logger.getLogger(imageTest.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        width = picture.getWidth(null);
        height = picture.getHeight(null);

        picture = picture.getScaledInstance(100, 100 * height / width,
                Image.SCALE_FAST);
    }
    
    private static class imageTest extends Applet {

        private Image picture;

        private final String filename = "spaceshipcropped.jpg";

        public void init() {

            java.net.URL appletBaseURL = getCodeBase();
            File file = new File("Jonpic.png");
            try {
                picture = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(imageTest.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
        }


    }
}
