import javafx.scene.paint.Color;

public class Brick{

    int xPos;
    int yPos;
    int health;
    int sizeX = 60;
    int sizeY = 25;
    int lower;
    int left;
    int right;
    int top;
    Color shade;
    boolean notBroke= true;
     //constructor
    public Brick(int x , int y , int health){
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos + sizeY;
        right =xPos;
        left = xPos + sizeX;
    }

    //methods
    Color getShade(){
        if(health == 1){
            shade = Color.DEEPPINK;
        }else if(health == 2){
            shade = Color.CRIMSON;
        }else if(health == 3){
            shade = Color.BROWN;
        }
        return shade;
    }


    boolean hit(){//when the method returns true , brick don't have health
        health--;
        if(health<= 0 ){
            health = 0 ;
            notBroke = false;
            return true;
        }
        return false;
    }


    boolean ballDetect(Ball ball){
        if(notBroke){
            if(ball.xC < left && ball.xC >right){
                if((ball.yC +15) == lower){
                    ball.reflectY();
                    return hit();
                }else if(ball.yC == top){
                    ball.reflectY();
                    return hit();
                }
            }
            else if(ball.yC < lower && ball.yC > top){
                if(ball.xC == right){
                    //
                    ball.reflectX();
                    return hit();
                }else if(ball.xC == left){
                    ball.reflectX();
                    return hit();
                }
            }
        }
        return false;
    }



    boolean detect(Ball ball){
        if(notBroke){
            if(ball.xC < left && ball.xC > right){
                if(ball.yC == lower){
                    ball.reflectY();
                    return hit();
                }else if(ball.yC == top){
                    ball.reflectY();
                    return hit();
                }
            }else if (ball.yC < lower && ball.yC > top){//detect left or right
                if(ball.xC == right){//ball atacking from the right side
                    ball.reflectX();
                    return hit();
                }else if (ball.xC == left){//ball atacking from the left side
                    ball.reflectX();
                    return hit();
                }
            }

        }
        return false;
    }


    void kill(){
        this.health = 0 ;
        this.notBroke = false;
    }


}
