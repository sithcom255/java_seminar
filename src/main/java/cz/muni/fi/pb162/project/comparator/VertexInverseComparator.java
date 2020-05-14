package cz.muni.fi.pb162.project.comparator;

import java.util.Comparator;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 * @param <T> parametr implementing comparable
 */
public class VertexInverseComparator<T extends Comparable> implements Comparator<T> {
    /**
     *
     * @param t1 obj
     * @param t2 obj
     * @return number
     */
    @Override
    public  int compare(T t1, T t2) {
        return -t1.compareTo(t2);
    }
}
