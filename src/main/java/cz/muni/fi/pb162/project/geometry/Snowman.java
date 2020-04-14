package cz.muni.fi.pb162.project.geometry;

/**
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Snowman {
    private RegularPolygon[] balls = new RegularPolygon[3];
    /**
     * @param polygon takes initial polygon
     */
    public Snowman(RegularPolygon polygon) {
        this(polygon, 0.8);
    }
    /**
     * @param polygon takes initial polygon
     * @param factor size difference for next circles
     */
    public Snowman(RegularPolygon polygon, double factor) {
        double checkedfactor;
        if(factor<=0 || factor>1){
            checkedfactor=0.8;
        } else {
            checkedfactor=factor;
        }
        this.balls[0] = polygon;
        ballMaker(polygon, checkedfactor);
    }
    /**
     * @param polygon takes initial circle
     * @param factor size difference for next circles
     */

    public void ballMaker(RegularPolygon polygon, double factor) {
        this.balls[1] = new GeneralRegularPolygon(getNextCenter(polygon, factor),
                polygon.getNumEdges(), polygon.getRadius() * factor);
        this.balls[2] = new GeneralRegularPolygon(getNextCenter(balls[1], factor),
                balls[1].getNumEdges(), balls[1].getRadius() * factor);
        //System.out.println(balls[0].toString() + balls[1].toString() + balls[2].toString() + balls[3].toString());
    }
    /**
     * @return array of Circular
     * */

    public RegularPolygon[] getBalls() {
        return balls;
    }
    /**
     * @param polygon
     * @param factor
     * @return vertex of next circle
     * */

    private Vertex2D getNextCenter(RegularPolygon polygon, double factor) {
        double x = polygon.getCenter().getX();
        double y = polygon.getCenter().getY();
        double radius = polygon.getRadius();
        return new Vertex2D(x, y + radius + radius * factor);
    }
}
