package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public E pop() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public E push(E e2) {
        add(e2);
        return e2;
    }

    public int search(Object obj) {
        int i10 = 1;
        int size = size() - 1;
        while (size >= 0) {
            E e2 = get(size);
            if ((obj == null && e2 == null) || (obj != null && obj.equals(e2))) {
                return i10;
            }
            size--;
            i10++;
        }
        return -1;
    }

    public ArrayStack(int i10) {
        super(i10);
    }

    public E peek(int i10) throws EmptyStackException {
        int size = (size() - i10) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }
}
