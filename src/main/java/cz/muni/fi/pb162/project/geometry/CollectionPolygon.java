package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

/**
 * Class for basic element of ArrayPolygon
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> vertexex;

    /**
     * @param arr array
     */
    public CollectionPolygon(Vertex2D[] arr) {
        super(arr);
        vertexex = Arrays.stream(arr)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param arr arr
     */
    public CollectionPolygon(List<Vertex2D> arr) {
        super(arr.toArray());
        vertexex = arr.stream()
                .collect(Collectors.toList());


    }

    /**

     * @return smaller thing
     */
    public CollectionPolygon withoutLeftmostVertices() {
        Vertex2D[] x=new Vertex2D[vertexex.size()];
                x= vertexex.toArray(x);
            double max = SimpleMath.minX(new ArrayPolygon(x));
            CollectionPolygon polygon= new CollectionPolygon((vertexex.stream()
                    .filter(n -> n.getX() != max)
                    .collect(Collectors.toList())));

        return polygon.getNumVertices()>0 ? polygon :null;
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
            return vertexex.get(index % this.getNumVertices());
        }
    }

    /**
     * @return number of vertices
     */
    @Override
    public int getNumVertices() {
        return vertexex.size();
    }

    /**
     * @param o object
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass().equals(o.getClass())) {
            CollectionPolygon point = (CollectionPolygon) o;
            boolean vert = true;
            for (int i = 0; i < vertexex.size(); i++) {
                if (!(vertexex.get(i).equals(point.getVertex(i)))) {
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
