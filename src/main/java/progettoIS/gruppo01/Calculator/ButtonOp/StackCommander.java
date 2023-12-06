package progettoIS.gruppo01.Calculator.ButtonOp;


import java.util.Arrays;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;


public class StackCommander {
    private ComplexStack stackNumeri;

    public StackCommander(ComplexStack stackNumeri) {
        this.stackNumeri = stackNumeri;
    }
    
    /*Metodo che svuota completamente lo stack*/
    public void stackClear() throws EmptyStackException{
        for(int i=0;i<stackNumeri.getSize();i++){
            stackNumeri.remove();
        }
        
    }
    
    /*Metodo che rimuove il numero in cima allo stack*/ 
    public void stackDrop() throws EmptyStackException{
        if(stackNumeri.getSize()==0){
            throw new EmptyStackException("Empty Stack Error");
        }
        stackNumeri.remove();

    }
        
    /*Metodo che duplica il numero presente in cima allo stack*/
     public void stackDup() throws FullStackException,EmptyStackException{
         if(stackNumeri.getSize()==0){
             throw new EmptyStackException("Empty Stack Error");
         }
         stackNumeri.insert(stackNumeri.top());

    }
     
     /*Metodo che inverte la posizione dei due numeri in cima allo stack*/
     public void stackSwap() throws InsufficientNumbersException, EmptyStackException, FullStackException{
         if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
         }
         ComplexNum primo=stackNumeri.remove();
         ComplexNum secondo=stackNumeri.remove();
          stackNumeri.insert(primo);
         stackNumeri.insert(secondo);
         

    }
     
     /*Metodo che duplica in cima allo stack il numero nella seconda posizione*/
     public void stackOver() throws InsufficientNumbersException,FullStackException, EmptyStackException{
          if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
         }
         ComplexNum primo=stackNumeri.remove();
         ComplexNum secondo=stackNumeri.top();
         stackNumeri.insert(primo);
         stackNumeri.insert(secondo);

    }
    
     /*Metodo che restituisce un vettore di stringhe contenente
     i primi'num' numeri dalla cima dello dello stack*/
     public String[] getContent(int num) throws EmptyStackException, FullStackException{
         if(stackNumeri.getSize()==0){
             return null;
         }
         if(num>stackNumeri.getSize()){
             num=stackNumeri.getSize();
         }
         ComplexNum t[] = new ComplexNum[num];
         String v[] = new String[num];
         
         for(int i=0;i<num;i++){
             t[i]=stackNumeri.remove();
             v[i]=t[i].toString();
         }
          for(int i=num;i>0;i--){
             stackNumeri.insert(t[i]);
         }
         
         
        return v;
    }
    
}
