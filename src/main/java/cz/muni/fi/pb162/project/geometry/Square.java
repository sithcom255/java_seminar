package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Square implements Circular {
    private final Vertex2D center;

    private final double radius;

    private Vertex2D[] vertex = new Vertex2D[4];
    /**
     * @param doubleRadius radius of square
     * @param middle midlle of square
     */
    public Square(Vertex2D middle, double doubleRadius) {
        double radius = doubleRadius / 2;
        this.center = middle;
        this.radius = radius;
        vertex[0] = new Vertex2D(center.getX() - radius, center.getY());
        vertex[1] = new Vertex2D(center.getX(), center.getY() - radius);
        vertex[2] = new Vertex2D(center.getX() + radius, center.getY());
        vertex[3] = new Vertex2D(center.getX(), center.getY() + radius);
    }
    /**
     * @param circle takes a circle and uses it to make a square
     */
    public Square(Circular circle) {
        this(circle.getCenter(), circle.getRadius() * 2);

    }
    /**
     * @return the center
     */
    @Override
    public Vertex2D getCenter() {
        return center;
    }
    /**
     * @return double of the radius
     */
    @Override
    public double getRadius() {
        return radius;
    }
    /**
     * @return string representaion
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Square: vertices=" + vertex[0].toString()+
                " " + vertex[1].toString() + " " + vertex[2].toString() +
                " " + vertex[3].toString());
        return (sb.toString());
    }
    /**
     * @param index index of the array
     * @return point
     */
    public Vertex2D getVertex(int index) {
        return (index >= 0) && (index < vertex.length) ? vertex[index] : null;
    }
}
