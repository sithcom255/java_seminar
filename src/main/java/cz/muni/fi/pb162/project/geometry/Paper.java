package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for basic element of ArrayPolygon
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Paper implements Drawable {
    private Set<ColoredPolygon> polygons;
    private Color color = Color.BLACK;

    /**
     *
     */
    public Paper() {
    polygons=new HashSet<>();
    }

    /**
     *
     * @param paper paper
     */
    public Paper(Drawable paper){
        polygons=new HashSet<>();
        polygons.addAll(paper.getAllDrawnPolygons().stream().collect(Collectors.toList()));
    }

    /**
     *
     * @param color the color which the following drawn objects are going to have
     */
    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @param polygon polygon to be drawn
     */
    @Override
    public void drawPolygon(Polygon polygon) {
        polygons.add(new ColoredPolygon(polygon, color));
        if(color==Color.WHITE){
            polygons.remove(new ColoredPolygon(polygon,color));
        }
    }

    /**
     * @param polygon polygon to be erased
     */
    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    /**
     *
     */
    @Override
    public void eraseAll() {
        polygons.clear();
    }

    /**
     *
     * @return collection
     */
    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(polygons);
    }

    /**
     *
     * @return num of points
     */
    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> point = new HashSet<>();
        for (ColoredPolygon polygon : polygons) {
            for (int i = 0; i < polygon.getPolygon().getNumVertices(); i++) {
                point.add(polygon.getPolygon().getVertex(i));
            }
        }
        return point.size();
    }

}
