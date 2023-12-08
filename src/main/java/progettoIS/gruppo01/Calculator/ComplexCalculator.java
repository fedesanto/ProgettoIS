package progettoIS.gruppo01.Calculator;

import progettoIS.gruppo01.Calculator.ButtonOp.MathExecuter;
import progettoIS.gruppo01.Calculator.ButtonOp.StackCommander;
import progettoIS.gruppo01.Calculator.Management.InsertionManagement;
import progettoIS.gruppo01.Calculator.Management.VarManagement;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Calculator.Structures.VarContainer;
import progettoIS.gruppo01.Exceptions.*;

public class ComplexCalculator {

    private MathExecuter mathExecuter;      //Gestore operazioni matematiche
    private StackCommander stackCommander;  //Gestore comandi su stack
    private VarManagement varManager;       //Gestore operazioni su variabili
    private InsertionManagement insertionManager;   //Gestore inserimenti di numeri nello stack

    private final int MAX_CAPACITY = 50;    //Capacità massima dello stack
    private final int LAST_NUMBERS = 12;    //Numero di numeri da visualizzare dalla cima dello stack

    /*
    Costruttore, 
    inizializza tutte le componenti fornendo loro i riferimenti necessari
     */
    public ComplexCalculator() {
        ComplexStack complexStack = new ComplexStack(MAX_CAPACITY);

        mathExecuter = new MathExecuter(complexStack);
        stackCommander = new StackCommander(complexStack);
        varManager = new VarManagement(complexStack, new VarContainer());
        insertionManager = new InsertionManagement(complexStack);
    }

    /*
    Parse dell'input testale
        Input:
            - input: stringa in input
     */
    public void parseInput(String input) throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        /*
        accetta un input se nel formato "a + bj","a" o "bj",
        dove a e b sono numeri reali
         */
        if (input.matches("-?\\d+(.\\d+)? [-+] \\d+(.\\d+)?j") || input.matches("-?\\d+(.\\d+)?") || input.matches("-?\\d+(.\\d+)?j")) {
            insertionManager.execute(input);
            /*
        accetta una input se nel formato "+x","-x","<x",">x",
        dove x è una variabile generica
             */
        } else if (input.matches("[+-><][a-z]")) {
            varManager.execute(input);
        } //se l'input non rispetta nessuno dei formati validi lancia una syntax exception
        else {
            throw new SyntaxException("SYNTAX ERROR");
        }
    }

    //Operazione matematica '+' della calcolatrice
    public void add() throws InsufficientNumbersException{
        mathExecuter.stackAdd();
    }

    //Operazione matematica '-' della calcolatrice
    public void sub() throws InsufficientNumbersException{
        mathExecuter.stackSub();
    }

    //Operazione matematica '/' della calcolatrice
    public void div() throws InsufficientNumbersException, MathException{
        mathExecuter.stackDiv();
    }

    //Operazione matematica '*' della calcolatrice
    public void mul() throws InsufficientNumbersException{
        mathExecuter.stackMul();
    }

    //Operazione matematica '+-' della calcolatrice
    public void signInv() throws EmptyStackException{
        mathExecuter.stackSignInv();
    }

    //Operazione matematica 'sqrt' della calcolatrice
    public void sqrt() throws EmptyStackException{
        mathExecuter.stackSqrt();
    }

    //Comando su stack 'clear' della calcolatrice
    public void clear(){
        stackCommander.stackClear();
    }

    //Comando su stack 'drop' della calcolatrice
    public void drop() throws EmptyStackException {
        stackCommander.stackDrop();
    }

    //Comando su stack 'dup' della calcolatrice
    public void dup() throws EmptyStackException, FullStackException {
        stackCommander.stackDup();
    }

    //Comando su stack 'swap' della calcolatrice
    public void swap() throws InsufficientNumbersException{
        stackCommander.stackSwap();
    }

    //Comando su stack 'over' della calcolatrice
    public void over() throws InsufficientNumbersException, FullStackException{
        stackCommander.stackOver();
    }

    /*
    Metodo che permette di ottenre sotto forma di stringa gli ultimi LAST_NUMBERS 
    presenti dalla cima dello stack
        Output:
            - vettore di stringhe degli ultimi LAST_NUMBERS dalla cima dello stack
     */
    public String[] getLastNumbers(){
        return stackCommander.getContent(LAST_NUMBERS);
    }
}
