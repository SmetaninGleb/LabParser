package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ru.li24robotics.ev3.robolab.lab.LabItem;


public class LabParserItem {
    LabItem labItem;
    Button toForwardBtn;
    Button toRightBtn;
    Button toBackBtn;
    Button toLeftBtn;
    Button isCubeHereBtn;
    double XCor, YCor;
    private static double opacityLevel = 0.3;
    private static double sizeXLevel = 0.5;
    private static double sizeYLevel = 1.4;
    private static double sizeXCube = 1.6;
    private static double sizeYCube = 0.9;

    public LabParserItem(double XCor, double YCor){
        this.XCor = XCor;
        this.YCor = YCor;

        initLabItem();

        toForwardBtn = new Button();
        toRightBtn = new Button();
        toBackBtn = new Button();
        toLeftBtn = new Button();
        isCubeHereBtn = new Button();
        setOpacityBtn();
        setOnActionBtn();
        setSizeBtn();
        setCorBtn();

    }

    private void setSizeBtn(){
        toForwardBtn.setScaleX(LabParserItem.sizeXLevel);
        toForwardBtn.setScaleY(LabParserItem.sizeYLevel);
        toForwardBtn.setRotate(90);

        toBackBtn.setScaleX(LabParserItem.sizeXLevel);
        toBackBtn.setScaleY(LabParserItem.sizeYLevel);
        toBackBtn.setRotate(90);

        toRightBtn.setScaleX(LabParserItem.sizeXLevel);
        toRightBtn.setScaleY(LabParserItem.sizeYLevel);

        toLeftBtn.setScaleX(LabParserItem.sizeXLevel);
        toLeftBtn.setScaleY(LabParserItem.sizeYLevel);

        isCubeHereBtn.setScaleX(LabParserItem.sizeXCube);
        isCubeHereBtn.setScaleY(LabParserItem.sizeYCube);
    }

    private void setCorBtn(){
        toForwardBtn.setLayoutX(XCor + 23);
        toForwardBtn.setLayoutY(YCor);

        toRightBtn.setLayoutX(XCor + 47);
        toRightBtn.setLayoutY(YCor + 25);

        toLeftBtn.setLayoutX(XCor);
        toLeftBtn.setLayoutY(YCor + 25);

        toBackBtn.setLayoutX(XCor + 23);
        toBackBtn.setLayoutY(YCor + 50);

        isCubeHereBtn.setLayoutX(XCor + 23);
        isCubeHereBtn.setLayoutY(YCor + 25);

    }

    private void initLabItem(){
        labItem = new LabItem("1");
        labItem.toForward.setNothingAboutWallHere(false);
        labItem.toForward.setWallIsHere(false);
        labItem.toRight.setNothingAboutWallHere(false);
        labItem.toRight.setWallIsHere(false);
        labItem.toBack.setNothingAboutWallHere(false);
        labItem.toBack.setWallIsHere(false);
        labItem.toLeft.setNothingAboutWallHere(false);
        labItem.toLeft.setWallIsHere(false);
    }

    private void setOpacityBtn(){
        toForwardBtn.setOpacity(LabParserItem.opacityLevel);
        toRightBtn.setOpacity(LabParserItem.opacityLevel);
        toBackBtn.setOpacity(LabParserItem.opacityLevel);
        toLeftBtn.setOpacity(LabParserItem.opacityLevel);
        isCubeHereBtn.setOpacity(LabParserItem.opacityLevel);
    }

    private void setOnActionBtn (){
        toForwardBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(toForwardBtn.getOpacity() == LabParserItem.opacityLevel){
                    toForwardBtn.setOpacity(1);
                }else{
                    toForwardBtn.setOpacity(LabParserItem.opacityLevel);
                }

                labItem.toForward.setWallIsHere(!labItem.toForward.isWallIsHere());
            }
        });
        toRightBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(toRightBtn.getOpacity() == LabParserItem.opacityLevel){
                    toRightBtn.setOpacity(1);
                }else{
                    toRightBtn.setOpacity(LabParserItem.opacityLevel);
                }

                labItem.toRight.setWallIsHere(!labItem.toRight.isWallIsHere());
            }
        });
        toBackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(toBackBtn.getOpacity() == LabParserItem.opacityLevel){
                    toBackBtn.setOpacity(1);
                }else{
                    toBackBtn.setOpacity(LabParserItem.opacityLevel);
                }

                labItem.toBack.setWallIsHere(!labItem.toBack.isWallIsHere());
            }
        });
        toLeftBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(toLeftBtn.getOpacity() == LabParserItem.opacityLevel){
                    toLeftBtn.setOpacity(1);
                }else{
                    toLeftBtn.setOpacity(LabParserItem.opacityLevel);
                }

                labItem.toLeft.setWallIsHere(!labItem.toLeft.isWallIsHere());
            }
        });
        isCubeHereBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isCubeHereBtn.getOpacity() == LabParserItem.opacityLevel){
                    isCubeHereBtn.setOpacity(1);
                }else{
                    isCubeHereBtn.setOpacity(LabParserItem.opacityLevel);
                }

                labItem.isCubeHere = !labItem.isCubeHere;
            }
        });
    }

}
