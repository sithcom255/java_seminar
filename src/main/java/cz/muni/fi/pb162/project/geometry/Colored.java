package cz.muni.fi.pb162.project.geometry;
/**
 * Interface for using Color Enum.
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public interface Colored {
    /**
     *
     * @return Color
     */
    Color getColor();

    /**
     *
     * @param color takes Color.State
     */
    void setColor(Color color);
}
