import java.util.*;

public class EconomyClass extends Class{

    EconomyClass(){
        sitMap = new int[15][];
        for(int i=0; i<15; i++){
            sitMap[i] = new int[6];
        }
    }

    /* if sitIsEmpty == true, then add Passenger in hashmap */
    boolean sitIsEmpty( /*int[][] sits,*/ int x, int y){
        if((x>=5 && x<=19)&&(y>=0 && y<=5)){ //if the position exists
            if(sitMap[x][y] == 0){ //if the sit is empty
                return true;
            }
        }
        return false;
    }

    void print(){
        System.out.println("   A B C D E F");
        for(int i = 0; i<15;i++){
            if(i+1<10){
                System.out.printf("0%d ", i+1);
            }
            else{
                System.out.printf("%d ", i+1);
            }
            for(int j = 0; j<6 ;j++){
                System.out.printf("%d ", sitMap[i][j]); 
            }
            System.out.printf("\n");
        }
    }
}
