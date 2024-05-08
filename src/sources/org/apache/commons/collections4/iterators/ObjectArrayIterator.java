package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ObjectArrayIterator<E> implements ResettableIterator<E> {
    public final E[] array;
    public final int endIndex;
    public int index;
    public final int startIndex;

    public ObjectArrayIterator(E... eArr) {
        this(eArr, 0, eArr.length);
    }

    public E[] getArray() {
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
            E[] eArr = this.array;
            int i10 = this.index;
            this.index = i10 + 1;
            return eArr[i10];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public ObjectArrayIterator(E[] eArr, int i10) {
        this(eArr, i10, eArr.length);
    }

    public ObjectArrayIterator(E[] eArr, int i10, int i11) {
        this.index = 0;
        if (i10 >= 0) {
            if (i11 <= eArr.length) {
                if (i10 > eArr.length) {
                    throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
                }
                if (i11 >= i10) {
                    this.array = eArr;
                    this.startIndex = i10;
                    this.endIndex = i11;
                    this.index = i10;
                    return;
                }
                throw new IllegalArgumentException("End index must not be less than start index");
            }
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        }
        throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
    }
}
