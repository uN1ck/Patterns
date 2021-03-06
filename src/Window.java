import actionObject.ActionObject;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Window extends Application implements GraphicsBridge {
    private Canvas canvas;
    GraphicsContext graphicsContext;
    private GraphicsComponent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Strategy Game Viewer");
        Group rootGroup = new Group();
        Canvas canvas = new Canvas(800, 600);
        graphicsContext = canvas.getGraphicsContext2D();

        rootGroup.getChildren().add(canvas);
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.show();
    }

    @Override
    public void drawActionObject(ActionObject value, int x, int y) {

    }
}
