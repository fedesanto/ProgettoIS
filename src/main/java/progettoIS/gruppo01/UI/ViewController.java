package progettoIS.gruppo01.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import progettoIS.gruppo01.Calculator.ComplexCalculator;
import progettoIS.gruppo01.Exceptions.*;

public class ViewController implements Initializable{
    
    /*
    Attributi associati ad elementi grafici della view
    L'associazione viene fatta automaticamente dall'FXML loader durante il caricamento del file xml rappresentate la view
    */
    @FXML private TextField inputArea;
    @FXML private TextArea errorArea;
    @FXML private VBox stackArea;
    
    private ComplexCalculator calculator;

    
    /*
    Metodo di inizializzazione del controller
    Associa un'azione all'input area che gli permette di svuotarsi alla pressione dell'invio
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculator = new ComplexCalculator();
    }
    
    /*
    Metodo associato all'evento dell'invio di un input tramite area di testo
    In ordine:
        1) Recupera il contenuto dell'area di test
        2) Svuota l'area di testo
        3) Passa l'input al metodo parseInput del modello
        4) Se ci sono errori derivanti dall'input, stampa il messaggio nell'area degli errori legato al primo errore rilevato
        5) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void inputEvent(ActionEvent event) {
        try{
            String input = inputArea.getText();
            
            inputArea.clear();
            calculator.parseInput(input);
            
            updateView();
            errorArea.clear();
        }catch (FullStackException ex) {
            this.printFullStackError();
        }catch (EmptyStackException ex) {
            this.printEmptyStackError();
        }catch (UninitializedVariableException ex) {
            this.printUninitializedVariableError();
        }catch (SyntaxException ex) {
            this.printSyntaxError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone '+'
    In ordine:
        1) Richiama il metodo add del modello
        2) Se c'è un'insufficient number error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    public void addEvent(){
        try{
            calculator.add();
            
            updateView();
            errorArea.clear();
        }catch (InsufficientNumbersException ex) {
            this.printInsufficientNumbersError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone '-'
    In ordine:
        1) Richiama il metodo sub del modello
        2) Se c'è un'insufficient number error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void subEvent(ActionEvent event) {
        try{
            calculator.sub();
            
            updateView();
            errorArea.clear();
        }catch (InsufficientNumbersException ex) {
            this.printInsufficientNumbersError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone '/'
    In ordine:
        1) Richiama il metodo div del modello
        2) Se c'è un'insufficient number error o un math error, stampa il messaggio nell'area degli errori correlato al primo errore rilevato
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void divEvent(ActionEvent event) {
        try{
            calculator.div();
            
            updateView();
            errorArea.clear();
        }catch (InsufficientNumbersException ex) {
            this.printInsufficientNumbersError();
        }catch (MathException ex) {
            this.printMathError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone '*'
    In ordine:
        1) Richiama il metodo mul del modello
        2) Se c'è un'insufficient number error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void mulEvent(ActionEvent event) {
        try{
            calculator.mul();
            
            updateView();
            errorArea.clear();
        }catch (InsufficientNumbersException ex) {
            this.printInsufficientNumbersError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone '+-'
    In ordine:
        1) Richiama il metodo signInv del modello
        2) Se c'è un'empty stack error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void signInvEvent(ActionEvent event) {
        try{
            calculator.signInv();
            
            updateView();
            errorArea.clear();
        }catch (EmptyStackException ex) {
            this.printEmptyStackError();
        }
    }

    /*
    Metodo associato all'evento della pressione del bottone 'sqrt'
    In ordine:
        1) Richiama il metodo signInv del modello
        2) Se c'è un'empty stack error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void sqrtEvent(ActionEvent event) {
        try{
            calculator.sqrt();
            
            updateView();
            errorArea.clear();
        }catch (EmptyStackException ex){
            this.printEmptyStackError();
        }
    }
    
    /*
    Metodo associato all'evento della pressione del bottone 'drop'
    In ordine:
        1) Richiama il metodo drop del modello
        2) Se c'è un'empty stack error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void dropEvent(ActionEvent event) {
        try{
            calculator.drop();
            
            updateView();
            errorArea.clear();
        }catch(EmptyStackException ex){
            this.printEmptyStackError();
        }
    }

    /*
    Metodo associato all'evento della pressione del bottone 'dup'
    In ordine:
        1) Richiama il metodo dup del modello
        2) Se c'è un full stack error o un empty stack error, stampa il messaggio nell'area degli errori correlato al primo errore rilevato
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void dupEvent(ActionEvent event) {
        try{
            calculator.dup();
            
            updateView();
            errorArea.clear();
        }catch(FullStackException ex){
            this.printFullStackError();
        }catch(EmptyStackException ex){
            this.printEmptyStackError();
        }
    }

    /*
    Metodo associato all'evento della pressione del bottone 'swap'
    In ordine:
        1) Richiama il metodo swap del modello
        2) Se c'è un'insufficient numbers error, ne stampa il messaggio correlato nell'area degli errori
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void swapEvent(ActionEvent event) {
        try{
            calculator.swap();
            
            updateView();
            errorArea.clear();
        }catch(InsufficientNumbersException ex){
            this.printInsufficientNumbersError();
        }
    }

    /*
    Metodo associato all'evento della pressione del bottone 'over'
    In ordine:
        1) Richiama il metodo over del modello
        2) Se c'è un insufficient numbers error o un full stack error, stampa il messaggio nell'area degli errori correlato al primo errore rilevato
        3) Se tutto è andato a buon fine, aggiorna l'area dello stack e si assicura che l'area errori sia vuota
    */
    @FXML
    private void overEvent(ActionEvent event) {
        try{
            calculator.over();
            
            updateView();
            errorArea.clear();
        }catch(InsufficientNumbersException ex){
            this.printInsufficientNumbersError();
        }catch(FullStackException ex){
            this.printFullStackError();
        }
    }

    @FXML
    private void clearEvent(ActionEvent event) {
        calculator.clear();
        
        updateView();
        errorArea.clear();
    }
    
    /*
    Metodo di aggiornamento dell'area dello stack
    In ordine:
        1) Recupera gli ultimi 12 elementi presenti nello stack
        2) Se lo stack è vuoto, si assicura che l'area dello stack sia anch'essa vuota
        3) Se ci sono numeri, aggiorna ciascuna label presente nell'area stack con il valore adeguato
    */
    private void updateView(){
        String[] numbers = calculator.getLastNumbers(); //Recupero gli ultimi 12 numeri nello stack
        int stackSize = stackArea.getChildren().size(); //Recuper il numero di label nell'area stack
        
        if(numbers != null){
            /*
            Aggiorno le label con i numeri restituiti dalla calcolatrice.
            Da notare come recupero le label nel VBox tramite indice 'stackSize-i-1'
            che da un punto di vista grafico equivale a partire dal basso
            */
            for(int i = 0; i < numbers.length; i++){
                Label l = (Label) stackArea.getChildren().get(stackSize-i-1);
                l.setText(numbers[i]);
            }
            
            //Mi assicuro che, nel caso in cui ci fossero meno di 12 numeri nello stack,
            //le restanti label, a cui non viene associato nessun numero, vengano svuotate
            for(int i = numbers.length; i < stackSize; i++){
                Label l = (Label) stackArea.getChildren().get(stackSize-i-1);
                l.setText("");
            }
        }else{
            //Nel caso in cui non ci fossero numeri nello stack, mi assicuro che tutte le label vengano svuotate
            for(int i = 0; i < stackSize; i++){
                Label l = (Label) stackArea.getChildren().get(i);
                l.setText("");
            }
        }
    }  
    
    private void printSyntaxError(){
        errorArea.setText("SYNTAX ERROR\n"
                        + "errore di sintassi");
    }
    
    private void printMathError(){
        
    }
    
    private void printFullStackError(){
        
    } 
    
    private void printEmptyStackError(){
        
    }
    
    private void printUninitializedVariableError(){
        
    }
    
    private void printInsufficientNumbersError(){
        
    }
}
