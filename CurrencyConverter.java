import java.util.*;

public class CurrencyConverter{

    public static void main(String []args){

        System.out.println("1. US Dollar");
        System.out.println("2. Euro");
        System.out.println("3. GBR Pound");
        System.out.println("4. CH Yuan");

        Scanner cin = new Scanner(System.in);


        char op;

        System.out.println("Choose a currency: ");

        do {
        
            op = cin.next().charAt(0);

            switch(op) {
                case '1': 
                
                System.out.println("Choose amount: ");
                double num = cin.nextDouble(); 
                dollar(num); 
                System.out.println("Press 5 for the list of currencies or 0 to exit");
                
                break;
                
                case '2': 
                
                System.out.println("Choose amount: ");
                num = cin.nextDouble();
                euro(num); 
                System.out.println("Press 5 for the list of currencies or 0 to exit");

                break;
                
                case '3': 

                System.out.println("Choose amount: ");
                num = cin.nextDouble();
                pound(num);
                System.out.println("Press 5 for the list of currencies or 0 to exit");

                break;

                case'4':

                System.out.println("Choose amount: ");
                num = cin.nextDouble();
                yuan(num);
                System.out.println("Press 5 for the list of currencies or 0 to exit");

                break;
               
                case '5':  
                System.out.println("1. US Dollar");
                System.out.println("2. Euro");
                System.out.println("3. GBR Pound");
                System.out.println("4. CH Yuan");
                System.out.println("Choose a currency: ");
                
                break; 

                case '0': System.out.print("Bye Bye now!\n"); System.exit(0); 
                
                default: System.out.print("input error");
            } 
        }while (op != 0);


    }

    public static void dollar(double n) {

        System.out.println(n + " US dollar(s) is equal to:" + "\n" + (0.9412*n) + " Euros." + "\n" + (0.8209*n) + " GBR Pounds." + "\n" + (6.9737*n) + " CH Yuan.");

    }

    public static void euro(double n) {

        System.out.println(n + " Euro(s) is equal to:" + "\n" + (1.0626*n) + " US Dollars." + "\n" + (0.8720*n) + " GBR Pounds." + "\n" + (7.4095*n) + " CH Yuan.");
    }

    public static void pound(double n) {

        System.out.println(n + " BR Pound(s) is equal to:" + "\n" + (1.2185*n) + " US Dollars." + "\n" + (1.1467*n) + " Euros." + "\n" + (8.4978*n) + " CH Yuan.");
    }

    public static void yuan(double n) {
        System.out.println(n + " CH Yuan is equal to:" + "\n" + (0.1434*n) + " US Dollars." + "\n" + (0.1350*n) + " Euros." + "\n" + (0.1177*n) + " GBR Pounds.");
    }

    

    

   

}