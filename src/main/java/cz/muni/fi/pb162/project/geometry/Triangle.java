package cz.muni.fi.pb162.project.geometry;


/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Triangle extends ArrayPolygon implements Measurable {
    private static final double MAXDEV = 0.001;
    private final Triangle[] subTriangle = new Triangle[3];


    /**
     * @param a first vertex
     * @param b first vertex
     * @param c first vertex
     */

    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(new Vertex2D[]{a, b, c});
    }

    /**
     * @param a     first vertex
     * @param b     first vertex
     * @param c     first vertex
     * @param depth how much divided you want it to be
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth) {
        this(a, b, c);
        divide(depth);
    }

    /**
     * @return returns string representatio
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Triangle: vertices=" + getVertex(0).toString() +
                " " + getVertex(1).toString() + " " + getVertex(2).toString());
        return (sb.toString());
    }

    /**
     * @return tells you if sucessfully divided
     */
    public boolean divide() {
        if (!isDivided()) {
            Vertex2D ab = getVertex(0).createMiddle(getVertex(1));
            Vertex2D bc = getVertex(1).createMiddle(getVertex(2));
            Vertex2D ac = getVertex(0).createMiddle(getVertex(2));
            subTriangle[0] = new Triangle(getVertex(0), ab, ac);
            subTriangle[1] = new Triangle(ab, getVertex(1), bc);
            subTriangle[2] = new Triangle(ac, bc, getVertex(2));

            return true;

        } else {
            return false;
        }
    }

    /**
     * @param depth how divided do you want it ?
     */

    public void divide(int depth) {
        if (depth > 0) {
            divide();
        }
        if (depth > 1) {
            subTriangle[0].divide(depth - 1);
            subTriangle[1].divide(depth - 1);
            subTriangle[2].divide(depth - 1);
        }
    }

    /**
     * @return tells you if already sucessfully divided
     */
    public boolean isDivided() {
        return !(subTriangle[0]==null);
    }

    /**
     * @param index give me index in range 0-2
     * @return one of the smaller Triangles
     */
    public Triangle getSubTriangle(int index) {
        if (isInRange(index) && (subTriangle[index] != null)) {
            return subTriangle[index];
        } else {
            return null;
        }
    }

    /**
     * @param index beeing checked
     * @return if is it in range
     */
    private boolean isInRange(int index) {
        return (index == 0 || index == 1 || index == 2);
    }

    /**
     * @return if sides are as long the others
     */
    public boolean isEquilateral() {
        double sideA = getVertex(0).distance(getVertex(1));
        double sideB = getVertex(1).distance(getVertex(2));
        double sideC = getVertex(2).distance(getVertex(0));
        return (Math.abs(sideA - sideB) < MAXDEV &&
                Math.abs(sideA - sideC) < MAXDEV && Math.abs(sideB - sideC) < MAXDEV);
    }

}
