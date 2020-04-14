package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;


/**
 * Class for running main method.
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Demo {

    /**
     * Runs the code.
     * sets initial values
     * moves one by values of two
     * print X and Y of both
     *
     * @param args to initiate the method;
     */
    public static void main(String[] args) {

        RegularOctagon test=new RegularOctagon(new Vertex2D(0,0),1);
        System.out.println(test.toString());
    }
}
