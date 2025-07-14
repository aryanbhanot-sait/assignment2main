package implementations;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.ListADT;
import utilities.Iterator;

/**
 * A custom implementation of an ArrayList using a standard Java array.
 * @param <E> the type of elements stored in this list
 */
public class MyArrayList<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    /**
     * Constructs an empty list with an initial capacity based on the DEFAULT_CAPPACITY constant.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
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
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index The index at which the element is to be inserted
     * @param toAdd The element to be inserted
     * @return true if the element is added successfully
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Can't add null element");
        }
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // Resize array if needed
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        
        // Shift elements to make space
        System.arraycopy(elements, index, elements, index + 1, size - index);
        
        elements[index] = toAdd;
        size++;
        return true;
    }

    /**
     * Appends element to the end of this list.
     * @param toAdd Element to be appended to this list
     * @return true if element is appended successfully
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Can't add null element");
        }
        
        // Resize array if needed
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        
        elements[size] = toAdd;
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
            throw new NullPointerException("Can't add null list");
        }
        
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index Index of element to return
     * @return The element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
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
        
        E removedElement = elements[index];
        
        // Shift elements to fill the gap
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        
        elements[size - 1] = null;
        size--;
        
        return removedElement;
    }

    /**
     * Removes the first instance of the specified element from this list.
     * @param toRemove The element to be removed
     * @return The removed element, or null if not found
     * @throws NullPointerException if the element is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null element");
        }
        
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {
                return remove(i);
            }
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
        
        E oldElement = elements[index];
        elements[index] = toChange;
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
     * Returns true if this list contains the specified element.
     * @param toFind The element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws NullPointerException if the element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null element");
        }
        
        for (int i = 0; i < size; i++) {
            if (toFind.equals(elements[i])) {
                return true;
            }
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
            // Create a new array of the same type if the input array is smaller
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) Arrays.copyOf(elements, size, toHold.getClass());
            return newArray;
        }
        
        System.arraycopy(elements, 0, toHold, 0, size);
        
        // If the input array is larger than the list, set the first element after the list to null
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
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns an iterator over the elements in this list.
     * @return An iterator over the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Inner iterator class for MyArrayList.
     */
    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
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
            return elements[currentIndex++];
        }
    }
}
