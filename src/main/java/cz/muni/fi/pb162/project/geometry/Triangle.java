package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Triangle {
    private Vertex2D[] vertexex = new Vertex2D[3];
    private Triangle[] subTriangle = new Triangle[3];
    private boolean divided = false;
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
     * @param index index of the vertex you need
     * @param vertex is the vertex you are going to use
     */
    public void setVertex(int index, Vertex2D vertex) {
        if (isInRange(index)) {
            vertexex[index] = vertex;
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
            divided=true;
            return true;

        } else  {
            return false;
        }
    }
    /**
     * @return tells you if already sucessfully divided
     */
    public boolean isDivided() {
        return (divided);
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
}
