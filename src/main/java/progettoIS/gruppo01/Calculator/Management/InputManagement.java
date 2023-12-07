
package progettoIS.gruppo01.Calculator.Management;

import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;
import progettoIS.gruppo01.Exceptions.EmptyStackException;


public interface InputManagement{
    
    /*
    Metodo che astrae il concetto di esecutore di comando passato
    sotto forma di stringa dalla text area della calcolatrice
    
    Input:
        - String input, stringa di input al comando da eseguire
    */
    public void execute(String input) throws FullStackException, EmptyStackException, UninitializedVariableException;
}
