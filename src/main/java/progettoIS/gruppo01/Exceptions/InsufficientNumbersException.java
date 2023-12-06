package progettoIS.gruppo01.Exceptions;


public class InsufficientNumbersException extends Exception{

    /**
     * Creates a new instance of <code>InsufficientNumbersException</code>
     * without detail message.
     */
    public InsufficientNumbersException() {
    }

    /**
     * Constructs an instance of <code>InsufficientNumbersException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InsufficientNumbersException(String msg) {
        super(msg);
    }
}
