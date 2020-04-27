package cz.muni.fi.pb162.project.exception;
/**
 * Exception
 *
 * @author Jan Gavlík x445794@mail.muni.cz
 */
public class MissingVerticesException extends RuntimeException{
    /**
     *
     */
    public MissingVerticesException(){
        this("Not enough vertices");
    }

    /**
     *
     * @param message message
     */
    public MissingVerticesException(String message) {
        super(message);
    }
    /**
     *
     * @param message message
     * @param cause Exception
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }
}
