/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package progettoIS.gruppo01.Exceptions;

/**
 *
 * @author attil
 */
public class UninitializedVariableException extends Exception{

    /**
     * Creates a new instance of <code>UninitializedVariableException</code>
     * without detail message.
     */
    public UninitializedVariableException() {
    }

    /**
     * Constructs an instance of <code>UninitializedVariableException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UninitializedVariableException(String msg) {
        super(msg);
    }
}
