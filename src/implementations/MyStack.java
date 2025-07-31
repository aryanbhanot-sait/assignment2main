package implementations;

import java.util.EmptyStackException;
import utilities.StackADT;
import utilities.Iterator;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("Cannot push null");
        stack.add(toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stack.contains(toFind);
    }

    @Override
    public int search(E toFind) throws NullPointerException {
        if (toFind == null)
            throw new NullPointerException("Cannot search for null");
        int distance = 1;
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (toFind.equals(stack.get(i))) {
                return distance;
            }
            distance++;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = stack.size() - 1;
            
            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }
            
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements in the stack");
                }
                return stack.get(currentIndex--);
            }
        };
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (that == null || this.size() != that.size())
            return false;
        Iterator<E> it1 = this.iterator();
        Iterator<E> it2 = that.iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next()))
                return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = stack.get(stack.size() - 1 - i);
        }
        return array;
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        
        if (holder.length < size()) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) java.lang.reflect.Array.newInstance(
                holder.getClass().getComponentType(), size());
            
            for (int i = 0; i < size(); i++) {
                newArray[i] = stack.get(stack.size() - 1 - i);
            }
            
            return newArray;
        }
        
        for (int i = 0; i < size(); i++) {
            holder[i] = stack.get(stack.size() - 1 - i);
        }
        
        if (holder.length > size()) {
            holder[size()] = null;
        }
        
        return holder;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean stackOverflow() {
        return false;
    }
}
