package utilities;

public interface StackADT<E> {

    void push(E element) throws NullPointerException;
    E pop() throws java.util.EmptyStackException;
    E peek() throws java.util.EmptyStackException;
    boolean isEmpty();
    int size();
    void clear();
    java.util.Iterator<E> iterator();
}