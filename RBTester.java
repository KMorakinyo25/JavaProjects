import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class RBTester {

    public static void main (String[] args) {

	if (args.length != 1) { showUsageAndExit(); }

	RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
	Scanner                sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: Could not open file %s\n", args[0]);
            System.exit(1);
        }

	// Read instructions until there are no more.
	int line = 0;
	while (sc.hasNext()) {

	    line = line + 1;
	    int    value = 0;
	    try {
		value = sc.nextInt();
	    } catch (InputMismatchException e) {
		System.err.printf("ERROR: Could not read value on line %d\n", line);
		System.exit(1);
	    }
            String  color = sc.next();
            boolean red   = false;;
            if (color.equalsIgnoreCase("red")) {
                red = true;
            } else if (!color.equalsIgnoreCase("black")) {
                System.err.printf("ERROR: Unknown color %s on line %d\n", color, line);
                System.exit(1);
            }
            
            rbt.insert(value, red);
            
	}

        System.out.printf("Is it valid? %b\n", isRBTree(rbt));

    }

    
    private static void showUsageAndExit () {
	
	System.err.printf("USAGE: java RBTester <input pathname>\n");
	System.exit(1);

    }

    private static boolean isRootBlack(RBNode n){

        RBNode root = n;//initialize node

        if(root.parent != null){
            return isRootBlack(root.parent);//if the node had a parent, call method on the parent

        }
        else{
           if(root.red == true){//if there is no parent then we are at the root
            return false;//if the color is red return false
           }
           else{
            return true;//if the color is black return true
           }
        }

    }

    private static boolean blackNullNodes(RBNode current){

        if(current.isNullLeaf() == true){//if current is a null leaf
            if(current.red == true){//if it's red return false
                return false;
            }
            return true; //if it's black return true
        }


        if(blackNullNodes(current.left) == false){//recursively goes down to check the tree, if a null node 
            //is red it is not a proper RBTree
            return false;
        }
        
        if(blackNullNodes(current.right) == false){
            return false;
        }
        else 
        return true;


        
    }

    private static boolean isChildBlack(RBNode current){

        if(current.red == true){//if the node is red
            if(current.left.red == true || current.right.red == true){//if the either one fo the children 
            //are red
            return false;
            }
            return true;
        }

        if(current.left.isNullLeaf() == false){//if the child is not a null leaf, run the method on the child
            if(isChildBlack(current.left) == false){
                return false;
            }
        }

        if(current.right.isNullLeaf() == false){
            if(isChildBlack(current.right) == false){
                return false;
            }
        }
    
        return true;
    }

    private static int Paths(RBNode current, int counter){


        if(current.isNullLeaf() == true){//if it's a null leaf, increment
            counter++;
            return counter;
        }

        if(current.red == false){//if it's a black node, increment
            counter++;

        }
        
        return Paths(current.left,counter) + Paths(current.right,counter);//return the counter of both the left and right paths
       
    }

    private static boolean equalBN(RBNode current){

        if(Paths(current.left,0) == Paths(current.right, 0)){//if the paths of the children are
            //equal then return true
            return true;
        }

        return false;
        

    }
    private static boolean isRBTree (RedBlackTree<Integer> rbt) {

	RBNode<Integer> root = rbt.root;

    if(isRootBlack(root)== true && blackNullNodes(root) == true && isChildBlack(root) == true && equalBN(root) == true){

        return true;
    }

    return false;
	
    }

} // class RBTest
