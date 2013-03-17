

import java.util.HashMap;
import java.util.LinkedList;
/**
 * 
 * @author Jonathan Wexler and Violeta Soued
 * Class BrushSet: contains the set of brushes to be used in a DrawingBoard
 *
 */
public class BrushSet {

    HashMap<String, BrushStyle> brushMap;

    /**
     * Constructs a BrushSet with the default fours BrushStyles already implemented
     */
    public BrushSet() {
        brushMap = new HashMap<String, BrushStyle>();
        addBrush(new DefaultBrush());
        addBrush(new TextBrush());
        addBrush(new PointBrush());
        addBrush(new ImageBrush());
    }

    /**
     * Constructs a BrushSet with the given list of BrushStyles
     * @param brushList
     */
    public BrushSet(LinkedList<BrushStyle> brushList) {
        //add brushes to the hashmap
        for (BrushStyle brush : brushList) {
            brushMap.put(brush.name, brush);
        }
    }

    /**
     * Adds a brushstyle to the brush set
     * @param brushstyle
     */
    public void addBrush(BrushStyle brush) {
        //put brush in the hashmap
        brushMap.put(brush.name, brush);
    }

    /**
     * Returns the BrushStyle with the given String name
     * @param string
     * @return BrushStyle
     */
    public BrushStyle get(String s) {
        return brushMap.get(s);
    }

}
