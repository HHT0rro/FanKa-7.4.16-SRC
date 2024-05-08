package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: LongSparseArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LongSparseArrayKt$valueIterator$1<T> implements Iterator<T>, zd.a {
    public final /* synthetic */ LongSparseArray<T> $this_valueIterator;
    private int index;

    public LongSparseArrayKt$valueIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_valueIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    @Override // java.util.Iterator
    public T next() {
        LongSparseArray<T> longSparseArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return longSparseArray.valueAt(i10);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
