//* File: Hwk2/KMcasino.java @Kao-Morakinyo
//Kao Morakinyo KM
//Partner: Alex Wisco AW
//9/10/2021
//Program asks for how many attempts the player thinks it will take them to get a triple roll and if they guess correctly they win; otherwise, they lose and can try again.
import java.util.*;

public class KMcasino {
    public static void main (String [] args) {
        System.out.println("Welcome to the TRIPLE CASINO GAME!!! \nLet see how many times it take you to roll 3 dies until you get a triple!\nHow many rolls do YOU think it take?");
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(); //player enters their guess of how many rolls it was take to get a triple
        int r1 = 1, r2 = 0, r3 = -1;
        int counter = 0;//counter is how many times the die actually rolled until a triple happened
        while(!(r1 == r2 && r1 == r3)) {
            r1 = (int)(Math.random () * 6) + 1;// roll 1 
            r2 = (int)(Math.random () * 6) + 1;// roll 2
            r3 = (int)(Math.random () * 6) + 1;// roll 3
            System.out.println(r1 + "-" + r2 + "-" + r3);
            counter++;
        }//3 die are rolled x times until there is a triple
        if(n == counter) {
            System.out.println("You finally got a TRIPLE in " + counter + " times! \nCongrats! You guessed correctly!!");
        } //if player guesses correctly they win
        else {
            System.out.println("You finally got a TRIPLE in " + counter + " times! \nYour guess was close but better luck next time :)" );
        }// if player does not guess correctly, they lose
    }//main
}//class
