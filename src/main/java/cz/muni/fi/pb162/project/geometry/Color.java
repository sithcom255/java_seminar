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
        switch(this) {
            case RED: return "red";
            case GREEN: return "green";
            case BLUE: return "blue";
            case WHITE: return "white";
            case BLACK: return "black";
            case YELLOW: return "yellow";
            case ORANGE: return "orange";
            default: throw new IllegalArgumentException();
        }
    }
}
