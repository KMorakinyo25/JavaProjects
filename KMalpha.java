//* Fille: Lab3/KMalpha.java @Kao-Morakinyo
import java.util.*;
class KMalpha{
    public static void main (String [] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Hello!");
        char op;
        do {
            System.out.print("What would you like to do with the alphabets? \n1.Upper and Lowercase\n2.Upper and Lowercase reverse\n0.Exit\n");
            op = cin.next().charAt(0);
            switch(op) {
                case '1': alpha1(); System.out.println(" "); break;
                case '2': alpharev(); System.out.println(" "); break;
                case '0': System.out.print("Bye"); System.exit(0);
                default: System.out.print("input error");
            } 
        }while (op != 0);

    }//main
    static void alpha1() {//Aa Bb Cc
        for( char ch = 'a', s ='A'; ch <= 'z'; ch++, s++) {
            System.out.print(s + "" + ch + " ");
        }
    }//alpha1
    static void alpharev() {//Zz Yy Xx
        for( char ch = 'Z', s = 'z'; ch >= 'A'; ch--, s--) {
            System.out.print(ch + "" + s + " ");
        
        }
    }//alpharev
    
}//class