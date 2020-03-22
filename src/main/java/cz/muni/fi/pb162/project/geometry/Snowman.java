package cz.muni.fi.pb162.project.geometry;

public class Snowman {
    Circular[] balls = new Circular[4];

    public Snowman(Circular circle) {
        this(circle, 0.8);
    }

    public Snowman(Circular circle, double factor) {
        this.balls[0] = circle;
        ballMaker(circle, factor);
    }

    public void ballMaker(Circular circle, double factor) {
        this.balls[1] = new Circle(getNextCenter(circle, factor), circle.getRadius() * factor);
        this.balls[2] = new Circle(getNextCenter(balls[1], factor), balls[1].getRadius() * factor);
        this.balls[3] = new Circle(getNextCenter(balls[2], factor), balls[2].getRadius() * factor);
        //System.out.println(balls[0].toString() + balls[1].toString() + balls[2].toString() + balls[3].toString());
    }


    public Circular[] getBalls() {
        return balls;
    }


    private <X extends Circular> Vertex2D getNextCenter(X circle, double factor) {
        double x = circle.getCenter().getX();
        double y = circle.getCenter().getY();
        double radius = circle.getRadius();
        return new Vertex2D(x, y + radius + radius * factor);
    }
}
