package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtCorrette.clear();
    	txtErrate.clear();
    	List<String> risultato = new ArrayList<String>(model.anagrammi(txtParola.getText()));
    	List<String> risultato2 = new ArrayList<String>(model.anagrammiErrati());
    	for(String s : risultato) {
    		txtCorrette.appendText(s+"\n");
    	}
    	for(String s : risultato2) {
    		txtErrate.appendText(s+"\n");
    	}
    	
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorrette.clear();
    	txtErrate.clear();
    	txtParola.clear();
    }
    public void setModel(Model model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Untitled'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Untitled'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Untitled'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Untitled'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Untitled'.";

    }

}

