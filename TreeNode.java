public class TreeNode<K,V>{

    //initialize key, value, parent, and children

    K key;
    
    V value;

    TreeNode<K,V> left;

    TreeNode<K,V> right;

    TreeNode<K,V> parent;

    public TreeNode(K key, V value){//constructor
        this.key = key;
        this.value = value;       
        parent = null;
        left = null;
        right = null; 
    }

    public TreeNode(){//constructor with no parameters
        //this helps initialize the BST/ placeholder for the root
        this.key = key;
        this.value = value;       
        parent = null;
        left = null;
        right = null; 
    }

}//class