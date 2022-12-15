//* File: Week7/Array.java @Kao- Morakinyo
import java.util.*;
public class Array {
    public static void main(String []args) {
        List <Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,2, 6, 7, 8, 4, 2, 8, 0));
        List <Integer> A2 = new ArrayList<>();
        
        int mid = A.size()/2;
        
        A2.addAll(A.subList(mid, A.size()));
        A2.addAll(A.subList(0, mid));
       
        System.out.println(A2);
        
        A.remove(Integer.valueOf(2));

        System.out.println(A);

    }
}