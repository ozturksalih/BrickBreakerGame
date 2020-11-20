//this class defines input variables and does what is needed when keys are pressed




import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Input {
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;

    Scene scene ;

    public Input(Scene scene) {
        this.scene = scene;
        init();
    }
    public void init(){//initilazition
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {//when keys are pressed
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case UP : up = true; break;
                    case DOWN : down = true; break;
                    case LEFT: left = true; break;
                    case RIGHT: right = true; break;
                    case SPACE: space = true; break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {//when keys are not pressed
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case UP : up = false; break;
                    case DOWN : down = false; break;
                    case LEFT: left = false; break;
                    case RIGHT: right = false; break;
                    case SPACE: space = false; break;
                }
            }
        });
    }
}
