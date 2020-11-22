import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

public class LevelOperator {
    int levelNumber = 1;
     LevelMenu menu = new LevelMenu();
     LevelOne firstLevel = new LevelOne();


     //methods
    public void levelRender(GraphicsContext gc , double t){
        switch(levelNumber){
            case 0:{//exit
                break;
            } case 1:{//menu
                menu.render(gc,t);
                break;
            } case 2:{//levelOne
                firstLevel.render(gc,t);
                break;
            }
        }
    }
    public void levelTick(Input input , int tickCount){
        //tells the game to perfome a logic tick and ask if the level should be exited
        switch(levelNumber){
            case 0:{//exit application
                Platform.exit();
                break;
            } case 1:{//opening menu
                menu.activate();
                menu.tick(input);
                if(menu.exit()){
                    menu.deactivate();
                    levelNumber = menu.destination();
                }
                break;
            } case 2 :{
                //first level
                firstLevel.activate();
                firstLevel.tick(input, tickCount);
                if(firstLevel.exit()){
                    firstLevel.deactivate();
                    levelNumber = firstLevel.destination();
                }
                break;
            }
        }
    }
}
