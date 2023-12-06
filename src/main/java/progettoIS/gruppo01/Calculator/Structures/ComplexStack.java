package progettoIS.gruppo01.Calculator.Structures;

import java.util.Stack;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;

/*
    La classe ComplexStack rappresenta lo stack di numeri complessi 
    su cui si basano tutte le operazioni della calcolatrice. 
    Ha una capacità limita, fissata all’atto di creazione dell’oggetto, 
    che ne determina un numero massimo di inserimenti. 
    Fa utilizzo della collezione Stack implementata nel package java.util
*/

public class ComplexStack {
    
    private Stack<ComplexNum> numeri;
    private int maxCapacity;
    
    
    /*
        COMPLEXSTACK
        Costruttore con passaggio di maxCapacity
    */
    public ComplexStack(int maxCapacity) { 
        
        this.maxCapacity = 50;
        numeri = new Stack();
        
    }
    
    
    /*
        INSERT
        Aggiunge un numero in cima allo stack. 
        Può lanciare un’eccezione controllata di tipo FullStackException se 
        si tenta di aggiungere un numero e la struttura ha raggiunto la capacità massima
    
        input :
            - numero complesso ComplexNum num;
    */
    
    public void insert(ComplexNum num) throws FullStackException{
        
        if(numeri.size() == maxCapacity){
            
            throw new FullStackException("FULL STACK ERROR");
            
        }
       
        numeri.push(num);
    }
    
    /*
        REMOVE
        Rimuove e restituisce l’elemento in cima allo stack. 
        Può lanciare un’eccezione controllata di tipo EmptyStackException se 
        si tenta di rimuovere un numero e la struttura è vuota
    
        output : 
            - elemento in cima allo stack di tipo ComplexNum;
    */
    
    public ComplexNum remove() throws EmptyStackException{
        
        if(numeri.isEmpty()){
            
            throw new EmptyStackException("EMPTY STACK ERROR");
            
        }
        
        return numeri.pop();
            
    }
    
    /*
        TOP
        Restituisce, senza rimuoverlo, l’elemento in cima allo stack. 
        Può lanciare un’eccezione controllata di tipo EmptyStackException se si 
        tenta di accedere all’elemento in cima e la struttura è vuota
    
        output : 
            - copia numero in cima di tipo ComplexNum;
    
    */
    
    public ComplexNum top() throws EmptyStackException{
        
        if(numeri.isEmpty()){
            
            throw new EmptyStackException("EMPTY STACK ERROR");
            
        }
        
        ComplexNum e = numeri.firstElement();
        
        return e;
        
    }
    
    /*
        Restituisce il numero di elementi attualmente presenti nella struttura
        
        output:
            - numero presenti nello stack, tipo restituito int; 
    */
    
    public int getSize(){
        
        return numeri.size();
        
    }
}
