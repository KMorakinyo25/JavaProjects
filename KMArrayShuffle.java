//*File: Lab7/KMArrayShuffle.java @Kao-Morakinyo
import java.util.*;
public class KMArrayShuffle {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        fillList(students);  System.out.println("Your students: "); print2(students);
        Collections.sort(students); System.out.println("\nYour students sorted alphabetically: "); print2(students);
        Collections.shuffle(students); System.out.println("\nYour students shuffled: "); print2(students);
    } 
    static List<String> fillList(List<String> L){
        Scanner cin = new Scanner(System.in);
        System.out.println("How many students are in your class?: ");
        int size = cin.nextInt();
        System.out.println("Enter your students' names: ");
        for (int i = 0; i < size; i++){
            String name = cin.next();
            L.add(name.toUpperCase()); 
        }
        return L;
    }
    static <T> void print2(List<T> A){ 
        for (T w: A)
            System.out.print(w + " - ");
    }
}
