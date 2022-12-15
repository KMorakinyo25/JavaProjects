//* File: Lab3/KMACSII.java @Kao-Morakinyo
//Kao Morkainyo
//9/14/2021
public class KMACSII {
    public static void main(String[] args) {
		System.out.println("ASCII Table for 0-127:");
		for (int i = 0; i <= 127; i++) {
			System.out.print(i + " " + (char)(i) + "    ");
			if (i % 5 == 0) System.out.println();
		}
	}//main
}//class

