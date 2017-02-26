package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Item {

    public Boolean toRight;
    public Boolean toDown;
    public Button toDownB;
    public Button toRightB;


    public void onCreate(){
        toRight = false;
        toDown = false;
        toDownB = new Button();
        toDownB.setOpacity(0.2);
        toRightB = new Button();
        toRightB.setOpacity(0.2);

        onCreateButtonsActions();
    }

    private void onCreateButtonsActions(){
        toDownB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toDown = !toDown;
                if(toDownB.getOpacity() == 1){
                    toDownB.setOpacity(0.2);
                }else{
                    toDownB.setOpacity(1);
                }
            }
        });
        toRightB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toRight = !toRight;
                if(toRightB.getOpacity() == 1){
                    toRightB.setOpacity(0.2);
                }else{
                    toRightB.setOpacity(1);
                }
            }
        });
    }


}
