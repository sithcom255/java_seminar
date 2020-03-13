package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of geometry - Circle
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public class Circle {

    private final Vertex2D center;

    public Vertex2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    private final double radius;

    /**
     * @param middle is the middle of the circle
     * @param halfradius distance to the outer line
     */
    public Circle(Vertex2D middle, double halfradius) {
        this.center = middle;
        this.radius = halfradius;
    }
    /**
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    /**
     * @return returns string representatio
     */
    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circle: center=" + center.toString()+", radius="+ radius);
        return (sb.toString());
    }

}

