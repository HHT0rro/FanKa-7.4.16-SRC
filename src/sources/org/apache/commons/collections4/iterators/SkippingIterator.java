package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SkippingIterator<E> extends AbstractIteratorDecorator<E> {
    private final long offset;
    private long pos;

    public SkippingIterator(Iterator<E> it, long j10) {
        super(it);
        if (j10 >= 0) {
            this.offset = j10;
            this.pos = 0L;
            init();
            return;
        }
        throw new IllegalArgumentException("Offset parameter must not be negative.");
    }

    private void init() {
        while (this.pos < this.offset && hasNext()) {
            next();
        }
    }

    @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
    public E next() {
        E e2 = (E) super.next();
        this.pos++;
        return e2;
    }

    @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
    public void remove() {
        if (this.pos > this.offset) {
            super.remove();
            return;
        }
        throw new IllegalStateException("remove() can not be called before calling next()");
    }
}
