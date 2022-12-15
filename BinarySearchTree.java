import java.util.Stack;

public class BinarySearchTree<K extends Comparable<K>,V> {

    private TreeNode<K,V> root;//initialize root

    public BinarySearchTree(){//constructor for BST/THE BST relies on the root
      //root is constructed in the add method
    }


    public V add(K key, V value){

        TreeNode<K,V> newNode = new TreeNode<K,V>(key,value);//make a node for the key and value we want to add


        if(root == null){//Case 1: if there is no root, add the key and value
            root = newNode;
            return null;
        }

        TreeNode<K, V> current = root;//make a node to keep track of position, start at the head

        while(current != null){//start from the top

            if(current.key.compareTo(key) > 0){//if current.key is greater than the key we're looking for, go down right
                
                if(current.right == null){//if we are at the leaf, add the add there and return null
                    current.right = newNode;
                    newNode.parent = current;
                    
                    return null;
                }

                current = current.right;
            }

            if(current.key.compareTo(key) < 0){//if current.key is less than key we're looking for, go down left
                

                if(current.left == null){
                    current.left = newNode;
                    newNode.parent = current;
                    
                    return null;
                }

                current = current.left;
            }

            if(current.key.compareTo(key) == 0){//if current.key is at the key we're looking for, replace value and return
                V old = current.value;//store the old value in a temp V
                current.value = newNode.value;//store new value into current

                return old;//return old value
            }
        }
        return null;//
    }//add

    public V remove(K key){
       

        if(root == null){//Case 1: if there is no root/tree is empty, return null
            return null;
        }

        TreeNode<K, V> current = root;//make a node to keep track of position, start at the head
        
        while(current != null){//start from the top

            if(current.key.compareTo(key) > 0){//if current.key is greater than the key we're looking for, go down right
                
                if(current.right == null){//if we are at the leaf, return null
                    
                    return null;
                }
                current = current.right;
            }

            if(current.key.compareTo(key) < 0){//if current.key is less than key we're looking for, go down left

                if(current.left == null){
                    return null;
                }
                current = current.left;

            }

            if(current.key.compareTo(key) == 0){//if current.key is at the key we are looking for, remove it
                V value = current.value;//store the value in a V

                if(current == root){//if we are trying to remove the root
                    if(current.left !=null){//if there is a left node, choose the predecessor
                        current = current.left;//start at the root's left child
                        while(current.right != null){//go down as far to the right as possible
                            current = current.right;

                            if(current.right == null){//when you reach the end
                                current.parent.right = null;//cut off connect between pred and parent
                                current.parent = null;
                                root = current;//make the predecessor the new root
                            }
                        }
                    }

                    if(current.right !=null){//if there is a left node, choose the successor
                        current = current.right;//start at the root's right child
                        while(current.left != null){//go down as far to the left as possible
                            current = current.left;

                            if(current.left == null){//when you reach the end
                                current.parent.left = null;//cut off connect between succ and parent
                                current.parent = null;
                                root = current;//make the successor the new root
                            }
                        }
                    }

                    
                }
                
                if(current.left == null && current.right == null){//Case 1: if there's no children
                    current.parent = null;//make the parent point to nothing
                }

                if(current.left != null){//Case 2a: if current has a left child
                    current.parent.left = current.left;//make the parent point to the left child
                    current.left.parent = current.parent;//the left child points back to parent
                }

                if(current.right != null){//if current has a right child
                    current.parent.right = current.right;//make the parent point to the left child
                    current.right.parent = current.parent;//the right child points back to the parent

                }

                return value;//return associated value
            }
        }
        return null;
    }//remove

    public V lookup(K key){
       
        TreeNode<K, V> current = root;//make a node to keep track of position, start at the head
        

        while(current != null){//start from the top

            if(current.key.compareTo(key) > 0){//if current.key is greater than the key we're looking for, go down right
                
                
                if(current.right == null){//if we are at the leaf, return null
                    return null;
                }
                current = current.right;
            }

            if(current.key.compareTo(key) < 0){//if current.key is less than key we're looking for, go down left
                

                if(current.left == null){
                    return null;
                }
                current = current.left;
            }

            if(current.key.compareTo(key) == 0){//if current.key is greater than key we're looking for, replace value and return
                V value = current.value;//store the value in a temp V

                return value;//return associated value
            }
        }

        return null;
    }//lookup

    public void traverse(TreeNode<K,V> current){

        if(current.right != null){
            traverse(current.right);
        } 
        System.out.println("(" + current.key + "," + current.value + ")");
        if(current.left != null){
            traverse(current.left);
        }

    }//traverse(help method)

    public void inOrderTraverse(){
        traverse(root);
    }//inOrderTraverse

 

}//class
