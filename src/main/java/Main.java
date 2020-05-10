import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) 
    {
    
        primaryStage.setTitle("My First JavaFX GUI");
        
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ScrabbleGUI.fxml"));
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}