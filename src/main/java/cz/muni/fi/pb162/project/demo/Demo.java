package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;



/**
 * Class for running main method.
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Demo {

    /**
     * Runs the code.
     *sets initial values
     *moves one by values of two
     * print X and Y of both
     * @param args to initiate the method;
     */
    public static void main(String[] args) {

        Vertex2D a=new Vertex2D(-100,0);
        Vertex2D b=new Vertex2D(0,100);
        Vertex2D c=new Vertex2D(100,-100);
        Triangle test = new Triangle(a,b,c);
        System.out.println(test.toString());
    }
}
