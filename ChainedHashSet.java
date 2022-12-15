import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {

        LinkedList[] storage = new LinkedList[capacity];//intialize array of LL
        for(int i = 0; i < storage.length; i++){
            storage[i] = new LinkedList<E>();//put a LL in every position i
        }
         
        m = capacity;//m is the # of LL in the array

        n = 0;//n is the # of elements in total

        collisions = 0;//collisions is the # of times 2+ n's are at the same position

       
        this.storage = storage;//set created storage array to the provate storage
        
    } // ChainedHashSet ()

    public boolean insert (E key) {

        int loc =  key.hashCode()% m;//gives location in the capacity

        if(storage[loc].contains(key)){//if the key is at LL loc

            return false;//it was not added so return false

        }

        else {
            if(storage[loc] != null){

                collisions++;//keep track of collisions
            }
            n++;//increase the # of total elements
            storage[loc].add(key);//add the key
            return true;//it was added
            
        }
        

    } // insert ()

    public boolean lookup (E key) {

        int loc =  key.hashCode()% m;//gives location in the capacity

        if(storage[loc].contains(key)){//if the key is at LL loc

            return true;//key is there

        }

        else {
           return false;//key not there
            
        }
    } // lookup ()

    public boolean remove (E key) {

        int loc =  key.hashCode()% m;//gives location in the capacity

        if(storage[loc].contains(key)){//if the key is at LL loc
            
            storage[loc].remove(storage[loc].indexOf(key));//remove the index of the key (found key by finding the index of the key)
            n--;//shrink size
            return true; //key was removed

        }

        else {
           return false;//key was not there
            
        }
    }

    public int size () {

	return n;

    }

    public int getNumberCollisions () {

	return collisions;

    }

    private int hash (E key) {

	return key.hashCode();
	
    }

} // class ChainedHashSet
