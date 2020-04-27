package cz.muni.fi.pb162.project.exception;
/**
 * Exception
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class TransparentColorException extends Exception {
    /**
     *
     */
    public TransparentColorException(){
        this("White on white");
    }

    /**
     *
     * @param message message
     */
    public TransparentColorException(String message) {
        super(message);
    }
    /**
     *
     * @param message message
     * @param cause Exception
     */

    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
