package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * Class for basic element of ArrayPolygon
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class Paper implements Drawable, PolygonFactory {
    private Set<ColoredPolygon> polygons;
    private Color color = Color.BLACK;

    /**
     *
     */
    public Paper() {
        polygons = new HashSet<>();
    }

    /**
     * @param paper paper
     */
    public Paper(Drawable paper) {
        polygons = new HashSet<>();
        polygons.addAll(paper.getAllDrawnPolygons().stream().collect(Collectors.toList()));
    }

    /**
     * @param color the color which the following drawn objects are going to have
     */
    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    /**
     * @param polygon polygon to be drawn
     */
    @Override
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (color == Color.WHITE) {
            throw new TransparentColorException();
        }
        polygons.add(new ColoredPolygon(polygon, color));

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
    public void eraseAll() throws EmptyDrawableException {
        if (polygons.isEmpty()) {
            throw new EmptyDrawableException();
        }
        polygons.clear();
    }

    /**
     * @return collection
     */
    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(polygons);
    }

    /**
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

    /**
     * @param vertices collection which the polygon can be built from; the collection is not modified
     * @return polygon
     * @throws MissingVerticesException
     */
    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        List<Vertex2D> list = new ArrayList<>();
        try {
            if (vertices == null) {
                throw new NullPointerException();
            }
            list.addAll(vertices);
            return new CollectionPolygon(list);
        } catch (IllegalArgumentException e) {
            List<Vertex2D> newList = list.stream().filter(n -> n != null).collect(Collectors.toList());
            return new CollectionPolygon(newList);
        }

    }

    /**
     * @param collectionPolygons collection of polygons (every polygon is collection of vertices)
     * @throws EmptyDrawableException
     */
    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        Exception exception = null;
        boolean sucess = false;
        for (List<Vertex2D> n : collectionPolygons) {
            try {
                drawPolygon(tryToCreatePolygon(n));
                sucess = true;
            } catch (TransparentColorException e) {
                changeColor(Color.BLACK);
            } catch (MissingVerticesException | NullPointerException f) {
                exception = f;
            }
        }
        if (!sucess) {

            throw new EmptyDrawableException("", exception);

        }

    }

    /**
     * @param color color
     * @return collection of polygons
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        return polygons.stream().filter(n -> n.getColor() == color)
                .map(m -> m.getPolygon())
                .collect(Collectors.toList());
    }
}
