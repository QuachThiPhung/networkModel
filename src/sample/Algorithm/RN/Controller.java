package sample.Algorithm.RN;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
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

