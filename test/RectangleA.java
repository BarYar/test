
/**
 * Name: Bar Yaron
 * The RectangleA class represents a Rectangle
 * This class has 2 instance variables int width, int height and pointSW.
 */
public class RectangleA {

    // instance variables
    private int _width;
    private int _height;
    private Point _pointSW;


    public RectangleA(int width, int height)
    {
        this._pointSW = new Point(0 , 0);
        this._width = width > 0 ? width : 1;
        this._height = width > 0 ? width : 1;
    }

    public RectangleA(int width, int height, Point pointSW)
    {
        this._pointSW = pointSW;
        this._width = width > 0 ? width : 1;
        this._height = width > 0 ? width : 1;
    }
    
}
