package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.scene.input.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class App extends Application {

    private static boolean ctrlDown = false;
    private static List<Circle> nodes = new ArrayList<>();
    private static int circleIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Graph 3D visualizer");
        primaryStage.setScene(new Scene(createContent(), 1200, 800));
        primaryStage.show();
        var focusProperty = primaryStage.focusedProperty();
        focusProperty.addListener(evt -> {
            System.out.println(focusProperty.getValue());
        });
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, evt -> {
            if (evt.isControlDown()) {
                ctrlDown = true;
                var root = (Pane) primaryStage.getScene().getRoot();
                // root.getChildren().remove(nodes.get(0));
            }
        });
        primaryStage.addEventFilter(KeyEvent.KEY_RELEASED, evt -> {
            if(!evt.isControlDown()){
                ctrlDown = false;
            }
        });
    }

    public Parent createContent() {
        var root = new Pane();

        root.setOnMouseClicked(evt -> {
            var newCircle = createCircle(evt.getX(), evt.getY());
            if(!ctrlDown) {
                nodes.add(newCircle);
                newCircle.setOnMouseClicked( etv -> {
                    if(ctrlDown==true){
                        if (circleIndex<=1) {
                        System.out.println(circleIndex);
                            circleIndex++;
                            //circleIndex = nodes.indexOf(newCircle);
                            //if(nodes.indexOf(newCircle)) {
                                //circle
                            //}
                            newCircle.setFill(Color.RED);
                            //createConnection();
                        }
                    } else {
                        if (circleIndex>0) {
                        circleIndex--;
                        System.out.println(circleIndex);
                        newCircle.setFill(Color.BLACK);
                        }
                    }
                });
                root.getChildren().add(newCircle);

            }
        });

        return root;
    }

    private Circle createCircle(double centerX, double centerY) {
        var circle = new Circle(centerX, centerY, 50);
        return circle;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
