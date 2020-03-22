package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of geometry - Circle
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public class Circle implements Measurable,Circular{

    private final Vertex2D center;
    private final double radius;

    @Override
    public Vertex2D getCenter() {
        return center;
    }
    @Override
    public double getRadius() {
        return radius;
    }
    /**
     * @param middle is the middle of the circle
     * @param radius distance to the outer line
     */
    public Circle(Vertex2D middle, double radius) {
        this.center = middle;
        this.radius = radius;
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

    @Override
    public double getWidth() {
        return Math.abs(this.getRadius()*2);
    }

    @Override
    public double getHeight() {
        return Math.abs(this.getRadius()*2);
    }
}

