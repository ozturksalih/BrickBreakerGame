import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LevelOne {
    //variables
    boolean ballOnPaddle= true;
    boolean shouldExit= false;
    boolean isActive ;
    int score = 0 ;
    int livesLeft = 3;
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    BrickArray brickArray = new BrickArray();
    Brick tempBrick;

    int killed = 0 ;

    //methods
    public void render(GraphicsContext gc , double time){
        if(isActive){
            //black background
            gc.setFill(Color.BLACK);
            gc.fillRect( 0 , 0 , 1920 , 1080);

            //render the position of the players paddle
            gc.setFill(Color.ROYALBLUE);
            gc.fillRect(paddle.xPos , paddle.yPos , paddle.xSize , paddle.ySize);
            //render the ball
            gc.fillOval(ball.xC, ball.yC -11 , ball.xSize , ball.ySize);

            //render the brick array
            for(int i = 0 ; i<brickArray.down ; i++){
                for(int j = 0 ; j < brickArray.cross; j++){
                    tempBrick = brickArray.brick[i][j];
                    gc.setFill(tempBrick.getShade());
                    if(tempBrick.notBroke){
                        gc.fillRect(tempBrick.xPos , tempBrick.yPos , tempBrick.sizeX , tempBrick.sizeY);
                    }
                }
            }
        }
    }



    public void tick(Input input , int tickCount){
        if(isActive){
            //when game is in session
            //update the paddle object
            if(input.left){//the player wishes to move to the left
                paddle.decreaseXVec();
            }else if(input.right){//player wishes to move to right
                paddle.increaseXVec();
            }

            //check if the ball is on the paddle
            //and if the player persses up the ball is released
            if(input.up){//load ball and fire it

                ballOnPaddle = false;


            }
            if(tickCount % 2 == 0){//apply friction to paddle
                if(!input.left && !input.right){
                    paddle.normalizeX();
                }
            }
            //update all objects
            //update the paddle's position
            paddle.xDelta();
            //update ball
            //decide if the ball should be on the paddle

            if(ball.Delta(paddle, ballOnPaddle)){
                mistake();
            }
            killed+= brickArray.checkAll(ball);
        }
    }


    public boolean exit(){
        return shouldExit;
    }


    public void mistake(){
        this.livesLeft--;
        if(this.livesLeft == 0){
            shouldExit = true;
        }
        this.ballOnPaddle = true;
    }


    public int destination (){
        return 1 ;
    }


    public void activate(){
        this.isActive = true;
        if(this.shouldExit == true){
            this.livesLeft = 3 ;
            shouldExit= false;
            ballOnPaddle = true;
            this.brickArray = new BrickArray();
            this.score = 0 ;
        }
    }


    public void deactivate(){
        this.isActive = false;
    }
}
