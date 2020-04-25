package cz.muni.fi.pb162.project.geometry;


import java.util.Arrays;



/**
 * Class for basic element of ArrayPolygon
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class ArrayPolygon extends SimplePolygon {
    private final Vertex2D[] vertexex;

    /**
     * @param arr array od V2
     */
    public ArrayPolygon(Vertex2D[] arr) {
        super(arr);
        vertexex = Arrays.stream(arr)
                .toArray(Vertex2D[]::new);
    }

    /**
     * @param index vertex index, not negative number
     * @return point
     */
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index negative");
        } else {
            return vertexex[index % this.getNumVertices()];
        }
    }

    /**
     * @return num of vertices
     */
    @Override
    public int getNumVertices() {
        return vertexex.length;
    }

    /**
     * @param o polygon
     * @return is equal
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass().equals(o.getClass())) {
            ArrayPolygon point = (ArrayPolygon) o;
            boolean vert = true;
            for (int i = 0; i < vertexex.length; i++) {
                if (!(vertexex[i].equals(point.getVertex(i)))) {
                    vert = false;
                }
            }
            return vert;
        } else {
            return false;
        }

    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
