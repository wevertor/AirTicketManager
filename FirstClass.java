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

    void print(){
        System.out.println("|First Class|");
        System.out.println("  A B C D E F"); 
        for(int i = 0; i<5; i++){
            System.out.printf("%d ", i+1);
            for(int j = 0 ; j<6 ; j++){
                System.out.printf("%d ", sitMap[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
