package progettoIS.gruppo01.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{

    @FXML
    private TextField inputField;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputField.setOnAction(e -> inputField.clear());
    }
    
    @FXML
    public void metodo(){
        System.out.println("INVIO");
    }
    
    public void addEvent(){
        /*try{
            complexCalculator.add();
            
            //pulisci area
        }catch(InsufficientNumbersException ex){
            printInsufficientNumbersError();
        }*/
    }

    
}
