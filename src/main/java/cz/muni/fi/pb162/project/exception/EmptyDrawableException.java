package cz.muni.fi.pb162.project.exception;
/**
 * Exception
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class EmptyDrawableException extends Exception {
    /**
     *
     */
    public EmptyDrawableException() {
        this("No obj on paper");
    }

    /**
     *
     * @param message message
     */
    public EmptyDrawableException(String message) {
        super(message);
    }

    /**
     *
     * @param message message
     * @param cause Exception
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }
}
