package utilities;

/**
 * The StackADT interface defines the basic operations for a stack data structure.
 * @param <E> the type of elements in the stack
 */

public interface StackADT<E> 
{
    /**
     * Pushes an element onto the top of the stack.
     * @param element the element to be pushed onto the stack
     * @throws NullPointerException if the element is null
     */
    void push(E element) throws NullPointerException;

    /**
     * Removes and returns the top element from the stack.
     * @return the element that was popped from the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    E pop() throws java.util.EmptyStackException;

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    E peek() throws java.util.EmptyStackException;

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     * @return the size of the stack
     */
    int size();

    /**
     * Clears the stack, removing all elements.
     */
    void clear();

    /**
     * Returns an iterator over the elements in the stack.
     * @return an iterator for the stack
     */
    public Iterator<E> iterator();

    /**
     * Checks if the stack contains a specific element.
     * @param element the element to check for
     * @return true if the stack contains the element, false otherwise
     * @throws NullPointerException if the element is null
     */
    boolean contains(E element) throws NullPointerException;

    /**
     * Returns an array containing all elements in the stack.
     * @return an array of elements in the stack
     */
    Object[] toArray();

    /**
     * Returns an array containing all elements in the stack, with the specified type.
     * @param arr the array to store the elements
     * @return an array containing the elements of the stack
     * @throws NullPointerException if the provided array is null
     */
    E[] toArray(E[] arr) throws NullPointerException;

    /**
     * Searches for an element in the stack and returns its position.
     * @param element the element to search for
     * @return the position of the element in the stack, or -1 if not found
     * @throws NullPointerException if the element is null
     */
    int search(E element) throws NullPointerException;
}