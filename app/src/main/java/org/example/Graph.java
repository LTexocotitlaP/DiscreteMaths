package org.example;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Graph extends Pane {

    List<Node> nodes = new ArrayList<>();
    List<Vertices> vertices = new ArrayList<>();

    public Graph() {
        setOnMouseClicked(evt -> {
            Node newNode = new Node(evt.getX(), evt.getY());
            nodes.add(newNode);
            getChildren().add(newNode);
        });
    }

}
