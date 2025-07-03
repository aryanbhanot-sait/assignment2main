package utilities;

import exceptions.EmptyQueueException;

public interface QueueADT<E> {

    void enqueue(E element) throws NullPointerException;
    E dequeue() throws EmptyQueueException;
    E peek() throws EmptyQueueException;
    boolean isEmpty();
    int size();
    void clear();
    java.util.Iterator<E> iterator();
}