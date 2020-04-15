package cz.muni.fi.pb162.project.geometry;
/**
 * Color Enum.
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public enum Color {
    BLUE, RED, GREEN, WHITE, BLACK, YELLOW, ORANGE;

    /**
     *
     * @return Stríng lowercase of enum State
     */
    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
