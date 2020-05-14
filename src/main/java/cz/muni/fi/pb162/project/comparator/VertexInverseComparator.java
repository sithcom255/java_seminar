package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class VertexInverseComparator implements Comparator {
    /**
     *
     * @param o obj
     * @param t1 obj
     * @return number
     */
    @Override
    public int compare(Object o, Object t1) {
        Vertex2D obj1=(Vertex2D) o;
        Vertex2D obj2=(Vertex2D) t1;

        return -obj1.compareTo(obj2);
    }
}
