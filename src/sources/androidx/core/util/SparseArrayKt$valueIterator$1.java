package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SparseArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, zd.a {
    public final /* synthetic */ SparseArray<T> $this_valueIterator;
    private int index;

    public SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseArray.valueAt(i10);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
