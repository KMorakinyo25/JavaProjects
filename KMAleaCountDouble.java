//public File: Lab2/KMDice1.java @Kao-Morakinyo
import java.util.*;
class KMAleaCountDouble{
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Welcome to Alea Count 2 where you can roll a double!\nInput number of times to roll the two die: ");
        int n = cin.nextInt();
        int sides = 6;
        int count = 0;
        for (int i = 0; i < n; i++){
            int first = (int) (Math.random() * sides) + 1;
            int second = (int) (Math.random() * sides) + 1;
            System.out.println(first  + " " + second);
            if (first == second){
                count++;
            }
        }
        System.out.println("Number of doubles when two die are rolled " + n + " times: " + count);
    }
}