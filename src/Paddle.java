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
        yPos = 950 ;
        xSize = 250 ;
        ySize = 20 ;
        xLimRight = 1650 ;
        xLimLeft = 0 ;
    }


    //methods
//    ==================
//    DELTA BLOCK
//    ==================

    void xDelta(){//moves paddle in x Axis
        xPos += xVec;
        if(xPos < xLimLeft ){//limit for left side
            xPos =  xLimLeft ;
        }
        if((xPos > xLimRight)){//limit for right side
            xPos = xLimRight;
        }
    }
    //paddle doesn't need to move in y Axis so we don't write method for moving in y Axis


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



    void decreaseXVec(){
        if(xVec>minSpeed){
            xVec-=2;
        }
    }





    void normalizeX(){
        if(xVec<0){
            xVec++;
        }else if(xVec > 0 ){
            xVec --;
        }

    }




}
