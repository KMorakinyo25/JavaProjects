// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A stack implemented using queues.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class StackOfQueues <E> implements AmhStack <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The queue in which the stack's elements will be stored. */
    private AmhQueue<E> _queue;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty stack.
     */
    public StackOfQueues () {

	// Specifically use a WrapperQueue, which is a type of AmhQueue, to
	// store the elements.
	_queue = new WrapperQueue<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the top of the stack.(first thing to come out in a queue)
     *
     * @param element The element to add to the stack.
     * @throws IllegalStateException if the stack cannot be expanded
     *                               to accomodate the additional element.
     */
    public void push (E element) throws IllegalStateException {

        WrapperQueue<E> q2 = new WrapperQueue<E>();//create second empty stack
        
        while(_queue.size() != 0){//while the _queue is not empty
            q2.add(_queue.remove());//add to the second stack what was removed from the first
            //(same order as first queue but in another queue))
        }

        _queue.add(element);//add newest element to the _queue

        while(q2.size() != 0 ){
            _queue.add(q2.remove());//put the elements back in the first queue with newest 
            //element at the head)
        }
        
    } // push ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the top of the stack.(take out first element in a queue)
     *
     * @return the element taken from the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */    
    public E pop () throws NoSuchElementException {
        return _queue.remove();//return the first element in a queue which = top of the stack

    } // pop ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Obtain the top element on the stack without removing it.
     *
     * @return the element at the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public E top () throws NoSuchElementException {
         
        return _queue.peek();

	// TO DO
	
    } // top ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Provide the number of elements on the stack.
     *
     * @return the length of the stack.
     */
    public int size () {

        return _queue.size();
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class StackOfQueues
// ==============================================================================
