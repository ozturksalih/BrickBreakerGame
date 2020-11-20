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
        this.yC = 300;
        this.xSize = 15;
        this.ySize = 15;
        this.xVec = -optSpeed;
        this.yVec = optSpeed;
    }


    void init() {//initializes the balls variables
        this.left = xC;
        this.right = xC + xSize;
        this.up = yC;
        this.down = yC + ySize;

    }


    void xDelta() {//changes position in the x Axis
        xC += xVec;
        if (xC < 0) {
            xC = 0;
            reflectX();
        } else if (xC > 1346) {
            xC = 1346;
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
        } else if (yC > 760) {
            yC = 760;
            reflectY();
            return true;
        }
        return false;
    }


    boolean Delta (Paddle player, boolean onPaddle) {
        if (onPaddle) {
            this.xC = player.xPos + (player.xSize / 2) - (this.xSize / 2);
            this.yC = player.yPos - 20;
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
