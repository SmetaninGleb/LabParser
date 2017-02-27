package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Item {

    public Boolean toRight;
    public Boolean toDown;
    public Boolean isCube;
    public Button toDownB;
    public Button toRightB;
    public Button isCubeB;


    public void onCreate() {
        toRight = false;
        toDown = false;
        isCube = false;
        toDownB = new Button();
        toDownB.setOpacity(0.2);
        toRightB = new Button();
        toRightB.setOpacity(0.2);
        isCubeB = new Button();
        isCubeB.setOpacity(0.2);


        onCreateButtonsActions();
    }

    private void onCreateButtonsActions() {
        toDownB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toDown = !toDown;
                if (toDownB.getOpacity() == 1) {
                    toDownB.setOpacity(0.2);
                } else {
                    toDownB.setOpacity(1);
                }
            }
        });
        toRightB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toRight = !toRight;
                if (toRightB.getOpacity() == 1) {
                    toRightB.setOpacity(0.2);
                } else {
                    toRightB.setOpacity(1);
                }
            }
        });
        isCubeB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isCube = !isCube;
                if(isCubeB.getOpacity() == 1){
                    isCubeB.setOpacity(0.2);
                }else{
                    isCubeB.setOpacity(1);
                }
            }
        });
    }


}
