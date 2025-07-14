package implementations;

/**
 * Generic node class for doubly linked list.
 * @param <E> the type of element stored in the node
 */
public class MyDLLNode<E> {
    private E element;
    private MyDLLNode<E> previous;
    private MyDLLNode<E> next;

    /**
     * Constructs a node with the given element.
     * @param element the element to be stored in the node
     */
    public MyDLLNode(E element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    /**
     * Constructs a node with the given element, previous, and next nodes.
     * @param element the element to be stored in the node
     * @param previous the previous node in the list
     * @param next the next node in the list
     */
    public MyDLLNode(E element, MyDLLNode<E> previous, MyDLLNode<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Gets the element stored in this node.
     * @return the element stored in this node
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     * @param element the new element to be stored
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Gets the previous node.
     * @return the previous node
     */
    public MyDLLNode<E> getPrevious() {
        return previous;
    }

    /**
     * Sets the previous node.
     * @param previous the new previous node
     */
    public void setPrevious(MyDLLNode<E> previous) {
        this.previous = previous;
    }

    /**
     * Gets the next node.
     * @return the next node
     */
    public MyDLLNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node.
     * @param next the new next node
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
}
