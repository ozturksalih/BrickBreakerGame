import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class LevelMenu {
    boolean isPlaySelected = true;
    boolean isActive ;

    boolean shouldExit = false;
    boolean toggle = true;

    //constructor

    //methods
    public void render(GraphicsContext gc, double time ){//renders the scene
        //black background
        if(isActive){
            gc.setFill(Color.BLACK);
            gc.fillRect(0 , 0 , 1920 ,1080);
            //render title
            gc.setFill(Color.CRIMSON);
            gc.setFont(new Font(50));
            gc.setTextAlign(TextAlignment.CENTER);
            gc.fillText("Brick Breaker" , 950 , 340);

            //renders play and exit signs
            gc.setFont(new Font(50));
            //colors the active choice yellow
            if(isPlaySelected){
                gc.setFill(Color.YELLOW);
            }else{
                gc.setFill(Color.RED);
            }
            gc.fillText("Play" , 700 , 600);

            if(isPlaySelected){
                gc.setFill(Color.RED);
            }else{
                gc.setFill(Color.YELLOW);
            }
            gc.fillText("Exit" , 1240 , 600);

            if(isPlaySelected){
                gc.setFill(Color.YELLOW);
                gc.fillRect(650 , 620 , 100, 10);
            }else{
                gc.setFill(Color.YELLOW);
                gc.fillRect(1190 , 620 , 100 ,10);
            }
        }

    }


    public void tick(Input input ){//this is for controlloing the cursor that select which level to display
        if(this.isActive){
            if(input.left&& toggle){//select should play
                isPlaySelected = true;
                toggle = false;
            }else if (input.right && toggle){
                isPlaySelected = false;
                toggle = false;
            }else if(input.space){
                System.out.println("exit");
                shouldExit = true;
            }
            else if (!input.right && !input.left){
                toggle = true;
            }
        }
    }


    public boolean exit(){
        return shouldExit;
    }


    public int destination(){
        if(isPlaySelected){//case:the player wishes to play and the menu is exited to the game
            return 2;
        }else{//case:the player wishes to quit and the application is given the command to close
            return 0;
        }
    }


    public void activate(){
        this.isActive = true;
        if(shouldExit = true){
            this.shouldExit = false;
        }
    }


    public void deactivate(){
        this.isActive = false;
    }


}
