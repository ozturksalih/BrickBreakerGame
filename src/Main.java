import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Brick Breaker");

        //the old one
        primaryStage.setScene(new Scene(root, 1000, 600));
        FileInputStream input = new FileInputStream("C://Users//salih//IdeaProjects//BrickBreakerGame//src//paddle_brick.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


        HBox hbox = new HBox(imageView);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();




        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
