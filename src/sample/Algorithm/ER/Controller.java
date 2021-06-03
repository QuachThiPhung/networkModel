package sample.Algorithm.ER;

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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    int vertices;
    double prob;
    public boolean isInteger (String s){
        try{
            Integer.parseInt(s);
            return true;
        }   catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isDouble (String s){
        try{
            Double.parseDouble(s);
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
    private TextField VerticesID;

    @FXML
    private TextField probID;

    @FXML
    private Button enterButton;

    @FXML
    void getData(ActionEvent event) {
        String verticestxt = VerticesID.getText();
        String probtxt = probID.getText();
        if (verticestxt.isEmpty()) verticestxt = "0";
        if (probtxt.isEmpty()) probtxt = "0";
        if (isInteger(verticestxt)){
            vertices = Integer.parseInt(verticestxt);
            if (vertices >= 0) {
                JOptionPane.showMessageDialog(null, "Number of vertices is:" + vertices);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer ");
                //return false
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Input must be an Integer ");
            //return false
        }

        if (isDouble(probtxt)) {
            prob = Double.parseDouble(probtxt);
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
    //Create random nodes
    @FXML
    private AnchorPane drawPane;

    List<nodeCircle> list = new ArrayList<>();
    List<Node> lineList = new ArrayList<>();

    @FXML
    private Button generateButton;

    @FXML
    void generate(ActionEvent event) {
        int x,y;
        for (int i = 0; i < vertices; i++){
            x = (int)(Math.random()*522+1);
            y = (int)(Math.random()*458+1);
            nodeCircle node = new nodeCircle();
            Circle circle = new Circle (x, y, 4, Color.RED);
            node.setX(x);
            node.setY(y);
            node.setCircle(circle);
            list.add(node);
            drawPane.getChildren().add(circle);
        }
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i+1; j < list.size(); j++){
                double probRandom = Math.random();
                if (probRandom <= prob){
                    Line line = new Line (list.get(i).getX(), list.get(i).getY(), list.get(j).getX(), list.get(j).getY());
                    drawPane.getChildren().add(line);
                    lineList.add(line);
                }
            }
        }
    }

    //Reset all nodes
    @FXML
    private Button resetButton;

    public void removeCircle(AnchorPane pane, Circle circle){
        pane.getChildren().remove(circle);
    }

    @FXML
    void reset (ActionEvent event){
        for (int i = 0; i < list.size(); i++){
            removeCircle(drawPane, list.get(i).getCircle());
            drawPane.getChildren().remove(list.get(i));
        }
        for (int i = 0; i < lineList.size(); i++){
            drawPane.getChildren().remove(lineList.get(i));
        }
        list.clear();
        lineList.clear();
        vertices = 0;
        JOptionPane.showMessageDialog(null, "Successfully removed!");
    }
}

