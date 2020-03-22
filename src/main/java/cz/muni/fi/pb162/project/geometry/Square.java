package cz.muni.fi.pb162.project.geometry;

public class Square implements Circular {
    private final Vertex2D center;

    private final double radius;

    Vertex2D[] vertexex = new Vertex2D[4];

    public Square(Vertex2D middle, double doubleRadius) {
        double radius = doubleRadius / 2;
        this.center = middle;
        this.radius = radius;
        vertexex[0] = new Vertex2D(center.getX() - radius, center.getY());
        vertexex[1] = new Vertex2D(center.getX(), center.getY() - radius);
        vertexex[2] = new Vertex2D(center.getX() + radius, center.getY());
        vertexex[3] = new Vertex2D(center.getX(), center.getY() + radius);
    }

    public Square(Circular circle) {
        this(circle.getCenter(), circle.getRadius() * 2);

    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Square: vertices=" + vertexex[0].toString() + " " + vertexex[1].toString() + " " + vertexex[2].toString() + " " + vertexex[3].toString());
        return (sb.toString());
    }

    public Vertex2D getVertex(int index) {
        return (index >= 0) && (index < vertexex.length) ? vertexex[index] : null;
    }
}
