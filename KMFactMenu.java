// File: KMFactMenu.java @Kao-Morakinyo
 import java.util.*;
 public class KMFactMenu {
    
    static Scanner cin = new Scanner(System.in);
    public static void main (String [] args) {// always starts execution from main() function
       
        int n = 0;
       
        fact1(n);
    }
     
    static int fact1(int n) {//iteratio
       
        int op; 
       
        do {System.out.println("Enter n?");
            
            n = cin.nextInt(); 
            
            System.out.println("What would you like to do? \n1. n!\n2. list n! \n0. exit ");
            
            op = cin.nextInt();
            
            switch (op) {
            
                case 1: System.out.println(n + "!=" + factr(n));   
                
                break;
            
                case 2: listfact(n); System.out.println(" ");;   
                
                break;
            
                case 0: System.out.println("Bye");  
                
                break;
            
                default: System.out.println("Invalid input (0,1,2)"); 
            }//switch
            
        } while(op != 0);
        
        return op;
    } 
            

        
    static void listfact(int n) {
        
        for(int i =0; i < n; i++) {
            
            System.out.println(i + "!=" + factr(i));
            
        }
            
        System.out.print(n + "!= " + factr(n) + " ");
     
    }// fact1 
     
    static int factr(int n) {//recursion
        if (n == 0) {

            return 1;}
     
        else{
        
            return n * factr(n-1);}
        
    }//factr
 
}//class

