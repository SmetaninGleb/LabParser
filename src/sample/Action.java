package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.li24robotics.ev3.robolab.lab.LabItem;

import java.io.*;
import java.util.ArrayList;


public class Action extends Application {

    ArrayList<ArrayList<LabParserItem>> field;

    Group enterFieldSizeGroup;
    Group fieldShowGroup;
    Integer fieldXSize;
    Integer fieldYSize;
    Scene enterFieldSizeScene;
    Scene fieldShowScene;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("LabParser");
        enterFieldSizeGroup = new Group();
        enterFieldSizeScene = new Scene(enterFieldSizeGroup, 500, 300);

        TextField widthTextField = new TextField();
        widthTextField.setLayoutX(180);
        widthTextField.setLayoutY(100);
        widthTextField.setText("Enter width of lab field");
        enterFieldSizeGroup.getChildren().add(widthTextField);

        TextField heightTextField = new TextField();
        heightTextField.setLayoutX(180);
        heightTextField.setLayoutY(150);
        heightTextField.setText("Enter height of lab field");
        enterFieldSizeGroup.getChildren().add(heightTextField);


        Button enterFieldSizeButton = new Button();
        enterFieldSizeButton.setLayoutX(220);
        enterFieldSizeButton.setLayoutY(200);
        enterFieldSizeButton.setText("Enter values");
        enterFieldSizeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fieldXSize = Integer.parseInt(widthTextField.getText());
                fieldYSize = Integer.parseInt(heightTextField.getText());
                if(fieldXSize != null && fieldYSize != null){
                    try {
                        activateShowFieldScene();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    primaryStage.setScene(fieldShowScene);
                    primaryStage.show();
                }
            }
        });
        enterFieldSizeGroup.getChildren().add(enterFieldSizeButton);

        primaryStage.setScene(enterFieldSizeScene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
        System.out.println("ok");
    }

    private void activateShowFieldScene() throws IOException {
        fieldShowGroup = new Group();
        fieldShowScene = new Scene(fieldShowGroup, 500, 500);
        field = new ArrayList<ArrayList<LabParserItem>>();
        for(int i = 0; i < fieldXSize; i++){
            field.add(i, new ArrayList<LabParserItem>());
            for(int j = 0; j < fieldYSize; j++){
                field.get(i).add(j, new LabParserItem(i * 55, j * 55));
                fieldShowGroup.getChildren().addAll(field.get(i).get(j).toForwardBtn,
                        field.get(i).get(j).toRightBtn, field.get(i).get(j).toBackBtn,
                        field.get(i).get(j).toLeftBtn, field.get(i).get(j).isCubeHereBtn);
            }
        }

        fileOutputStream = new FileOutputStream("MainLab.out");
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Button enterButton = new Button();
        enterButton.setText("Get parse file");
        enterButton.setLayoutX(fieldXSize * 55 + 30);
        enterButton.setLayoutY(fieldYSize * 55 + 30);
        ArrayList<ArrayList<LabItem>> mainField = new ArrayList<ArrayList<LabItem>>();
        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {

                for(int i = 0; i < fieldXSize; i ++){
                    mainField.add(i, new ArrayList<LabItem>());
                    for(int j = 0; j < fieldYSize; j ++){
                        mainField.get(i).add(j, field.get(i).get(j).labItem);
                    }
                }

                try {
                    parseToFile(mainField);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fieldShowGroup.getChildren().add(enterButton);

    }

    private void parseToFile(ArrayList<ArrayList<LabItem>> mainField) throws IOException {
        objectOutputStream.writeObject(mainField);
    }
}