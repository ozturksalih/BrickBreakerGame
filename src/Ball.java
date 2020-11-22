public class Ball {
     int xC;//coordinates
     int yC;
     int xSize;
     int ySize;
     boolean free = false;


     int left;
     int right;
     int up;
     int down;

    //vector
     int xVec;
     int yVec;

     int maxSpeed = 20;
     int optSpeed = 5;

    public Ball() {
        this.xC = 500;
        this.yC = 850;
        this.xSize = 35;
        this.ySize = 30;
        this.xVec = -optSpeed;//value - because we want the ball to go upside
        this.yVec = optSpeed;
    }


    void init() {//initializes the balls variables
        this.left = xC;
        this.right = xC + xSize;//for detect collision
        this.up = yC;
        this.down = yC + ySize;//for detect collison

    }


    void xDelta() {//changes position in the x Axis
        xC += xVec;
        if (xC < 0) {//boundary = 0
            xC = 0;
            reflectX();
        } else if (xC > 1900) {//boundary = 1900
            xC = 1900;
            reflectX();
        }
    }


    boolean yDelta(Paddle player) {//changes postion in the y Axis
        yC += yVec;
        if (yC < 0) {
            yC = 0;
            reflectY();
            return false;
        } else if ((xC > player.xPos) && (xC < player.xPos + player.xSize) && (yC == player.yPos - ySize)) {
            reflectY();
            return false;
        } else if (yC > 1050) {
            yC = 1050;
            reflectY();
            return true;
        }
        return false;
    }


    boolean Delta (Paddle player, boolean onPaddle) {//sabitleme
        if (onPaddle) {
            this.xC = player.xPos + (player.xSize / 2) - (this.xSize / 2);
            this.yC = player.yPos - 35;
            return false;
        } else {
            xDelta();
            return yDelta(player);
        }
    }


    void normalizeX(){
        if(xVec < optSpeed){
            xVec = optSpeed;
        }else if (xVec > optSpeed){
            xVec--;
        }
    }


    void normalizeY(){
        if(yVec < optSpeed){
            yVec = optSpeed;
        }
        else if( yVec > optSpeed){
            yVec--;
        }
    }


    void normalize(){
        normalizeX();
        normalizeY();
    }


    void limitVec(){
        if(xVec > maxSpeed){
            xVec = maxSpeed;
        }
        if(yVec > maxSpeed){
           yVec = maxSpeed;
        }
    }


    void check(){
        limitVec();
        normalize();
    }


    void reflectX() {
        xVec = xVec * -1;
    }


    void reflectY() {
        yVec = yVec * -1;
    }


    void toggleFree(){
        this.free = !free;
    }

}
