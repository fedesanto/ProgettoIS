/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package progettoIS.gruppo01.Exceptions;

/**
 *
 * @author attil
 */
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
