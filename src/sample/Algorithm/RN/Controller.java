package sample.Algorithm.RN;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    int node, edge;
    public boolean isInteger (String s){
        try{
            Integer.parseInt(s);
            return true;
        }   catch (NumberFormatException e){
            return false;
        }
    }
    @FXML
    private Button GoBack;

    @FXML
    private Button nextButton;

    @FXML
    private Button execButton;

    @FXML
    private TextField nodeID;

    @FXML
    private TextField edgeID;

    @FXML
    private Button enterButton;

    @FXML
    void getData(ActionEvent event) {
        String nodetxt = nodeID.getText();
        String edgetxt = edgeID.getText();
        if (nodetxt.isEmpty()) nodetxt = "0";
        if (edgetxt.isEmpty()) edgetxt = "0";
        if (isInteger(nodetxt)){
            node = Integer.parseInt(nodetxt);
            JOptionPane.showMessageDialog(null, "Node input is: " + node);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Node Input! Input must be an integer");
            //return false;
        }
        if (isInteger(edgetxt)) {
            edge = Integer.parseInt(edgetxt);
            JOptionPane.showMessageDialog(null, "Edge input is: " + edge);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Edge Input! Input must be an integer");
            //return false;
        }
    }
    //next step and exec button goes here
    @FXML
    void nextStep(ActionEvent event) {

    }

    @FXML
    void execStep(ActionEvent event) {

    }

    //return to main scene
    @FXML
    void Return(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/sample.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            scene.getStylesheets().add("sample/style.css");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}