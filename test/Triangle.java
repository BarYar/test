/**
 * Name: Bar Yaron
 * The Triangle class represents a triangle with 3 Point objects instance variables and a const EPSILON
 */
public class Triangle {
    
    private Point _point1;
    private Point _point2;
    private Point _point3;
    static final double EPSILON = 0.001;

    // Default constructor
    public Triangle()
    {
        this._point1 = new Point(1.0, 0);
        this._point2 = new Point(-1.0, 0);
        this._point3 = new Point(0, 1.0);
    }

    // Points constructor
    public Triangle(Point p1, Point p2, Point p3)
    {
        this();
        if (this.isValid(p1, p2, p3))
        {
            this._point1 = p1;
            this._point2 = p2;
            this._point3 = p3;
        }

    }

    // Coordinates constructor
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    // Copy constructor
    public Triangle(Triangle other)
    {
        this(other.getPoint1(), other.getPoint2(), other.getPoint3());
    }

    // getters and setters
    public Point getPoint1()
    {
        return this._point1;
    }
    public Point getPoint2()
    {
        return this._point2;
    }
    public Point getPoint3()
    {
        return this._point3;
    }
    public void setPoint1(Point p)
    {
        this._point1.setX(p.getX());
        this._point1.setY(p.getY());
    }
    public void setPoint2(Point p)
    {
        this._point2.setX(p.getX());
        this._point2.setY(p.getY());
    }
    public void setPoint3(Point p)
    {
        this._point3.setX(p.getX());
        this._point3.setY(p.getY());
    }

    // Getters for the edges length in the triangle
    private double getEdge1()
    {
        return this._point1.distance(this._point2);
    }
    private double getEdge2()
    {
        return this._point2.distance(this._point3);
    }
    private double getEdge3()
    {
        return this._point1.distance(this._point3);
    }

    // Returns if the 3 points created a valid triangle
    public boolean isValid(Point p1, Point p2, Point p3)
    {
        double edge1 = this.getEdge1();
        double edge2 = this.getEdge2();
        double edge3 = this.getEdge3();
        return !(this.nearlyEqual(edge1, edge2 + edge3) || this.nearlyEqual(edge2, edge1 + edge3) || this.nearlyEqual(edge3, edge1 + edge2));           
    }

    // Returns whether a and b are nearly equal - the difference between them is less the EPSILON
    // ****** We might need to remove it
    private boolean nearlyEqual(double a, double b)
    {
        return Math.abs(a-b) < EPSILON;
    }

    // toString method
    public String toString()
    {
        return "{" + this._point1 + "," + this._point2 + "," + this._point3 + "}";
    }

    // Return the perimeter of the triangle
    public double getPerimeter()
    {
        return this.getEdge1() + this.getEdge2() + this.getEdge3();
    }

    // Returns the area of the triangle. 
    public double getArea()
    {
        double half_perimeter = this.getPerimeter() / 2;
        return Math.sqrt(half_perimeter * (half_perimeter - this.getEdge1()) * (half_perimeter - this.getEdge2()) * (half_perimeter - this.getEdge3()));
    }


}
