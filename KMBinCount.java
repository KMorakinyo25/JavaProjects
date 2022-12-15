//* File: KMBinCount.java @Kao-Morakinyo
import java.util.*;
public class KMBinCount {
    public static void main (String []args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter int? ");
        int n = cin.nextInt();
        String x = Integer.toBinaryString(n);
        int counter = 0;
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i) == '1') {
                counter++;
            }
        } System.out.println(n + " = " + Integer.toBinaryString(n) + "\n" + n + " has " + counter + " 1's");
    }//main
    
}//class
