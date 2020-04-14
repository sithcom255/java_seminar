package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of geometry - Circle
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public class Circle extends GeneralRegularPolygon implements Measurable,Circular{

    /**
     * @param middle is the middle of the circle
     * @param radius distance to the outer line
     */
    public Circle(Vertex2D middle, double radius) {
      super(middle, Integer.MAX_VALUE, radius);
      setColor(Color.RED);
    }
    /**
     */
    public Circle() {
       this(new Vertex2D(0.0, 0.0), 1.0);
    }
    @Override
    public double getEdgeLength() {
        return 0;
    }

    /**
     * @return returns string representatio
     */
    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circle: center=" + getCenter().toString()+", radius="+ getRadius());
        return (sb.toString());
    }

}

