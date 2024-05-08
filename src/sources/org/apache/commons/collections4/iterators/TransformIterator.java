package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformIterator<I, O> implements Iterator<O> {
    private Iterator<? extends I> iterator;
    private Transformer<? super I, ? extends O> transformer;

    public TransformIterator() {
    }

    public Iterator<? extends I> getIterator() {
        return this.iterator;
    }

    public Transformer<? super I, ? extends O> getTransformer() {
        return this.transformer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public O next() {
        return transform(this.iterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    public void setIterator(Iterator<? extends I> it) {
        this.iterator = it;
    }

    public void setTransformer(Transformer<? super I, ? extends O> transformer) {
        this.transformer = transformer;
    }

    public O transform(I i10) {
        return this.transformer.transform(i10);
    }

    public TransformIterator(Iterator<? extends I> it) {
        this.iterator = it;
    }

    public TransformIterator(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer) {
        this.iterator = it;
        this.transformer = transformer;
    }
}
