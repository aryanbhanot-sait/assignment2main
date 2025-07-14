package implementations;

import java.util.NoSuchElementException;

import utilities.ListADT;
import utilities.Iterator;

/**
 * Implementation of a Doubly Linked List using MyDLLNode.
 * @param <E> the type of elements stored in this list
 */
public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    /**
     * Create an empty list.
     */
    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Inserts the given element at the given position in this list.
     * @param index The index at which the element is to be inserted
     * @param toAdd The element to be inserted
     * @return true if the element is added successfully
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element");
        }
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        
        if (size == 0) {
            // First element
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            // Insert at the beginning
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else if (index == size) {
            // Insert at the end
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            // Insert in the middle
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }
        
        size++;
        return true;
    }

    /**
     * Appends the given element to the end of this list.
     * @param toAdd Element to be added to this list
     * @return true if element is added successfully
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element");
        }
        
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        
        size++;
        return true;
    }

    /**
     * Appends all elements from another list to this list.
     * @param toAdd The new sub list to be added
     * @return true if the operation is successful
     * @throws NullPointerException if the list to add is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null list");
        }
        
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return true;
    }

    /**
     * Returns the element at the given position in this list.
     * @param index Index of element to return
     * @return The element at the given position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        return current.getElement();
    }

    /**
     * Removes the element at the given position in this list.
     * @param index The index of the element to remove
     * @return The removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        E removedElement = current.getElement();
        
        if (size == 1) {
            // Only 1 element
            head = null;
            tail = null;
        } else if (index == 0) {
            // Remove first element
            head = current.getNext();
            head.setPrevious(null);
        } else if (index == size - 1) {
            // Remove last element
            tail = current.getPrevious();
            tail.setNext(null);
        } else {
            // Remove middle element
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        
        size--;
        return removedElement;
    }

    /**
     * Removes the first occurrence of the given element from this list.
     * @param toRemove The element to be removed
     * @return The removed element, or null if not found
     * @throws NullPointerException if the element is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null element");
        }
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(current.getElement())) {
                return remove(i);
            }
            current = current.getNext();
        }
        
        return null;
    }

    /**
     * Replaces the element at the given position in this list.
     * @param index Index of the element to replace
     * @param toChange Element to be stored at the given position
     * @return The element previously at the given position
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null element");
        }
        
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        E oldElement = current.getElement();
        current.setElement(toChange);
        return oldElement;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the given element.
     * @param toFind The element whose presence in this list is to be tested
     * @return true if this list contains the given element
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null element");
        }
        
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toFind.equals(current.getElement())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns an array containing all of the elements in this list.
     * @param toHold The array into which the elements of this list are to be stored
     * @return An array containing the elements of this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        
        if (toHold.length < size) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) new Object[size];
            
            MyDLLNode<E> current = head;
            for (int i = 0; i < size; i++) {
                newArray[i] = current.getElement();
                current = current.getNext();
            }
            
            return newArray;
        }
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = current.getElement();
            current = current.getNext();
        }
        
        if (toHold.length > size) {
            toHold[size] = null;
        }
        
        return toHold;
    }

    /**
     * Returns an array containing all of the elements in this list.
     * @return An array containing all of the elements in this list
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getElement();
            current = current.getNext();
        }
        
        return array;
    }

    /**
     * Returns an iterator over the elements in this list.
     * @return An iterator over the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    /**
     * Iterator class for MyDLL.
     */
    private class MyDLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list");
            }
            
            E element = current.getElement();
            current = current.getNext();
            return element;
        }
    }
}
