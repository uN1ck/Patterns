package javaFXEngine;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Window extends Application {
    private Canvas canvas;
    GraphicsContext graphicsContext;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Strategy Game Viewer");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        graphicsContext = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
