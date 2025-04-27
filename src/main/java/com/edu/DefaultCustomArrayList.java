package com.edu;

import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    private long dataSize = 0;
    private long size = 5;
    E[] elements;


    public DefaultCustomArrayList(Class<E> type) {
        elements = (E[]) Array.newInstanse(type, size);
    }

    @Override
    public boolean add(E element) {
        if (dataSize >= size) {
            element = Arrays.c
        }
        return true;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    private void remove(int index) {
    }

    @Override
    public E get(int index) {

        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}