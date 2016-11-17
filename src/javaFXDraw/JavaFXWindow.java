package javaFXDraw;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.game.Game;
import util.game.SampleGameBuilder;
import util.view.ViewBridge;
import util.world.Cell;

import java.awt.*;


public class JavaFXWindow extends Application implements ViewBridge {
    GraphicsContext graphicsContext;
    Game game;
    private Canvas canvas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        game = Game.instance();
        game.buildGame(new SampleGameBuilder(2, 5, 5, game));
        game.setView(this);

        primaryStage.setTitle("Strategy Game Viewer");
        Group rootGroup = new Group();
        Canvas canvas = new Canvas(800, 600);
        graphicsContext = canvas.getGraphicsContext2D();

        rootGroup.getChildren().add(canvas);
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.show();

        game.gameLoop(10);
    }


    @Override
    public void drawCell(Cell value, Point position) {

        Image spriteGround = new Image("file:img/ground1.png");
        Image spriteActionUnit = new Image("file:img/building.png");
        int scale = 5;
        graphicsContext.drawImage(spriteGround, position.x * spriteGround.getWidth() * scale, position.y * spriteGround.getHeight() * scale, spriteGround.getWidth() * scale, spriteGround.getHeight() * scale);
        if (!value.isEmpty())
            graphicsContext.drawImage(spriteActionUnit, position.x * spriteActionUnit.getWidth() * scale, position.y * spriteActionUnit.getHeight() * scale, spriteActionUnit.getWidth() * scale, spriteActionUnit.getHeight() * scale);

    }
}
