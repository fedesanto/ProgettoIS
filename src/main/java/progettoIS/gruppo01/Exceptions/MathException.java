package progettoIS.gruppo01.Exceptions;


public class MathException extends Exception{

    /**
     * Creates a new instance of <code>MathException</code> without detail
     * message.
     */
    public MathException() {
    }

    /**
     * Constructs an instance of <code>MathException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MathException(String msg) {
        super(msg);
    }
}
