// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A queue implemented using stacks.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class QueueOfStacks <E> implements AmhQueue <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The stack in which the queue's elements will be stored. */
    private AmhStack<E> _stack;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty queue.
     */
    public QueueOfStacks () {

	// Specifically use a WrapperStack, which is a type of AmhStack, to
	// store the elements.
	_stack = new WrapperStack<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the tail of the queue.(add element to bottom of stack)
     *
     * @param element The element to add to the queue.
     * @throws IllegalStateException if the queue cannot be expanded
     *                               to accomodate the additional element.
     */
    public void add (E element) throws IllegalStateException {

        WrapperStack<E> s2 = new WrapperStack<E>();//create second empty stack


        while(_stack.size() != 0){//while the original stack is not empty

            s2.push(_stack.pop());//push to second stack what was popped from the first
            //(so now the top of the stack is the bottom and vice versa)
        
        }

        _stack.push(element);//now that _stack is empty, add element(so it is the new bottom of the stack/tail)

        while(s2.size() != 0){//while the second stack is not empty
            
            _stack.push(s2.pop());//putting th elements back with new element at the bottom of the stack/
            //tail of the queue
        
        }
        
	
    } // add ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the head of the queue.(remove top of the stack)
     *
     * @return the element taken from the head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E remove () throws NoSuchElementException {
        return _stack.pop();//return element at the top of the stack/head of the queue

	
    } // remove ()
    // ==========================================================================


    
    // ==========================================================================
    public E peek () throws NoSuchElementException {

        return _stack.top();//return the element at the top of the stack/head of the queue

    } // peek ()
    // ==========================================================================


    
    // ==========================================================================
    public int size () {

        return _stack.size();

	// TO DO
	
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class QueueOfStacks
// ==============================================================================
