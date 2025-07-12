package utilities;
import exceptions.EmptyQueueException;

/**
 * The QueueADT interface defines the basic operations for a queue data structure.
 * @param <E> the type of elements in the queue
 */

public interface QueueADT<E> 
{
    /**
     * Adds an element to the end of the queue.
     * @param element the element to be added to the queue
     * @throws NullPointerException if the element is null
     */
    void enqueue(E element) throws NullPointerException;

    /**
     * Removes and returns the front element from the queue.
     * @return the element that was removed from the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E dequeue() throws EmptyQueueException;

    /**
     * Returns the front element of the queue without removing it.
     * @return the front element of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E peek() throws EmptyQueueException;

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue
     */
    int size();

    /**
     * Clears the queue, removing all elements.
     */
    void clear();

    /**
     * Returns an iterator over the elements in the queue.
     * @return an iterator for the queue
     */
    public Iterator<E> iterator();

    /**
     * Checks if the queue contains a specific element.
     * @param element the element to check for
     * @return true if the queue contains the element, false otherwise
     * @throws NullPointerException if the element is null
     */
    boolean contains(E element) throws NullPointerException;

    /**
     * Returns an array containing all elements in the queue.
     * @return an array of elements in the queue
     */
    Object[] toArray();

    /**
     * Returns an array containing all elements in the queue, with the specified type.
     * @param arr the array to fill with elements from the queue
     * @return an array containing the elements of the queue
     * @throws NullPointerException if the provided array is null
     */
    E[] toArray(E[] arr) throws NullPointerException;

    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise
     */
    boolean isFull();

    /**
     * Compares this queue with another queue for equality.
     * @param otherQueue the queue to compare with
     * @return true if both queues are equal, false otherwise
     */
    boolean equals(QueueADT<E> otherQueue);
}