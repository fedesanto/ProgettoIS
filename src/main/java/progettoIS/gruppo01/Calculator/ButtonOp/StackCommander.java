package progettoIS.gruppo01.Calculator.ButtonOp;

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
    
    /*Metodo che svuota completamente lo stack.
    Può lanciare un’eccezione controllata di tipo EmptyStackException se lo stack è vuoto.
    */
    public void stackClear() throws EmptyStackException{
        for(int i=0;i<stackNumeri.getSize();i++){
            stackNumeri.remove();
        }
    }
    
    /*Metodo che rimuove il numero in cima allo stack.
    Può lanciare un’eccezione controllata di tipo EmptyStackException se lo stack è vuoto.
    */ 
    public void stackDrop() throws EmptyStackException{

        stackNumeri.remove(); 

    }
        
    /*Metodo che duplica il numero presente in cima allo stack
    Può lanciare un’eccezione controllata di tipo FullStackException se lo stack è pieno,
    e un’eccezione controllata di tipo EmptyStackException se lo stack è vuoto
    */
    public void stackDup() throws FullStackException,EmptyStackException{
        if(stackNumeri.getSize()==0){
            throw new EmptyStackException("Empty Stack Error");
        }
        stackNumeri.insert(stackNumeri.top()); 
    }
     
    /*Metodo che inverte la posizione dei due numeri in cima allo stack.
    Può lanciare un’eccezione controllata di tipo InsufficientNumbersException se lo stack ha meno di due numeri.
    */
    public void stackSwap() throws InsufficientNumbersException, EmptyStackException, FullStackException{
        if(stackNumeri.getSize()<=1){
            throw new InsufficientNumbersException("Insufficient Numbers Error");
        }
        ComplexNum primo=stackNumeri.remove(); //Prelievo del primo numero 
        ComplexNum secondo=stackNumeri.remove(); //Prelievo del secondo numero 
        stackNumeri.insert(primo); //Reinserimento del primo numero
        stackNumeri.insert(secondo); //Reinserimento del secondo numero
    }
     
    /*Metodo che duplica in cima allo stack il numero nella seconda posizione
    Può lanciare un’eccezione controllata di tipo InsufficientNumbersExceptionse lo stack ha meno di due numeri,
    e un’eccezione controllata di tipo FullStackExceptionse lo stack è pieno
    */
    public void stackOver() throws InsufficientNumbersException,FullStackException, EmptyStackException{
        if(stackNumeri.getSize()<=1){
            throw new InsufficientNumbersException("Insufficient Numbers Error");
        }
        ComplexNum primo=stackNumeri.remove(); //Prelievo del primo numero 
        ComplexNum secondo=stackNumeri.top(); //Copia del secondo numero
        stackNumeri.insert(primo); //Reinserimento del primo numero
        stackNumeri.insert(secondo); //Inserimento della copia del secondo numero
    }
    
    /*Metodo che restituisce un vettore di stringhe contenente
    i primi 'num' numeri dalla cima dello dello stack.
    Se lo stack ha meno di ‘num’ numeri, il vettore conterrà tutti i numeri presenti nello stack.
    Se lo stack è vuoto, restituisce Null.
    */
    public String[] getContent(int num) throws EmptyStackException, FullStackException{
        if(stackNumeri.getSize()==0){
           return null;
        }
        
        if(num>stackNumeri.getSize()){ //Controllo che 'num' non sia maggiore rispetto al numero di valori attualmente contenuti nello stack 
            num=stackNumeri.getSize(); //Controllo effettuato per evitare inutili rimozioni dallo stack che causerebbero EmptyStackException
        }
        ComplexNum t[] = new ComplexNum[num]; //Vettore di ComplexNum per contenere temporaneamente i numeri rimossi dallo stack
        String v[] = new String[num]; //Vettore di stringhe in cui inserire i numeri,espressi nel formato restituito dal loro metodo toString() 
         
        for(int i=0;i<num;i++){
            t[i]=stackNumeri.remove(); //Rimozione temporanea dei numeri dallo stack
            v[i]=t[i].toString(); //Inserimento, nel vettore di stringhe, dei numeri espressi nel formato restituito dal loro metodo toString()
        }
        
        for(int i=num-1;i>=0;i--){
            stackNumeri.insert(t[i]); //Reinserimento dei numeri nello stack
        }
         
        return v;
    } 
}
