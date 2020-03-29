package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;
/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Gauger {
    /**
     * @param obj accepts obj of measurable
     */
    public static void printMeasurement(Measurable obj){
        System.out.println("Width: "+obj.getWidth() );
        System.out.println("Height: "+ obj.getHeight());
    }
    /**
     * @param triangle accepts obj of measurable
     */
    public static void printMeasurement(Triangle triangle){
        System.out.println(triangle.toString());
        Measurable measurableTriangle=(Measurable)triangle;
        printMeasurement(measurableTriangle);
    }
}
