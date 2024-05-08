package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ArrayIterator<E> implements ResettableIterator<E> {
    public final Object array;
    public final int endIndex;
    public int index;
    public final int startIndex;

    public ArrayIterator(Object obj) {
        this(obj, 0);
    }

    public void checkBound(int i10, int i11, String str) {
        if (i10 > i11) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s beyond the end of the array. ");
        }
        if (i10 >= 0) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s before the start of the array. ");
    }

    public Object getArray() {
        return this.array;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public E next() {
        if (hasNext()) {
            Object obj = this.array;
            int i10 = this.index;
            this.index = i10 + 1;
            return (E) Array.get(obj, i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public ArrayIterator(Object obj, int i10) {
        this(obj, i10, Array.getLength(obj));
    }

    public ArrayIterator(Object obj, int i10, int i11) {
        this.array = obj;
        this.startIndex = i10;
        this.endIndex = i11;
        this.index = i10;
        int length = Array.getLength(obj);
        checkBound(i10, length, "start");
        checkBound(i11, length, "end");
        if (i11 < i10) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }
}
