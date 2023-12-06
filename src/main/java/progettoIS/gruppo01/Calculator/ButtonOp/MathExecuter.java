package progettoIS.gruppo01.Calculator.ButtonOp;

import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;
import progettoIS.gruppo01.Exceptions.MathException;


public class MathExecuter {
    private ComplexStack stackNumeri;

    public MathExecuter(ComplexStack stackNumeri) {
        this.stackNumeri = stackNumeri;
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce la loro somma*/
    public void stackAdd() throws InsufficientNumbersException{
//        try{
//            
//        }catch(InsufficientNumbersException e){
//            throw e;
//        }
        
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce la loro sottrazione*/
    public void stackSub()throws InsufficientNumbersException{
        
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce la loro divisione*/
    public void stackDiv()throws InsufficientNumbersException,MathException{
        
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce la loro moltiplicazione*/
    public void stackMul()throws InsufficientNumbersException{
        
    }
    
    /*Metodo che preleva il numero in cima allo stack
     e inserisce lo stesso numero ma invertito di segno*/
    public void stackSignInv()throws EmptyStackException{
        
    }
    
    /*Metodo che preleva il numero in cima allo stack
     e inserisce la sua radice*/
    public void stackSqrt()throws EmptyStackException{
        
    }
   
    
    
    
    
}
