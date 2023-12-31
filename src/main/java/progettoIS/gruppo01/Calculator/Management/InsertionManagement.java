package progettoIS.gruppo01.Calculator.Management;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.FullStackException;


public class InsertionManagement implements InputManagement{
    private ComplexStack stackNumeri;
    
    public InsertionManagement(ComplexStack stackNumeri){
        this.stackNumeri = stackNumeri;
    }
    
    
    /*
    Metodo che si occupa dell'inserimento di un numero complesso,
    ricevuto sotto forma di stringa, all'interno dello stack.
    Crea un oggetto di tipo ComplexNum, effettuando il parsing della stringa ricevuta
    dopodichè lo inserisce all'interno dello stack
    
    Input:
        - String input, numero complesso espresso sotto forma di stringa
    */
    @Override
    public void execute(String input) throws FullStackException{
    
        ComplexNum num = ComplexNum.parseComplex(input); //Creo un nuovo numero complesso
        if(num != null)
            stackNumeri.insert(num);       //Lo inserisco all'interno dello stack*/
    }
    
    
}
