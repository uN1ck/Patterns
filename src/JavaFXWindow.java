import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.Game;
import util.ViewBridge;
import util.world.Cell;
import util.world.SampleGameBuilder;

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
        game.buildGame(new SampleGameBuilder());
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

        Image sprite = new Image("file:img/ground1.png");
        int scale = 5;
        graphicsContext.drawImage(sprite, position.x * sprite.getWidth() * scale, position.y * sprite.getHeight() * scale, sprite.getWidth() * scale, sprite.getHeight() * scale);
        if (!value.isEmpty())
            graphicsContext.drawImage(sprite, position.x * sprite.getWidth() * scale, position.y * sprite.getHeight() * scale, sprite.getWidth() * scale, sprite.getHeight() * scale);

    }
}
