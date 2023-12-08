package progettoIS.gruppo01.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ViewController implements Initializable{
    
    /*
    Attributi associati ad elementi grafici della view
    L'associazione viene fatta automaticamente dall'FXML loader durante il caricamento del file xml rappresentate la view
    */
    @FXML private TextField inputArea;
    @FXML private TextField errorArea;
    @FXML private TextField stackArea;

    
    /*
    Metodo di inizializzazione del controller
    Associa un'azione all'input area che gli permette di svuotarsi alla pressione dell'invio
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputArea.setOnAction(e -> inputArea.clear());
    }
    
    @FXML
    private void inputEvent(ActionEvent event) {
        
    }
    
    @FXML
    public void addEvent(){
        /*try{
            complexCalculator.add();
            
            //pulisci area
        }catch(InsufficientNumbersException ex){
            printInsufficientNumbersError();
        }*/
    }

    @FXML
    private void signInvEvent(ActionEvent event) {
    }

    @FXML
    private void subEvent(ActionEvent event) {
    }

    @FXML
    private void mulEvent(ActionEvent event) {
    }

    @FXML
    private void divEvent(ActionEvent event) {
    }

    @FXML
    private void sqrtEvent(ActionEvent event) {
    }

    @FXML
    private void dropEvent(ActionEvent event) {
    }

    @FXML
    private void dupEvent(ActionEvent event) {
    }

    @FXML
    private void swapEvent(ActionEvent event) {
    }

    @FXML
    private void overEvent(ActionEvent event) {
    }

    @FXML
    private void clearEvent(ActionEvent event) {
    }
    
    private void updateView(){
        
    }  
    
    private void printSyntaxError(){
        
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
