package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;



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
     *@throws IOException exception
     * @param args to initiate the method;
     */

    public static void main(String[] args) throws IOException {
       LabeledPolygon.Builder builder = new LabeledPolygon.Builder();
        LabeledPolygon polygon = builder.read(new FileInputStream(new File("polygon-ok.txt")))
                .addVertex("vrchol x",new Vertex2D(123,456)).build();
        OutputStream os =System.out;
        polygon.writeJson(os);
                System.out.println("Hello World!");
    }
}
