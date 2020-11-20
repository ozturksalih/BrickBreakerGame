public class Paddle {
    int xPos;
    int yPos;
    int xSize;
    int ySize;

    //limits
    int xLimRight;
    int xLimLeft;

    //vectors
    int xVec = 0 ;
    int yVec = 0 ;
    int maxSpeed = 20 ;
    int minSpeed = -20 ;

    //constructor
    public Paddle(){
        xPos = 0 ;
        yPos = 600 ;
        xSize = 250 ;
        ySize = 10 ;
        xLimRight = 1116 ;
        xLimLeft = 0 ;
    }


    //methods
//    ==================
//    DELTA BLOCK
//    ==================

    void xDelta(){//moves paddle in x Axis
        xPos += xVec;
        if(xPos < 0 ){
            xPos =  0 ;
        }
        if((xPos > 1116)){
            xPos = 1116;
        }
    }


   /* void yDelta(){//moves paddle in y Axis

    }*/


//    ===============
//    VALIDATOR BLOCK
//    ===============
    boolean xIsPositive(){//returns
        return (xVec>=0);
    }


    boolean yIsPositive(){
        return (yVec>=0);
    }


//    ==================
//    Accelaration Block
//    ==================
    void increaseXVec(){
        if(xVec<maxSpeed){
            xVec++;
        }
    }


    void increaseYVec(){
        if(yVec<maxSpeed){
            yVec +=2;
        }
    }


    void decreaseXVec(){
        if(xVec>minSpeed){
            xVec-=2;
        }
    }


    void decreaseYVec(){
        if(yVec > minSpeed){
            yVec--;
        }
    }


    void normalizeX(){
        if(xVec<0){
            xVec++;
        }else if(xVec > 0 ){
            xVec --;
        }

    }


    void normalizeY(){
        if(yVec<-2){
            yVec-=10;
        }else if(yVec > 2){
//
        }
    }

}
