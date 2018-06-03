import java.util.*;

public class Class {
    protected int [][] sitMap;

    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    int getY(String ref){
        char[] buffer;

        buffer = ref.toCharArray(); //convert the string into a char array
        return positionInArray(buffer[ref.length()-1]); //get the letter from the array
    }

     int getX(String ref){
        char[] buffer;
        String value;

        buffer = ref.toCharArray();
        buffer[ref.length()-1] = '0'; //change the letter to 0
        value = String.valueOf(buffer); //convert back to String
        return Integer.parseInt(value)/10; //convert the String to int removing the 0
    }

    /* method for convert the position in row to position in array */
    static int positionInArray(char a){
        if(a == 'A'){
            return 0;
        }
        else if(a == 'B'){
            return 1;
        }
        else if(a == 'C'){
            return 2;
        }
        else if(a == 'D'){
            return 3;
        }
        else if(a == 'E') {
            return 4;
        }
        else if(a == 'F') {
            return 5;
        }
        else {
            return -1;
        }
    }

    void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    Passenger getPassenger(String sit){
        Iterator<Passenger> it = this.passengers.iterator();
        while(it.hasNext()){
            if (it.next().getSit().equals(sit)) {
                return it.next();
            }
        }
        return null;
    }
}
