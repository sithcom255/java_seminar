package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of geometry - point
 * provides doubles X,Y to represent position
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public class Vertex2D {

    private final double x;
    private final double y;

    /**
     * @param x in first
     * @param y is second
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    /**
     * @return returns string of characters based on X and Y, such x=2.0, y=3.0 => [2.0, 3.0]
     */
    @Override
    public String toString() {
        return ("[" + x + ", " + y + "]");
    }

    /**
     * @param otherVertex takes other vertex to make a midle
     * @return returns sum on X and Y
     */
    public Vertex2D createMiddle(Vertex2D otherVertex) {
        return new Vertex2D((this.getX() + otherVertex.getX()) / 2, (this.getY() + otherVertex.getY()) / 2);
    }

    /**
     * @param vertex another point
     * @return distance between the two
     */

    public double distance(Vertex2D vertex) {
        if (vertex != null) {
            double distance = Math.sqrt(Math.pow(vertex.x - this.x, 2) + Math.pow(vertex.y - this.y, 2));
            return distance;
        } else {
            return -1.0;
        }
    }

    /**
     * @param o second vertex
     * @return is equal bool
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass().equals(o.getClass())) {
            Vertex2D point = (Vertex2D) o;
            return (Math.abs(x - point.getX()) < 0.1 && Math.abs(y - point.getY()) < 0.1);
        } else {
            return false;
        }
    }

    /**
     *
     * @return int
     */

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
