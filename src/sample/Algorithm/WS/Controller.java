package sample.Algorithm.WS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;

public class Controller {
    int k, vertices;
    float prob;
    public boolean isInteger (String s){
        try{
            Integer.parseInt(s);
            return true;
        }   catch (NumberFormatException e){
            return false;
        }
    }
    public boolean isFloat (String s){
        try{
            Float.parseFloat(s);
            return true;
        }   catch (NumberFormatException e){
            return false;
        }
    }

    @FXML
    private TextField probID;
    @FXML
    private Button GoBack;
    @FXML
    private Button nextButton;
    @FXML
    private Button execButton;
    @FXML
    private Button enterButton;
    @FXML
    private TextField kID;
    @FXML
    private TextField verticesID;

    @FXML
    void getData (ActionEvent event){
        String verticestxt = verticesID.getText();
        String ktxt = kID.getText();
        String probtxt = probID.getText();
        if (verticestxt.isEmpty()) verticestxt = "0";
        if (ktxt.isEmpty()) ktxt = "0";
        if (probtxt.isEmpty()) probtxt = "0";
        if (isInteger(verticestxt)){
            vertices = Integer.parseInt(verticestxt);
            if (vertices >= 3) {
                JOptionPane.showMessageDialog(null, "Number of vertices is:" + vertices);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer larger than 3");
                //return false
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer larger than 3");
            //return false
        }
        if (isInteger(ktxt)){
            k = Integer.parseInt(ktxt);
            if (k%2 == 0){
                JOptionPane.showMessageDialog(null, "Number of mean degree is:" + k);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer divide by 2");
                //return false
            }
        } else{
            JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer divide by 2");
            //return false
        }

        if (isFloat(probtxt)) {
            prob = Float.parseFloat(probtxt);
            if (0 <= prob && prob <= 1){
                JOptionPane.showMessageDialog(null, "Probability is: " + prob);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input! Number must between 0 and 1");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Number must between 0 and 1");
            //return false
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

