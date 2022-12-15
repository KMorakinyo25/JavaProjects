//*File: Lab2/KMAleaCount.java @Kao-Morakinyo
import java.util.*;
public class KMAleaCount {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        System.out.println("Welcome to Alea Count! Will you roll a 1 or 6? Let's see!");
        System.out.println("How many times to roll?");
        System.out.println("There were " + Roll(cin.nextInt()) + " 1s or 6s");
    }

    public static int Roll(int numTimes){
        int count = 0;
        for(int i = 0; i < numTimes; i++){
            Random rand = new Random();
            int roll = rand.nextInt(6) + 1;
            System.out.println("Rolled a: "  + roll);
            if(roll == 1 || roll ==6) count++;

    }
        return count;
    }    
}
