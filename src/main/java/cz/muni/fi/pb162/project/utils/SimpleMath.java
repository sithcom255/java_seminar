package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Arrays;
import java.util.OptionalDouble;

public class SimpleMath {
    public static double minX(Triangle triangle) {
        OptionalDouble minX = Arrays.stream(new Vertex2D[]{triangle.getVertex(0), triangle.getVertex(1), triangle.getVertex(2)})
                .mapToDouble(Vertex2D::getX)
                .min();
        return  minX.getAsDouble();
    }

    public static double minY(Triangle triangle) {
        OptionalDouble minX = Arrays.stream(new Vertex2D[]{triangle.getVertex(0), triangle.getVertex(1), triangle.getVertex(2)})
                .mapToDouble(Vertex2D::getY)
                .min();
        return  minX.getAsDouble();
    }

    public static double maxX(Triangle triangle) {
        OptionalDouble minX = Arrays.stream(new Vertex2D[]{triangle.getVertex(0), triangle.getVertex(1), triangle.getVertex(2)})
                .mapToDouble(Vertex2D::getX)
                .max();
        return  minX.getAsDouble();
    }

    public static double maxY(Triangle triangle) {
        OptionalDouble minX = Arrays.stream(new Vertex2D[]{triangle.getVertex(0), triangle.getVertex(1), triangle.getVertex(2)})
                .mapToDouble(Vertex2D::getY)
                .max();
        return  minX.getAsDouble();
    }
}
