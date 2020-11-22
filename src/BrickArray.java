public class BrickArray {
    //variables
    int cross = 26;
    int down = 7;
    int health =3;
    Brick brick[][] = new Brick[down][cross];
    //constructor
    public BrickArray(){
        init();
    }


    //methods
    void init(){
        for(int i = 0 ; i< down ; i++){
            for(int  j = 0 ; j< cross ; j++){
                brick[i][j] = new Brick( (j * 70 ) + 70 , ( i * 50) + 10 , health);
            }
        }
    }


    int checkAll(Ball ball){//
        int numberKilled = 0 ;
        for(int i = 0 ; i< down ; i++){
            for(int j = 0 ; j< cross ; j++){
                if(brick[i][j].detect(ball)){
                    numberKilled++;
                }
            }
        }
        return numberKilled;
    }


    void killAll(){//clears all the bricks when the user defeats.
        for(int i = 0 ; i<down; i++){
            for(int j= 0 ; j<cross ; j++){
                brick[i][j].kill();
            }
        }
    }


}
