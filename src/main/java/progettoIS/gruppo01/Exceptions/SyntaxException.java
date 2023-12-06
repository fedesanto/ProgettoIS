package progettoIS.gruppo01.Exceptions;


public class SyntaxException extends Exception {

    /**
     * Creates a new instance of <code>SyntaxException</code> without detail
     * message.
     */
    public SyntaxException() {
    }

    /**
     * Constructs an instance of <code>SyntaxException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SyntaxException(String msg) {
        super(msg);
    }
}
