package progettoIS.gruppo01.Calculator.ButtonOp;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import static progettoIS.gruppo01.Calculator.Complex.MathOperations.*;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;
import progettoIS.gruppo01.Exceptions.MathException;


public class MathExecuter {
    private ComplexStack stackNumeri;

    public MathExecuter(ComplexStack stackNumeri) {
        this.stackNumeri = stackNumeri;
    }
    
    /*Metodo che preleva i primi due numeri dalla
    cima dello stack e inserisce in esso la loro somma.
    Può lanciare un’eccezione controllata di tipo InsufficientNumberException se 
    lo stack ha meno di due numeri.
    */
    public void stackAdd() throws InsufficientNumbersException, EmptyStackException, FullStackException{
        if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
        }
        ComplexNum primo=stackNumeri.remove(); //Prelevo il primo numero complesso dello stack
        ComplexNum secondo=stackNumeri.remove(); //Prelevo il secondo numero complesso dello stack
        stackNumeri.insert(somma(primo,secondo)); //Inserisco la somma dei due numeri nello stack
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce in esso la loro sottrazione.
    Può lanciare un’eccezione controllata di tipo InsufficientNumberException se 
    lo stack ha meno di due numeri.
    */
    public void stackSub()throws InsufficientNumbersException, EmptyStackException, FullStackException{
         if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
         }
        ComplexNum primo=stackNumeri.remove(); //Prelevo il primo numero complesso dello stack
        ComplexNum secondo=stackNumeri.remove(); //Prelevo il secondo numero complesso dello stack
        stackNumeri.insert(sottrazione(secondo,primo)); //Inserisco la sottrazione dei due numeri nello stack
    }
    
    /*Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce in esso la loro divisione.
    Può lanciare un’eccezione controllata di tipo InsufficientNumberException se 
    lo stack ha meno di due numeri,e un’eccezione controllata di tipo MathException se si prova a dividere per 0.
    */
    public void stackDiv()throws InsufficientNumbersException,MathException, EmptyStackException, FullStackException{
         if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
        }
        
        ComplexNum primo=stackNumeri.remove();//Prelevo il primo numero complesso dello stack
        ComplexNum secondo=stackNumeri.remove();//Prelevo il secondo numero complesso dello stack
        ComplexNum div=divisione(secondo,primo); //Eseguo l'operazione di divisione dei due numeri
        
        if(div==null){  //Controllo se la divisione è andata a buon fine
            stackNumeri.insert(secondo);    //Reinserisco i numeri nel giusto ordine
            stackNumeri.insert(primo);
            throw new MathException("Math Exception Error"); //Eccezione lanciata se il secondo numero è uguale a 0
        }else
            stackNumeri.insert(div); //Inserisco la divisione dei due numeri nello stack
    }
    
    /*
    Metodo che preleva i primi due numeri dalla cima
    dello stack e inserisce in esso la loro moltiplicazione.
    Può lanciare un’eccezione controllata di tipo InsufficientNumberException se 
    lo stack ha meno di due numeri.
    */
    public void stackMul()throws InsufficientNumbersException, EmptyStackException, FullStackException{
         if(stackNumeri.getSize()<=1){
              throw new InsufficientNumbersException("Insufficient Numbers Error");
         }
        ComplexNum primo=stackNumeri.remove(); //Prelevo il primo numero complesso dello stack
        ComplexNum secondo=stackNumeri.remove(); //Prelevo il secondo numero complesso dello stack
        stackNumeri.insert(moltiplicazione(primo,secondo)); //Inserisco la moltiplicazione dei due numeri nello stack
        
    }
    
    /*Metodo che preleva il numero in cima allo stack
     e inserisce in esso lo stesso numero ma invertito di segno.
    Può lanciare un’eccezione controllata di tipo EmptyStackException se 
    lo stack è vuoto.
    */
    public void stackSignInv()throws EmptyStackException, FullStackException{
        ComplexNum num=stackNumeri.remove(); //Prelevo il numero complesso dello stack
        stackNumeri.insert(invSegno(num)); //Inserisco il numero invertito di segno nello stack
    }
    
    /*Metodo che preleva il numero in cima allo stack
     e inserisce in esso la sua radice.
    Può lanciare un’eccezione controllata di tipo EmptyStackException se 
    lo stack è vuoto.
    */
    public void stackSqrt()throws EmptyStackException, FullStackException{
        ComplexNum num=stackNumeri.remove(); //Prelevo il numero complesso dello stack
        stackNumeri.insert(sqrt(num)); //Inserisco la radice del numero nello stack
    }
}
