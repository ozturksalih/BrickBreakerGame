import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Gameplay game = new Gameplay();
        game.run(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
