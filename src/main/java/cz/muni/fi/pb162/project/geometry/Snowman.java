package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Snowman {
    private Circular[] balls = new Circular[4];
    /**
     * @param circle takes initial circle
     */
    public Snowman(Circular circle) {
        this(circle, 0.8);
    }
    /**
     * @param circle takes initial circle
     * @param factor size difference for next circles
     */
    public Snowman(Circular circle, double factor) {
        double checkedfactor;
        if(factor<=0 || factor>1){
            checkedfactor=0.8;
        } else {
            checkedfactor=factor;
        }
        this.balls[0] = circle;
        ballMaker(circle, checkedfactor);
    }
    /**
     * @param circle takes initial circle
     * @param factor size difference for next circles
     */

    public void ballMaker(Circular circle, double factor) {
        this.balls[1] = new Circle(getNextCenter(circle, factor), circle.getRadius() * factor);
        this.balls[2] = new Circle(getNextCenter(balls[1], factor), balls[1].getRadius() * factor);
        this.balls[3] = new Circle(getNextCenter(balls[2], factor), balls[2].getRadius() * factor);
        //System.out.println(balls[0].toString() + balls[1].toString() + balls[2].toString() + balls[3].toString());
    }
    /**
     * @return array of Circular
     * */

    public Circular[] getBalls() {
        return balls;
    }
    /**
     * @param circle
     * @param factor
     * @return vertex of next circle
     * */

    private Vertex2D getNextCenter(Circular circle, double factor) {
        double x = circle.getCenter().getX();
        double y = circle.getCenter().getY();
        double radius = circle.getRadius();
        return new Vertex2D(x, y + radius + radius * factor);
    }
}
