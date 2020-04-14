package cz.muni.fi.pb162.project.geometry;

/**
 *@author Jan Gavlík x445794@mail.muni.cz
 */
public class RegularOctagon extends GeneralRegularPolygon {
    /**
     *
     * @param center takes a point
     * @param radius expected radius
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
