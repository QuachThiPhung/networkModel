package sample.Algorithm.BA;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {
        int vertices;
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

        //next step and exec button goes here
        @FXML
        void nextStep(ActionEvent event) {

        }

        @FXML
        void execStep(ActionEvent event) {

        }

        @FXML
        void getData(ActionEvent event) {
            String verticestxt = verticesID.getText();
            if (verticestxt.isEmpty()) verticestxt = "0";
            if (isInteger(verticestxt)) {
                vertices = Integer.parseInt(verticestxt);
                if (vertices >= 2) {
                    JOptionPane.showMessageDialog(null, "Number of vertices is:" + vertices);
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

