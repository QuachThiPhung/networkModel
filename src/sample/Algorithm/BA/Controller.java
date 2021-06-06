package sample.Algorithm.BA;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Controller {
        int vCount;
        BAGraph myGraph = new BAGraph();
        public boolean isInteger (String s){
            try{
                Integer.parseInt(s);
                return true;
            }   catch (NumberFormatException e){
                return false;
            }
        }
        @FXML
        private Button enterButton;

        @FXML
        private TextField verticesID;

        @FXML
        private Button GoBack;

        @FXML
        private Button nextButton;

        @FXML
        private Button execButton;


        @FXML
        void getData(ActionEvent event) {
            String verticestxt = verticesID.getText();
            if (verticestxt.isEmpty()) verticestxt = "0";
            if (isInteger(verticestxt)) {
                vCount = Integer.parseInt(verticestxt);
                if (vCount >= 2) {
                    JOptionPane.showMessageDialog(null, "Number of vertices is: " + vCount);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer larger than 2");
                    //return false
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer larger than 2");
                //return false
            }
        }

        //return to main scene
        @FXML
        void Return(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/sample.fxml"));
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                scene.getStylesheets().add("sample/style.css");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


        //Create random nodes
        @FXML
        private AnchorPane drawPane;

        List<Node> list = new ArrayList<>();

        @FXML
        private Button generateButton;

        BAGraph newGraph = new BAGraph();
        @FXML
        void generate(ActionEvent event) {
            newGraph.execAlgorithm(drawPane, vCount);
        }

        //Reset all nodes
        @FXML
        private Button resetButton;

        @FXML
        void reset (ActionEvent event){
            for (int i = 0; i < list.size(); i++){
                drawPane.getChildren().remove(list.get(i));
            }
            vCount = 0;
            JOptionPane.showMessageDialog(null, "Successfully removed!");
        }
}