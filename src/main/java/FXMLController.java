

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

 
    @FXML private TextField textField;
    @FXML private Button button;
    @FXML private TextArea textArea;

    WordFinder w = new WordFinder("sowpods.txt");

 
    @FXML
    protected void printout() {
    	String[] query = textField.getText().split(" ");
    	List<String> result = w.search(query);
    	for (String s: result) textArea.appendText(s+"\n");
     }
    
}