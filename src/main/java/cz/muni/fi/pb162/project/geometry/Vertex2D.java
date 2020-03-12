package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of geometry - point
 * provides doubles X,Y to represent position
 * @author Jan Gavlík x445794@mail.muni.cz
 */

public class Vertex2D {

    private double x=0;
    private double y=0;

    /**
     * @param x in first
     * @param y is second
     */
    public Vertex2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    /**
    *@return returns string of characters based on X and Y, such x=2.0, y=3.0 => [2.0, 3.0]
     */
    @Override
    public String toString(){
        return ("["+x+", "+y+"]");
    }
    /**
     *@return returns sum on X and Y
     * @param otherVertex takes other vertex to make a midle
     */
    public Vertex2D createMiddle(Vertex2D otherVertex){
        return new Vertex2D((this.getX()+otherVertex.getX())/2,(this.getY()+otherVertex.getY())/2);
    }

}
