package cz.muni.fi.pb162.project.geometry;

/**
 * Interface for using Color Enum.
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private final Vertex2D center;
    private final double radius;
    private final int n;
    private Color color;
    private Vertex2D[] vertexes;

    /**
     * @param center takes a point
     * @param n      number of edges
     * @param radius selfexplenatory
     */
    public GeneralRegularPolygon(Vertex2D center, int n, double radius) {
        this.center = center;
        this.radius = radius;
        this.n = n;
        color = Color.BLACK;

    }

    /**
     * @return number of edges
     */
    @Override
    public int getNumEdges() {
        return n;
    }

    /**
     * @return lenght of Edge
     */
    @Override
    public double getEdgeLength() {
        return 2 * radius * Math.sin(Math.PI / n);
    }

    /**
     * @param index integral number of index
     * @return point at index
     */
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            index = Math.abs(index + n);
        } else {
            index = Math.abs(index % n);
        }
        vertexes = new Vertex2D[this.n];
        for (int i = 0; i < n; i++) {
            vertexes[i] = new Vertex2D(center.getX() - radius * Math.cos(i * 2 * Math.PI / n),
                    center.getY() - radius * Math.sin(i * 2 * Math.PI / n));
        }
        return vertexes[index];
    }

    /**
     * @return center point
     */
    @Override
    public Vertex2D getCenter() {
        return center;
    }

    /**
     * @return radius
     */
    @Override
    public double getRadius() {
        return radius;
    }

    /**
     * @return double of radius
     */
    @Override
    public double getWidth() {
        return Math.abs(this.getRadius() * 2);
    }

    /**
     * @return double of radius
     */
    @Override
    public double getHeight() {
        return Math.abs(this.getRadius() * 2);
    }

    /**
     * @return Color.State of obj
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * @param color set to different Color.State
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return representation of important characteristics
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n + "-gon: center=" + center + ", radius=" + radius + ", color=" + color);
        return sb.toString();
    }
}
