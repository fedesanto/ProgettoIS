package progettoIS.gruppo01.Calculator.Management;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Complex.MathOperations;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Calculator.Structures.VarContainer;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;


public class VarManagement implements InputManagement{
    private ComplexStack stackNumeri;
    private VarContainer varContainer;
    
    public VarManagement(ComplexStack stackNumeri, VarContainer varContainer){
        this.stackNumeri = stackNumeri;
        this.varContainer = varContainer;
    }
    
    
    /*
    Esegue l'operazione su variabile richiesta
    Recupera dalla stringa passa in input il simbolo dell'operazione e il nome della variabile su cui effettuarla
    Dopodichè richiama uno dei metodi privati di cui dispone la classe, richiamando lo specifico metodo che si occupa di eseguire l'operazione richiesta
    
    Input:
        - String input, stringa di input specificante l'operazione e la variabile su cui eseguirla
    */
    @Override
    public void execute(String input) throws FullStackException, EmptyStackException, UninitializedVariableException {
        Character operator;
        Character variable;
        
        operator = input.charAt(0); //Recupero l'operatore dalla stringa di input
        variable = input.charAt(1); //Recupero il nome della variabile dalla stringa di input
        
        //Eseguo l'operazione richiesta
        if(operator.equals('>'))
            saveVar(variable);
        else if(operator.equals('<'))
            insVar(variable);
        else if(operator.equals('+'))
            addVar(variable);
        else if(operator.equals('-'))
            subVar(variable);
    }
    
    
    /*
    Esegue l'operazione di somma nella variabile
    Preleva un numero dallo stack, preleva il contenuto della variabile indicata
    somma i due numeri e scrive il risultato nella variabile indicata
    
    Input:
        - Character var, variabile su cui effettuare l'operazione
    */
    private void addVar(Character var) throws UninitializedVariableException, EmptyStackException{
        ComplexNum numFromStack, numFromVar;
        
        numFromStack = stackNumeri.remove();
        numFromVar = varContainer.getValue(var);
        
        varContainer.setValue(var, MathOperations.somma(numFromStack, numFromVar));
    }
    
    
    /*
    Esegue l'operazione di sotrrazione nella variabile
    Preleva un numero dallo stack, preleva il contenuto della variabile indicata
    sottrae i due numeri e scrive il risultato nella variabile indicata
    
    Input:
        - Character var, variabile su cui effettuare l'operazione
    */
    private void subVar(Character var) throws UninitializedVariableException, EmptyStackException{
        ComplexNum numFromStack, numFromVar;
        
        numFromStack = stackNumeri.remove();
        numFromVar = varContainer.getValue(var);
        
        varContainer.setValue(var, MathOperations.sottrazione(numFromVar, numFromStack));
    }
    
    
    /*
    Esegue l'operazione di salvataggio nella variabile
    Preleva un numero dallo stack, e lo inserisce all'interno della variabile indicata
    
    Input:
        - Character var, variabile in cui inserire il numero
    */
    private void saveVar(Character var) throws EmptyStackException {
        ComplexNum numFromStack;
        
        numFromStack = stackNumeri.remove();
        varContainer.setValue(var, numFromStack);
    }
    
    
    /*
    Esegue l'operazione di inserimento dalla variabile
    Legge il contenuto della variabile indicata e lo inserisce all'interno dello stack
    
    Input:
        - Character var, variabile in cui inserire il numero
    */
    private void insVar(Character var) throws UninitializedVariableException, FullStackException{
        ComplexNum numFromVar;
        
        numFromVar = varContainer.getValue(var);
        stackNumeri.insert(numFromVar);
    }
}
