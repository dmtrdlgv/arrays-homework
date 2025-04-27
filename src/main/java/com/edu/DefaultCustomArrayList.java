package com.edu;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    private int dataSize = 0;
    private int capacity = 10;
    private static final int GROW_SIZE = 5;
    E[] elements;


    public DefaultCustomArrayList() {
        elements = (E[]) new Object[capacity];

    }

    @Override
    public boolean add(E element) {
        if (dataSize >= capacity) {
            elements = Arrays.copyOf(elements, capacity + GROW_SIZE);
            capacity += GROW_SIZE;
        }
        elements[dataSize] = element;
        dataSize ++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        E[] buffer = (E[]) new Object[capacity];
        if (dataSize == 0) throw new IndexOutOfBoundsException("Element is not found. Array is empty");
        for (int i = 0; i < elements.length; i++) {
            if (element.equals(elements[i])) {
                dataSize --;
                continue;
            }
            buffer[i] = elements[i];
        }
        elements = Arrays.copyOf(buffer,capacity);
        return true;
    }

    private void remove(int index) {
        if (index >= dataSize) throw new IndexOutOfBoundsException();
        E[] buffer = (E[]) new Object[capacity];
        if (dataSize == 0) throw new IndexOutOfBoundsException("Element is not found. Array is empty");
        for (int i = 0; i < elements.length; i++) {
            if (index == i) {
                continue;
            }
            buffer[i] = elements[i];
            dataSize --;
        }
    }

    @Override
    public E get(int index) {
        if (dataSize == 0) throw new IndexOutOfBoundsException("Element is not found. Array is empty");
        if (index >= dataSize) throw new IndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public int size() {
        return dataSize;
    }

    @Override
    public boolean isEmpty() {
        return dataSize == 0;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[capacity];
        dataSize = 0;
    }

    @Override
    public boolean contains(E element) {
        boolean ifFounded = false;
        if (dataSize == 0) throw new IndexOutOfBoundsException("Element is not found. Array is empty");
        for (int i = 0; i < elements.length; i++) {
            if (element.equals(elements[i])) {
                ifFounded = true;
                break;
            }
        }
        return ifFounded;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E> {
        private int dataIndex = 0;
        private int lastReturnIndex = -1;

        @Override
        public boolean hasNext() {
            return dataIndex < dataSize;
        }

        @Override
        public E next() {
            if (dataIndex >= dataSize) {
                throw new NoSuchElementException("Index out of elements index interval");
            }
            lastReturnIndex = dataIndex;
            return elements[dataIndex++];
        }

        @Override
        public void remove() {
            if (lastReturnIndex < 0) {
                throw new IllegalStateException("remove() called before next(), or called twice.");
            }
            System.arraycopy(elements, lastReturnIndex + 1, elements, lastReturnIndex, dataSize - lastReturnIndex - 1);
            elements[dataSize--] = null;
            dataIndex = lastReturnIndex;
            lastReturnIndex = -1;
        }

    }


}