package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Arrays;
import java.util.OptionalDouble;
/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class SimpleMath {
    /**
     * @param polygon takes a polygon
     * @return min X value
     */
    public static double minX(Polygon polygon) {
        Vertex2D[] arr=getArray(polygon);
        OptionalDouble minX = Arrays.stream(arr)
                .mapToDouble(Vertex2D::getX)
                .min();
        return  minX.getAsDouble();
    }
    /**
     * @param polygon takes a polygon
     * @return min y value
     */
    public static double minY(Polygon polygon) {
        Vertex2D[] arr=getArray(polygon);
        OptionalDouble minX = Arrays.stream(arr)
                .mapToDouble(Vertex2D::getY)
                .min();
        return  minX.getAsDouble();
    }
    /**
     * @param polygon takes a polygon
     * @return max X value
     */
    public static double maxX(Polygon polygon) {
        Vertex2D[] arr=getArray(polygon);
        OptionalDouble minX = Arrays.stream(arr)
                .mapToDouble(Vertex2D::getX)
                .max();
        return  minX.getAsDouble();
    }
    /**
     * @param polygon takes a polygon
     * @return max Y value
     */
    public static double maxY(Polygon polygon) {
        Vertex2D[] arr=getArray(polygon);
        OptionalDouble minX = Arrays.stream(arr)
                .mapToDouble(Vertex2D::getY)
                .max();
        return  minX.getAsDouble();
    }

    /**
     * @param polygon polygon
     * @return array of its vertexes
     */
    public static Vertex2D[] getArray(Polygon polygon){
        Vertex2D[] arr=new Vertex2D[polygon.getNumVertices()];
        for (int i=0;i<polygon.getNumVertices();i++){
            arr[i]=polygon.getVertex(i);
        }
        return arr;
    }
}
