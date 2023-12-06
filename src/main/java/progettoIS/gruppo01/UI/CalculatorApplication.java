package progettoIS.gruppo01.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX CalculatorApplication
 */
public class CalculatorApplication extends Application {
    
    private final String XML_FILE = "xml_calcolatrice.fxml";
    private final int SCENE_WIDTH = 330;
    private final int SCENE_HEIGHT = 460;
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(XML_FILE));
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        //Scene scene = new Scene(loadFXML("xml_calcolatrice"), 330, 460);

        stage.setTitle("Complex Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /*
    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/

    public static void main(String[] args) {
        launch();
    }

}