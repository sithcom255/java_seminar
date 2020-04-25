package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class for basic element of ArrayPolygon
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public abstract class SimplePolygon implements Polygon{
    /**
     *@param arr constructor check
     */
    public SimplePolygon(Object[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        boolean existNull = Arrays.stream(arr).anyMatch(Objects::isNull);
        if (existNull) {
            throw new IllegalArgumentException("invalid argument");
        }
    }

    /**
     *
     * @return height
     */
    @Override
    public double getHeight() {
        return SimpleMath.maxY(this)-SimpleMath.minY(this);
    }

    /**
     *
     * @return width
     */
    @Override
    public double getWidth() {
        return SimpleMath.maxX(this)-SimpleMath.minX(this);
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        Vertex2D[] arr =SimpleMath.getArray(this);
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(" "+arr[i].toString());
        }
        return "Polygon: vertices ="+sb.toString();
    }
}
