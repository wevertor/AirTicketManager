import java.util.*;

public class FirstClass extends Class{

    FirstClass(){
        sitMap = new int[5][];
        for(int i = 0; i<5; i++){
            sitMap[i] = new int[6];
        }
    }

    /* if sitIsEmpty == true, then add Passenger in hashmap */
    boolean sitIsEmpty( int[][] sits, int x, int y){
        if((x>=0 && x<=4)&&(y>=0 && y<=5)){ //if the position exists
            if(sits[x][y] == 0){ //if the sit is empty
                return true;
            }
        }
        return false;
    }

}
