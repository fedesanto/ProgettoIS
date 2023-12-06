package progettoIS.gruppo01.Calculator.ButtonOp;

import java.util.EmptyStackException;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;


public class StackCommander {
    private ComplexStack stackNumeri;

    public StackCommander(ComplexStack stackNumeri) {
        this.stackNumeri = stackNumeri;
    }
    
    /*Metodo che svuota completamente lo stack*/
    public void stackClear(){
        
    }
    
    /*Metodo che rimuove il numero in cima allo stack*/ 
    public void stackDrop() throws EmptyStackException{
//        try{
//            
//        }catch(EmptyStackException e){
//            throw e;
//        }
    }
        
    /*Metodo che duplica il numero presente in cima allo stack*/
     public void stackDup() throws FullStackException,EmptyStackException{
//         try{
//             
//         }catch(FullStackException | EmptyStackException e){
//             throw e;
//         }
//        
    }
     
     /*Metodo che inverte la posizione dei due numeri in cima allo stack*/
     public void stackSwap() throws InsufficientNumbersException{
//        try{
//            
//        }catch(InsufficientNumbersException e){
//            throw e;
//        }
    }
     
     /*Metodo che duplica in cima allo stack il numero nella seconda posizione*/
     public void stackOver() throws InsufficientNumbersException,FullStackException{
//         try{
//             
//         }catch(InsufficientNumbersException | FullStackException e){
//             throw e;
//         }
    }
    
     /*Metodo che restituisce un vettore di stringhe contenente
     i primi'num' numeri dalla cima dello dello stack*/
     public String[] getContent(int num){
        return null;
    }
    
}
