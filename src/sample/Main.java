package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Vector;

public class Main extends Application {

    Vector<Vector<Item>> field;
    Group winGroup;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        winGroup = new Group();
        setField(15, 15);
        Scene mainScene = new Scene(winGroup, 500, 500);
        primaryStage.setScene(mainScene);


        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
        System.out.println("ok");
    }

    public void setField(int SizeX, int SizeY){
        field = new Vector<Vector<Item> >();
        field.setSize(SizeX);
        for(int i = 0; i < SizeX; i++){
            field.set(i, new Vector<Item>());
            field.get(i).setSize(SizeY);
            for(int j = 0; j < SizeY; j ++){
                field.get(i).set(j, new Item());
                field.get(i).get(j).onCreate();

                field.get(i).get(j).toRightB.setLayoutX(50+j*50);
                field.get(i).get(j).toRightB.setLayoutY(30+i*50);
                field.get(i).get(j).toRightB.setScaleX(0.5);
                field.get(i).get(j).toRightB.setScaleY(2);

                field.get(i).get(j).toDownB.setLayoutX(30+j*50);
                field.get(i).get(j).toDownB.setLayoutY(50+i*50);
                field.get(i).get(j).toDownB.setScaleX(3);
                field.get(i).get(j).toDownB.setScaleY(0.3);

                field.get(i).get(j).isCubeB.setLayoutX(25+j*50);
                field.get(i).get(j).isCubeB.setLayoutY(25+i*50);
                field.get(i).get(j).isCubeB.setScaleX(2);


                winGroup.getChildren().add(field.get(i).get(j).toDownB);
                winGroup.getChildren().add(field.get(i).get(j).toRightB);
                winGroup.getChildren().add(field.get(i).get(j).isCubeB);
            }
        }
    }


}
