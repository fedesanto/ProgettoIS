package progettoIS.gruppo01.Calculator.Structures;

import java.util.HashMap;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;


/*
    La classe VarContainer rappresenta il contenitore delle variabili gestibili dalla calcolatrice. 
    Utilizza la collezione HashMap, implementata nel package java.util, per mappare i nomi delle variabili ai valori assegnati.
*/
public class VarContainer {

    private HashMap <Character, ComplexNum> variables;

    
    /*  
        VARCONTAINER
        Costruttore con parametri di inizializzazione.
    */
    public VarContainer() {
        
        variables = new HashMap();
        
    }
    
    /*
        Setta il valore di una variabile di cui ne viene indicata il nome, 
        aggiungendola alla collezione se non è mai stata utilizzata.
        
        input : 
            - elemento caratterizzato da una coppia chiave(var) , valore(num);
    */
    public void setValue(Character var, ComplexNum num){
        
        variables.put(var, num);
        
    }
    
    /*
        Restituisce il numero associato alla variabile indicata. 
        Può lanciare un’eccezione controllata di tipo UninitializedVariableException 
        nel caso in cui la variabile indicata non fosse stata ancora aggiunta alla collezione.
    
        input : 
            - varibile di tipo char;
    
        output : 
            - valore associato alla variabile var di tipo ComplexNum;
    */
    public ComplexNum getValue(Character var) throws UninitializedVariableException {
        
        if(!variables.containsKey(var)){
            throw new UninitializedVariableException("UNINITIALIZED VARIABLE ERROR");
        }
            
        return variables.get(var);
        
    } 
}
