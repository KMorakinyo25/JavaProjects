
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Stack;


public class SkipList<E extends Comparable<E>> implements AmhSortedSet<E> {

    private Node<E> head;
    private int height;
    private int numElts = 0;
    private Random rand;
    private double p;

    private int countOps = 0;


    public boolean add(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);
        Node<E> pred0 = preds.peek();
        if(pred0.nextNodes[0] != null && pred0.nextNodes[0].data.equals(x)) return false; // elt x was already present

        // create a new node for elt x, and generate its height
        Node<E> newNode = new Node<E>(x, chooseHeight());
        int newHeight = newNode.getHeight();

        // increase the height of the head node, if needed
        if (newHeight > height) {
            if (newHeight > head.nextNodes.length-1) {
                Node<E>[] temp = (Node<E>[]) Array.newInstance(Node.class, newHeight+1);
                for(int i = 0; i < head.nextNodes.length; i++) {
                    temp[i] = head.nextNodes[i];
                }
                head.nextNodes = temp;
            }
            for(int i = newHeight; i > height; i--) {
                head.nextNodes[i] = newNode;
            }
            height = newHeight;
        }

        // add x after its predecessor on each level within x's height

        for(int i = 0; i < newHeight; i++){//within newNode's height

            if(preds.isEmpty()){//if the stack is empty add a head
                preds.push(head);
            }
            if(preds.peek() == null){//to start, if there is no pred, set the head's next pointer to newNode
                head.nextNodes[i] = newNode;
            }//otherwise,
            
            Node<E> temp = preds.peek().nextNodes[i];//store the pred's original next node in temp
            preds.peek().nextNodes[i] = newNode;//replace old next node with newNode
            newNode.nextNodes[i] = temp;//set old next node as newNode's next node
            preds.pop();//after updating the pointers, pop the pred from the stack to move on to
            //the next level/keep track of pointers

        }

        // now we have one more element stored
        numElts++;
        System.out.println(numElts);
        return true;
    }

    public E remove(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);
        Node<E> remNode = new Node<E>(x, chooseHeight());
        Node <E> temp = null;//make a variable to store node we want to remove
        int newHeight = remNode.getHeight();
        // if the element wasn't present, nothing to return
        Node<E> pred0 = preds.peek();
        if(pred0.nextNodes[0] == null) return null; // empty list
        if(pred0.nextNodes[0] != null && !pred0.nextNodes[0].data.equals(x)) return null; // non-empty list, elt x wasn't present

        // if the elment was present, now we need to remove it from each level on which it appears
              
       
        for(int i = 0; i < newHeight ; i++){

            if(preds.peek() == null){//if the header is the pred node set the head's next pointer to remNode's next node
                head.nextNodes[i] = remNode.nextNodes[i];
            }

            if(pred0.nextNodes[i].equals(x)){//if remNode has a pred
                temp = remNode;//store the node we want to remove in a temp node
                preds.peek().nextNodes[i] = remNode.nextNodes[i];//set the pred's next pointer to remNode's next pointer
                preds.pop();//keep track of pointers
            }

        }
        // now we have one fewer element stored
        numElts--;
        return temp.data; 
    }

    public E find(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);
        Node<E> level0 = preds.pop(); // the top of the stack is the predecessor on level 0
        if (level0.nextNodes[0] == null) return null;
        else return level0.nextNodes[0].data;
    }

    public int size() {
        return numElts;
    }
    protected Stack<Node<E>> findAllPreds(E x) {
        // this method should return a stack containing the predecessor nodes of element x on each level,
        // with the predecessor on level 0 at the top of the stack and the predecessor at the highest
        // level on the bottom of the stack
      
        countOps = 0;//reset countOps
        Stack<Node<E>>allPreds = new Stack<Node<E>>();//first create a stack
        allPreds.push(head);//push the head in the stack so it is not empty
        Node<E> current = new Node<E>(x, chooseHeight());//make a current node to keep track of nodes
        current = head;//start head node
        int h = height;//keep track of height
        while(h >= 0 ){//we start at the top
            while(current.nextNodes[h] != null && current.nextNodes[h].data.compareTo(x) < 0 ){//while there's a next node at each level  
                current = current.nextNodes[h];//move on
                countOps++;
            }
            
            if(current.nextNodes[h] == null){//if there is no next next node
                h--;//go down to the next level
                countOps++;
            } 
            
            else if(current.nextNodes[h].data.compareTo(x) >= 0){
                //Case 2: if the next next node's data is greater than or equal to x  
                h--;//go down to the next level 
                countOps++;
            }
            allPreds.push(current);//push into Stack 
        }
        return allPreds; 
    }

    public void print() {
        for(int i = 0; i <= height; i++) {
            Node<E> y = head;
            while(y.nextNodes[i] != null) {
                y = y.nextNodes[i];
                System.out.print(y.data + " ");
            }
            System.out.println();
        }
    }


    public int getOps() {
        return countOps;
    }

    private int chooseHeight() {
        int level = 0;
        double flip = rand.nextDouble();
        while(flip < p) {
            level++;
            flip = rand.nextDouble();
        }
        return level;
    }

    public SkipList() {
        head = new Node<E>(null, 0);
        height = 0;
        p = 0.5;
        rand = new Random();
    }

    public SkipList(int seed) {
        head = new Node<E>(null, 0);
        height = 0;
        p = 0.5;
        rand = new Random(seed);
    }

    public SkipList(double prob) {
        head = new Node<E>(null,0);
        height = 0;
        p = prob;
        rand = new Random();
    }

    public SkipList(double prob, int seed) {
        head = new Node<E>(null,0);
        height = 0;
        p = prob;
        rand = new Random(seed);
    }

}