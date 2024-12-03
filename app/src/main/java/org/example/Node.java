package org.example;

import javafx.scene.shape.Circle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node extends Circle {

    // No need to declare a separate 'radius' because it's already handled by the Circle class.
    // If you want a default radius, just set it directly in the constructor

    public Node() {
        super(10); // Default radius of 10
        setOnMouseEntered(evt -> {
            System.out.println("someone's looking");
        });
    }

    public Node(double x, double y) {
        this(x,y,10);

        setOnMouseEntered(evt -> {
            System.out.println("someone's looking");
        });
    }

    public Node(double x, double y, double radius) {
        super(radius); // Calls the Circle constructor with the specified radius
        setCenterX(x); // Set the X position of the circle
        setCenterY(y); // Set the Y position of the circle
        setOnMouseEntered(evt -> {
            System.out.println("someone's looking");
        });
    }
}
