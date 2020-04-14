package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * @param doubleRadius radius of square
     * @param middle       midlle of square
     */
    public Square(Vertex2D middle, double doubleRadius) {
        super(middle, 4, doubleRadius / 2);
    }

    /**
     * @param circle takes a circle and uses it to make a square
     */
    public Square(Circular circle) {
        this(circle.getCenter(), circle.getRadius() * 2);

    }

    /**
     *
     * @return String of important characteristics
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Square: vertices=" + getVertex(0).toString() +
                " " + getVertex(1).toString() + " " + getVertex(2).toString() +
                " " + getVertex(3).toString());
        return (sb.toString());
    }

}
