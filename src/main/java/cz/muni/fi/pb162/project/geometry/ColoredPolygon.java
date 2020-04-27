package cz.muni.fi.pb162.project.geometry;

/**
 * Class for basic element of ArrayPolygon
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class ColoredPolygon {
    private final Polygon polygon;
    private final Color color;

    /**
     * @param polygon polygon
     * @param color   color
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }

    /**
     * @return polygon on the obj
     */
    public Polygon getPolygon() {
        return polygon;
    }

    /**
     * @return color of obj
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param o polygon
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass().equals(o.getClass())) {
            ColoredPolygon polygon = (ColoredPolygon) o;
            boolean result = this.polygon.equals(polygon.getPolygon()) && this.color.equals(polygon.getColor());
            return result;
        }
        return false;


    }

    /**
     * @return hash
     */
    @Override
    public int hashCode() {
        return (polygon.toString() + color.toString()).hashCode();
    }

}
