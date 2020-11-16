import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Brick Breaker");

        //the old one
        primaryStage.setScene(new Scene(root, 1000, 600));
//
        //create a canvas
        Canvas canvas = new Canvas(1000.0f , 600.0f);

        //graphicsContext
        GraphicsContext graphicsContext =
                canvas.getGraphicsContext2D();

        //set fill for rectangle
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(450 , 550 , 100 , 30);

        //Create a group
        Group group = new Group(canvas);

        //create a scene
        Scene scene = new Scene(group , 1000 ,600);

        //set the scene
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
