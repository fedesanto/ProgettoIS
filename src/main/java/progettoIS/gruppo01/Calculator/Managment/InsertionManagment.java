package progettoIS.gruppo01.Calculator.Managment;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.FullStackException;


public class InsertionManagment implements InputManagment{
    private ComplexStack stackNumeri;
    
    public InsertionManagment(ComplexStack stackNumeri){
        this.stackNumeri = stackNumeri;
    }
    
    
    /*
    Metodo che si occupa dell'inserimento di un numero complesso,
    ricevuto sotto forma di stringa, all'interno dello stack.
    Crea un oggetto di tipo ComplexNum, effettuando il parsing della stringa ricevuta
    dopodichè lo inseriesce all'interno dello stack
    
    Input:
        - String input, numero complesso espresso sotto forma di stringa
    */
    @Override
    public void execute(String input) throws FullStackException{
   
        ComplexNum num = ComplexNum.parseComplex(input); //Creo un nuovo numero complessp
        stackNumeri.insert(num);       //Lo inserisco all'interno dello stack*/
    }
    
    
}
