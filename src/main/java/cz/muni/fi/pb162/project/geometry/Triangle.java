package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Triangle {
    private static final double MAXDEV =0.001;
    private final Vertex2D[] vertexex = new Vertex2D[3];
    private final Triangle[] subTriangle = new Triangle[3];
    private final boolean divided[] = new boolean[1];
    /**
     * @param a first vertex
     * @param b first vertex
     * @param c first vertex
     *
     */

    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        this.vertexex[0] = a;
        this.vertexex[1] = b;
        this.vertexex[2] = c;
    }

    /**
     * @param a first vertex
     * @param b first vertex
     * @param c first vertex
     * @param depth how much divided you want it to be
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth){
        this(a,b,c);
        divide(depth);
    }
    /**
     * @param index index of the vertex you need
     * @return your vertex
     */
    public Vertex2D getVertex(int index) {
        if (isInRange(index)) {
            return vertexex[index];
        } else {
            return null;
        }
    }

    /**
     * @return returns string representatio
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
  sb.append("Triangle: vertices=" + vertexex[0].toString() +" "+ vertexex[1].toString() +" "+ vertexex[2].toString());
        return (sb.toString());
    }
    /**
     * @return tells you if sucessfully divided
     */
    public boolean divide() {
        if (!isDivided()) {
            Vertex2D ab =vertexex[0].createMiddle(vertexex[1]);
            Vertex2D bc =vertexex[1].createMiddle(vertexex[2]);
            Vertex2D ac =vertexex[0].createMiddle(vertexex[2]);
            subTriangle[0] = new Triangle(vertexex[0],ab,ac);
            subTriangle[1] = new Triangle(ab,vertexex[1],bc);
            subTriangle[2] =new Triangle(ac,bc,vertexex[2]);
            divided[0]=true;
            return true;

        } else  {
            return false;
        }
    }
    /**
     * @param depth how divided do you want it ?
     *
     * */

    public void divide(int depth){
        if(depth>0) {
            divide();
        }
        if(depth>1) {
            subTriangle[0].divide(depth-1);
            subTriangle[1].divide(depth-1);
            subTriangle[2].divide(depth-1);
        }
    }



    /**
     * @return tells you if already sucessfully divided
     */
    public boolean isDivided() {
        return (divided[0]);
    }

    /**
     * @return one of the smaller Triangles
     * @param index give me index in range 0-2
     */
    public Triangle getSubTriangle(int index) {
        if (isInRange(index) && (subTriangle[index] != null)) {
            return subTriangle[index];
        } else {
            return null;
        }
    }
    /**
     * @return if is it in range
     * @param index beeing checked
     */
    private boolean isInRange(int index) {
        return (index == 0 || index == 1 || index == 2);
    }
    /**
     * @return if sides are as long the others
     *
     */
    public boolean isEquilateral(){
        double sideA=vertexex[0].distance(vertexex[1]);
        double sideB=vertexex[1].distance(vertexex[2]);
        double sideC=vertexex[2].distance(vertexex[0]);
        return (Math.abs(sideA-sideB) < MAXDEV && Math.abs(sideA-sideC) < MAXDEV && Math.abs(sideB-sideC) < MAXDEV);
    }
}
